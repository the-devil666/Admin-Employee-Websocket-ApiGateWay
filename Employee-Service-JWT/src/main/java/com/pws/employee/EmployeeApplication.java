package com.pws.employee;

import com.pws.employee.controller.MyWebSocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.pws.employee.utility.AuditAwareImpl;


@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.pws.employee.*"})
@EnableEurekaClient

public class EmployeeApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeApplication.class, args);
		MyWebSocketClient client = new MyWebSocketClient("ws://localhost:8081/ws");

	}

	@Bean
    public AuditorAware<String> auditorAware() {
        return new AuditAwareImpl();
    }

}
