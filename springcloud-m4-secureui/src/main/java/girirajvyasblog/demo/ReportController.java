package girirajvyasblog.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter{

	@Autowired
	private OAuth2ClientContext clientContext;
	
	@RequestMapping("/")
	public String loadHome(){
		return "home";
	}
	
	@RequestMapping("/reports")
	public String loadReports(Model model){
		OAuth2AccessToken t = clientContext.getAccessToken();
		System.out.println("Token: " + t.getValue());//04b3d7b666c39f9a18c106ba6ce14b8a385b5482
		return "reports";
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/", "/login**").permitAll()
								.anyRequest().authenticated();
		
		
	}
}
