package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Category;
import com.example.app.mapper.CategoryMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryMapper categorymapper;
	
	@Override
	public List<Category> getCategoryList() throws Exception {
		return categorymapper.selectAll();
	}

	@Override
	public Category getCategoryById(Integer id) throws Exception {
		return categorymapper.selectById(id);
	}

}
