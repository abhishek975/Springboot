package com.example.demo;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String handleTest() {
		 return "Its Working";
	}
	
	
}
