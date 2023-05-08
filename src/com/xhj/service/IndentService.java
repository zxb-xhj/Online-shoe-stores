package com.xhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.bean.Indent;
import com.xhj.dao.IndentMapper;

@Service
public class IndentService {
	
	@Autowired
	IndentMapper mapper;
	
	public int insertall() {
		return mapper.insertall();
	}
	
	public int deleteding(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	public List<Indent> selectall(){
		return mapper.selectByExample(null);
	}

}
