package girirajvyasblog.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class RateController {

	
	@Value("${rate}")
	String rate;
	
	@Value("${tollstart}")
	String tollstart;
	
	@Value("${lanecount}")
	String lanecount;

	@Value("${connstring}")
	String connstring;
	
	@RequestMapping("/rate")
	public String getRates(Model m){
		
		m.addAttribute("rateamount", rate);
		m.addAttribute("lanes", lanecount);
		m.addAttribute("tollstart", tollstart);
		m.addAttribute("connstring",connstring);
		//name of the view
		return "rateview";
	}
	
}
