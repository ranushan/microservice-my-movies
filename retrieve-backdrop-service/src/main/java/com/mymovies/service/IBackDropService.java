package com.mymovies.service;

import java.util.ArrayList;

import com.mymovies.dto.BackDropDTO;

public interface IBackDropService {
	
	public ArrayList<BackDropDTO> retrieveBackDrop(String movie_id);

}
