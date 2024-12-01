package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Item;
import com.example.app.mapper.ItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	
	private final ItemMapper itemmapper;

	@Override
	public List<Item> getItemList() throws Exception {
		return itemmapper.selectAll();
	}

	@Override
	public Item getItemById(Integer id) throws Exception {
		return itemmapper.selectById(id);
	}

	@Override
	public int getTotalPages(int numPerPage) throws Exception {
		double totalNum = (double) itemmapper.count();
		return (int) Math.ceil(totalNum/numPerPage);
	}

	@Override
	public List<Item> getItemListByPage(int page, int numPerPage) throws Exception {
		int offset = numPerPage*(page-1);
		return itemmapper.selectLimited(offset, numPerPage);
	}

	@Override
	public void addItem(Item item) throws Exception {
		itemmapper.insert(item);		
	}

	@Override
	public void editItem(Item item) throws Exception {
		itemmapper.update(item);		
	}

	@Override
	public void deleteItem(Integer id) throws Exception {
		itemmapper.delete(id);
	}
}
