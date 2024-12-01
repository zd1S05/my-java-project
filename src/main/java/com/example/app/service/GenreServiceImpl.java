package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Genre;
import com.example.app.mapper.GenreMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
	
	private final GenreMapper genremapper;
	
	@Override
	public List<Genre> getGenreList() throws Exception {
		return genremapper.selectAll();
	}
	
	@Override
	public List<Genre> getGenreListByStyle(String style) throws Exception{
		return genremapper.selectByStyle(style);
	}
}
