## What is Micro service Architecture?

"Loosely coupled service oriented architecture with bounded context"  

Micro-services with Spring Cloud
Release march 2015


## Why are popular?

 * Desire for faster changes
 * Need for greater availability - less time to recover
 * Motivation for fine grained scaling (scale service wise), while in Monolothic -  scale DB, message tier, Application tier
 * Compatible with a DevOps mindset

## Characteristics?

 * Components exposed as services
 * Tied to a specific domain
 * Loosely coupled
 * Built to tolerate failure
 * Delivered continuously via automation
 * Built an run by independent services

## Frequent Questions:
 1. Should every application be turned into a set of micro-services?  
 - NO

 2. How do I find my service if URIs can change?  
 - Service catalogue is the answer - Eureka server  

 3. How am I supposed to ship changes continuously?  
 - As services are independent of each other, easy to ship changes continuously

 4. How do services maintain consistent configurations at scale?  
 - cloud configurations

 5. Is there a single Technology stack for these systems?  
 - No, there are multiple opinions available and you can choose according to your requirement

 6. How do I keep a poor-performing service form taking everything down  
 - circuit breaker, ZipKin Spring cloud sleuth
 
 7. What is the right way to secure services  
 - Spring cloud security

 8. How do I troubleshoot problems  
 - Sleuth

 9. Is not Monolith simpler  
 - Depend on the case to case.


Boot:  
 - opinionated runtime for Spring
 - Convention not configurations
 - "Opinions can be overridden"
 - Handles Boilerplate set-up
 - simple dependency management
 - Embeds application server in executable jar 
 - Built in endpoints for health metrics - Actuator framework

 - spring.io -> start.spring.io - spring InitialiZr -> STS

Application we will develop
Toll station
 1. First part
  Toll station systems
            |
            |
    Toll Rate service
            |
            |
       Config server ---> Git server

 2. Second Part
                                            Internal Web Application

  A. Toll Process Job                        B. Toll Usage Service(Secured)          C. Driver Profile Service ---create graph
          |                                              |                                      | 
          |                                                 |                                      |
     Task Processor  ---> Task history               AuthZ Server                           Zipkin Server
                       ---> Message Bus
                    
Goals:
 - Understand modern micro-services pattern
 - Get comfortable starting Spring boot and cloud projects
 - Explore core capabilities of spring cloud
 - learn how to configure and extend spring cloud

 ---------
 Overview: 
 - Role of configuration in micro-services
 - problems with status quo
 - Creating a config server
 - Consuming configurations in application
 
 Role of configuration in micro-services
 
  * Removing 'settings' from compiled code
  * Change runtime behaviours
  * Enforce consistency across elastic services
  * Cache values to reduce load on databases
  
 Problems with status quo (current/existing solutions)

  * Local config files fall out of sync
  * No history of changes with env variables
  * Configuration changes require restart
  * Challenges with sensitive information
  * Inconsistent usage aross team

Spring Cloud Config:  
 - Http Access to git or file based configurations

Creating config server:

 * Choose a config store
 * Add config files
 * build the spring projects
 * secure the configurations

Setting up config files:  
 - Native support for YML, Property files
 - Can serve out any text file
 - File name contain app, optionally profile
 - Nested folders supported
 - All Matching files returned

Creating config server: Spring boot projects  
 1. use start.spring.io/STS to generate scaffolding
 2. See POM dependency on "spring-cloud-config-server" and "spring-boot-starter-actuator"
 3. Add @EnableConfigServer annotation to class
 4. Create Application property (or .yml file) with server port, app name and profile
 
Create Spring starter projects  
 - Annotate the main class with @EnableConfigServer annotation 
 - set application properties - default path is resources/config can be configured to something else as well
 - add local configuration files - to folder resources/config app1.properties, app2.properties, app3.properties
 - Run as spring boot application
 - Query for configurations : localhost:8888/app1/default, localhost:8888/app2/default, localhost:8888/app3/default

creating the config server : application.yml
spring:
  cloud:
    config:
      server:
        encrypt:
          enabled: false
        git:
          uri: https://github.com/girirajvyas/spring-cloudconfig-pune-tolls  : Point to Git Location
          search-paths:
          - 'station*'                                                         : pattern to search sun directories
          repos:                                                             : points to alternate repos
            perf:
              pattern:
              - "*/perf"                                                     : pattern to go to alternate repo
              uri: https://github.com/girirajvyas/spring-cloudconfig-pune-tolls-perfs
              search-paths:
              - 'station*'

creating the config server: Endpoints              
https://github.com/girirajvyas/spring-cloudconfig-pune-tolls / {application} / {profile} / [/label]
<branch:master>                                                     required        required    optional
    |
    |-application.properties       - default (always returned)
    |
    |-station1                     
    |    - s1rates-dev.properties  - exact match for dev profile 
    |    - s1rates-qa.properties
    |    - s1rates.properties      - default for app name s1rates
    |-station2                     
         - s2rates-dev.properties
         - s2rates.properties      - default for app name s2rates

{application} - name of application spring.application.name value or spring cloud config name value
                spring.cloud.config.name or spring.application.name
{profile}     - spring profile (default,dev, qa)
                spring.cloud.config.env
{label}       - version marker in config source, it could be branch name tag name or even git commit hash
                spring.cloud.config.label or config sevrers default label

Examples
Appname - s1rates
/s1rates/default    - application.properties, s1rates.properties
/s1rates/dev        - application.properties, s1rates.properties, s1rates-dev.properties 
                      (in case same property is available in all 3 files, -dev 1 would take precedence)
/s2rates/qa         - application.properties, s2rates.properties
/s3rates/default    - application.properties

Demo:  
 - create github repo with files
 - Create a spring starter projects
 - Annotate the main class
 - set git url in application YAML
 - Run as spring boot
 - Experiment with search paths

Test:  
 - localhost:8888/s1rates/default
 - localhost:8888/s1rates/perf   - to fetch data from alternate repository
 - localhost:8888/s1rates.json/.yml/.properties

Consuming Configurations  
 - Spring Apps use Config servers as a property source
 - Loads values based on a. app name, b. Spring profile, c. Label
 - Annotate code with @Value attributes
 - Can consume form non-spring apps via URL

Demo:  
 - Create spring starter projects
 - Add application and bootstrap files
 - Create controller with annotations
 - Return values derived from properties
 - Experiment with different name, profiles