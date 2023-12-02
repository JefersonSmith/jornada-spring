package com.jornada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }
    

}
