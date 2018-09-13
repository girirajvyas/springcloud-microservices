package girirajvyasblog.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringcloudSecureserviceModule4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudSecureserviceModule4Application.class, args);
	}
	
	@RequestMapping("/tolldata")
	public ArrayList<TollUsage> getTollData() {
		
		TollUsage instance1 = new TollUsage("200", "station150", "B65GT1W", "2016-09-30T06:31:22");
		TollUsage instance2 = new TollUsage("201", "station119", "AHY673B", "2016-09-30T06:32:50");
		TollUsage instance3 = new TollUsage("202", "station150", "ZN2GP0", "2016-09-30T06:37:01");
		
		ArrayList<TollUsage> tolls = new ArrayList<TollUsage>();
		tolls.add(instance1);
		tolls.add(instance2);
		tolls.add(instance3);
		
		return tolls;
	}
	
	public class TollUsage{
		
		public String id;
		public String stationId;
		public String licensePlate;
		public String timestamp;
		
		public TollUsage(){
			
		}
		
		public TollUsage(String id, String stationId, String licensePlate, String timestamp) {
			super();
			this.id = id;
			this.stationId = stationId;
			this.licensePlate = licensePlate;
			this.timestamp = timestamp;
		}
	}
	
}
