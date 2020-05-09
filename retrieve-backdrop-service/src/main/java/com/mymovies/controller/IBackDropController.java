package com.mymovies.controller;

import java.util.ArrayList;

import com.mymovies.dto.BackDropDTO;

public interface IBackDropController {
	
	public ArrayList<BackDropDTO> retrieveBackDrop(String movie_id);

}
