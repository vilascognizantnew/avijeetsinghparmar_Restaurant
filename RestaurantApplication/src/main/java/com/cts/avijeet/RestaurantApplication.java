package com.cts.avijeet;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cts.avijeet.dao.MenuDAO;
import com.cts.avijeet.model.Menu;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	

	@Bean
	CommandLineRunner initDatabase(final MenuDAO repository) {

		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return args -> {
			repository.save(new Menu(1, "Ice Cream", 100, format.parse("2020-10-23")));
			repository.save(new Menu(2, "Butter milk", 120,format.parse("2020-09-15")));
			repository.save(new Menu(3, "Rice", 80, format.parse("2020-04-01")));
			repository.save(new Menu(4, "Paneer", 1000, format.parse("2019-04-01")));
			repository.save(new Menu(5, "Daal", 140, format.parse("2018-04-01")));
			repository.save(new Menu(6, "Papad", 80, format.parse("2017-01-01")));
		};
	}
}
