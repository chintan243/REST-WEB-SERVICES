package com.dwarkatourism.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//@GetMapping("/hello-world")
	@RequestMapping(method= RequestMethod.GET, path="/hello-world" )
	public String HelloWorld(){
		return "Dwarka Tourism";
	}
	
	// hello-world-bean/path-variable/chintan
	@GetMapping("/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World , %s", name)  );
	}
}
