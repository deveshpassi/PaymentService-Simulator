package com.dev.paymetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PaymetServiceApplication {

      public static void main(String[] args) {
            SpringApplication.run(PaymetServiceApplication.class, args);
      }

}
