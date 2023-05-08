package com.xhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.bean.Shopping;
import com.xhj.dao.ShoesMapper;
import com.xhj.dao.ShoppingMapper;



@Service
public class ShoppingServie {
	
	@Autowired
	ShoppingMapper mapper;

	public void insertall(Shopping shopping) {
		mapper.insertall(shopping);
	}
	public void deleteid(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}
	
	public int selectint() {
		return mapper.selectint();
	}
		
	public List<Shopping> selectall() {
		return mapper.selectByExample(null);
	}
	
	public int selectprice() {
		return mapper.selectprice();
	}
	
	public int deleteall() {
		return mapper.deleteByExample(null);
	}

}
