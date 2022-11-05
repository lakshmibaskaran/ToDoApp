package com.lakshmi.springboot.ToDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication

public class ToDoAppApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ToDoAppApplication.class, args);
	}
}



/*
@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

}

*/

/*
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "com.lakshmi.springboot.ToDoApp")
public class ToDoAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return application.sources(ToDoAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class);
	}
}
*/

