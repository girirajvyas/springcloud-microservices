package io.girirajvyas.springcloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringcloudTaskModule3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTaskModule3Application.class, args);
	}
	
	@Bean
	public TollProcessingTask tollProcessingTask(){
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner{
		@Override
		public void run(String... strings) throws Exception {
			// parameters: stationId, License Plate, timeStamp
			if(null != strings){
				System.out.println("parameters length : " + strings.length);
			}
			
			String stationId = strings[1];
			String licensePlate = strings[2];
			String timestamp = strings[3];
			
			System.out.println("station Id: " + stationId + " License Plate: " +licensePlate + " timeStamp: " + timestamp);
		}
	} 
}