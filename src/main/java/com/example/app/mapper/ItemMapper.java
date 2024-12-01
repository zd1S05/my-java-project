package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Item;

public interface ItemMapper {
	
	List<Item> selectAll() throws Exception;
	
	Item selectById(Integer id) throws Exception;
	
	Long count() throws Exception;
	
	List<Item> selectLimited(@Param("offset")int offset,
							 @Param("numPerPage") int numPerPage)
							 throws Exception;
	
	void insert(Item item) throws Exception;
	void update(Item item) throws Exception;
	void delete(Integer id) throws Exception;
}	
