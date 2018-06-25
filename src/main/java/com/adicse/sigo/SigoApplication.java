package com.adicse.sigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication

public class SigoApplication {
	@SuppressWarnings("unchecked")
	@Bean
	public Jackson2ObjectMapperBuilder configureObjectMapper() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		//builder.serializationInclusion(JsonInclude.Include.NON_EMPTY);
		builder.modulesToInstall(Hibernate5Module.class);
		return builder;

	}
	public static void main(String[] args) {
		SpringApplication.run(SigoApplication.class, args);
	}
}
