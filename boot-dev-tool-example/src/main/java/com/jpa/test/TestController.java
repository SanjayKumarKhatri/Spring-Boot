package com.jpa.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		
		int a = 12;
		int b = 65;
		int c = 87;
		int d = 890;
		
		return "Sum of a and b and c and d is : "+(a+b+c+d);
	}

}
