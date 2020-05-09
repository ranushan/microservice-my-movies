package com.mymovies.controller;

import com.mymovies.dto.PostersDTO;

import java.util.ArrayList;

public interface IPostersController {
	
	public ArrayList<PostersDTO> retrievePosters(String movie_id);

}
