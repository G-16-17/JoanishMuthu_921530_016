package com.cognizant.moviecruiser;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.MovieCruiser;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

@SpringBootApplication
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	private static MovieService movieService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		movieService = context.getBean(MovieService.class);

		LOGGER.info("Inside Main.....");

		testGetAllItems();

		testGetCustomerList();

		testModifyMovie();
	}

	private static void testGetAllItems() {
		LOGGER.info("Start");
		List<MovieCruiser> movieList = movieService.getMenuItemListAdmin();
		LOGGER.debug("Movies= {}", movieList);
		LOGGER.info("End");
	}

	private static void testGetCustomerList() {
		LOGGER.info("Start");
		List<MovieCruiser> movieList = movieService.getMenuItemListCustomer();
		LOGGER.debug("Movies= {}", movieList);
		LOGGER.info("End");

	}

	private static void testModifyMovie() {
		LOGGER.info("Start");
		MovieCruiser newMovie = new MovieCruiser(3,"Robo 2","Super Hit","No",DateUtil.convertToDate("2019/06/27"),"Sci-Fi");
		movieService.modifyMovie(newMovie);
		LOGGER.debug("Movie= {}", newMovie);
		LOGGER.info("End");

	}
}
