package com.lively.io.ExcelApp;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lively.io.ExcelApp.tableGenerator.LivelyRepository;
import com.lively.io.ExcelApp.tableGenerator.Implementations.LocalLivelyRepo;

@SpringBootApplication
public class ExcelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelAppApplication.class, args);
	}

	@Bean
	public LivelyRepository getRepo(DataSource datasource) {
		return new LocalLivelyRepo();
	}
}
