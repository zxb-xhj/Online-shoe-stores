package com.xhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.bean.Footwear;
import com.xhj.dao.FootwearMapper;



@Service
public class FootwearService {
	
	@Autowired
	FootwearMapper mapper;
	
	public List<Footwear> selectall(){
		return mapper.selectByExample(null);
	}
	
	public int insertname(Footwear record){
		return mapper.insertSelective(record);
	}
	
	public int deleteid(Integer id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	public Footwear selectid(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	public int update(Footwear footwear) {
		return mapper.updateByPrimaryKeySelective(footwear);
	}

}
