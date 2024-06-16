package com.example.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class LibraryManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder  configure(SpringApplicationBuilder  builder) {

		return builder.sources(LibraryManagementApplication.class);
	}

}
