package com.example.soapclient;

import hello.wsdl.GetUniversityResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapclientApplication.class, args);

    }
    @Bean
    CommandLineRunner lookup(UniversityClient quoteClient) {
        return args -> {
            String university = "Strathmore";

            if (args.length > 0) {
                university = args[0];
            }
            GetUniversityResponse response = quoteClient.getUniversity(university);
            System.err.println(response.getUniversity().getName());
        };
    }

}
