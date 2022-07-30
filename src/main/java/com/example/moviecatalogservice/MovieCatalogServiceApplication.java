package com.example.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogServiceApplication {
	//Rest template builder :
	@Bean
	RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	WebClient.Builder getWebClient()
	{
		WebClient.Builder builder = WebClient.builder();
		return builder;
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
