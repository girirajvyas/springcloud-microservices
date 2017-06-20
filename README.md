# springcloud-microservices
Microservices implemented through spring cloud and spring boot

**Spring Boot**

 Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can “just run”. We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.
 You can use Spring Boot to create Java applications that can be started using java -jar or more traditional war deployments. We also provide a command line tool that runs “spring scripts”.

 Our primary goals are:

 * Provide a radically faster and widely accessible getting started experience for all Spring development.
 * Be opinionated out of the box, but get out of the way quickly as requirements start to diverge from the defaults.
 * Provide a range of non-functional features that are common to large classes of projects (e.g. embedded servers, security, metrics, health checks, externalized configuration).
 * Absolutely no code generation and no requirement for XML configuration
 
 **Spring Boot Actuator**
 
 It is a sub-project of Spring Boot. It adds several production grade services to your application with little effort on your part
 
 **Spring cloud**
 
 Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration   management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus, one-time tokens, global locks, leadership election, distributed sessions, cluster state). Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns. They will work well in any distributed environment, including the developer's own laptop, bare metal data centres, and managed platforms such as Cloud Foundry.
 

## Prerequisites

1. **STS**: http://spring.io/tools/sts  (3.8.4 as on 17/06/2017)
The Spring Tool Suite is an Eclipse-based development environment that is customized for developing Spring applications.
**Note**: Download STS according to your OS i.e 32 bit or 64 Bit else you might get **"Java was started but returned exit code=13"**

2. **7Zip**: http://www.7-zip.org/ 
To unzip the STS package you just downloaded above.
While unzipping with Winzip you may get the **"path too long for folder"** error. And to avoid this unzip via 7Zip. 

3. **Postman**: https://www.getpostman.com/ (download exe and it requires .NET to be installed in your system or you can add plugin in chrome)
A powerful GUI platform to make your API development faster & easier, from building API requests through testing

4. **Vagrant**: https://www.vagrantup.com/downloads.html
It provides virtual environment for application to run.
Vagrant provides the same, easy workflow regardless of your role as a developer, operator, or designer. It leverages a declarative configuration file which describes all your software requirements, packages, operating system configuration, users, and more.

**Docker**: An alternative for Vagrant.

5. **RabbitMQ**: https://www.rabbitmq.com/install-windows.html , http://www.erlang.org/download.html
*From wiki* : RabbitMQ is open source message broker software (sometimes called message-oriented middleware) that implements the Advanced Message Queuing Protocol (AMQP). The RabbitMQ server is written in the Erlang programming language and is built on the Open Telecom Platform framework for clustering and failover. Client libraries to interface with the broker are available for all major programming languages.

**Note**: We can also install image of RabbitMQ and MySql on **Vagrant** or **Docker**

6. **Java**: http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
Download JAVA 8, as it is mandatory requirement for STS
Install the JDK > Setup "JAVA_Home" System variable Right click on Control panel > Advanced system settings > Environment variables > New)and set this in Path variable.
Eg: JAVA_HOME - C:\Program Files\Java\jdk1.8.0_73
Check: ```java -version```

7. **Maven**: http://maven.apache.org/download.cgi
Download the Binary folder > Setup "M2_Home" environment variable and set this in Path variable.
**Note**: Setting up Java is mandatory for maven.
EG: M2_Home - C:\Maven\apache-maven-3.3.1-bin\apache-maven-3.3.1
check: ```mvn -version```

**Gradle**: An alternative for Maven.

## Workspace
*Create a new workspace folder if you are switching from Eclipse,IntelliJ or any other IDE to STS. As all the IDEs have there specific settings inside the Workspace folder it is good if we start with a clean slate.*

## Spring Starter Project
This step will be repeated number of times during the project

File > New > **Spring Starter Project**

Select **Java**: 8 , **Type**: Maven(In case you have to use Gradle, you have to install it first before selecting as it will give you error)

**Group**: girirajvyasblog.demo (Same as package)

**Artifact**: springcloud-startup-module1 (your application name)

**version**: populate by default, let it as it is.

**Description**: Demo project for Spring Boot (*Description about your project*)

**package**: girirajvyasblog.demo

Click **Next**

**Spring Boot Version**: 1.5.4

**Select** : spring modules that we want to use. (mostly we will be using Web, Actuator, config-server, config-client)

Click **Finish**

*It will take some time to get all the dependencies downloaded on your local machine. It is done by maven which reads pom.xml and resolves the dependencies.*

The entry that does almost all the autoconfiguration is below:
```
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.4.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
```

## 1. Module 1 :  springcloud-startup-module1
*This is just for getting started with spring-boot. We will try to create a **REST** Webservice and try to test it with **POSTMAN** *

a. Create **Spring Starter Project** with below values

b. Edit **application.properties** 

c. Edit SpringBoot main class


## 2. Module 2 : springcloud-configserver-module2



References:
**GIT**

For Github flavored markdown: 
* https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet
* https://guides.github.com/features/mastering-markdown/

 Adding new Repository via Git Bash (*it is not possible to do it with Egit plugin*)
 * https://help.github.com/articles/adding-an-existing-project-to-github-using-the-command-line/

 
 *Spring Boot Actuator*
 * https://spring.io/guides/gs/actuator-service/
 * http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready
 
 *Spring cloud*
 * http://projects.spring.io/spring-cloud/

 *Spring cloud security*
 * http://cloud.spring.io/spring-cloud-security/spring-cloud-security.html
