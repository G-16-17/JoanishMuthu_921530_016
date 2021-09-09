package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.MovieCruiser;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public List<MovieCruiser> getMenuItemListAdmin() {
		return movieRepository.findAll();
	}

	public List<MovieCruiser> getMenuItemListCustomer() {
		return movieRepository.findByActiveAndDateOfLaunchBefore("Yes", new Date());
	}
	
	public MovieCruiser getMovie(int id) {
		return movieRepository.findById(id).get();
	}
	
	public void modifyMovie(MovieCruiser movie) {
		MovieCruiser newMovie = movieRepository.getOne(movie.getId());
		newMovie = movie;
		movieRepository.save(newMovie);
	}

}
