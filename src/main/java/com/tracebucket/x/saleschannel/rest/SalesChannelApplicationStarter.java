package com.tracebucket.x.saleschannel.rest;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.tracebucket.x.saleschannel.config"})
public class SalesChannelApplicationStarter {

	@Bean
	public Mapper mapper() {
		return new DozerBeanMapper();
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SalesChannelApplicationStarter.class, args);
	}
}
