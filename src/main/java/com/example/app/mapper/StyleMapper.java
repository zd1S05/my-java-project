package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Style;

public interface StyleMapper {

	List<Style> selectAll() throws Exception;

	Style selectById(Integer id) throws Exception;

}
