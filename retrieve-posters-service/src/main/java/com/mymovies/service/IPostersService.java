package com.mymovies.service;

import java.util.ArrayList;

import com.mymovies.dto.PostersDTO;

public interface IPostersService {
	
	public ArrayList<PostersDTO> retrievePosters(String movie_id);

}
