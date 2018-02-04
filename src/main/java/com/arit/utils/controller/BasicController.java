package com.arit.utils.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@RequestMapping("/test")
    public String index() {
        return "From Spring Boot!";
    }
	
}
