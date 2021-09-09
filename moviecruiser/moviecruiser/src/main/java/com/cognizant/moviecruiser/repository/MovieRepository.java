package com.cognizant.moviecruiser.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.MovieCruiser;

@Repository
public interface MovieRepository extends JpaRepository<MovieCruiser,Integer> {
	
	List<MovieCruiser> findByActiveAndDateOfLaunchBefore(String active, Date dateOfLaunch);

}
