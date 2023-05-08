package com.xhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.bean.Shoes;
import com.xhj.dao.ShoesMapper;



@Service
public class ShoesService {
	
	@Autowired
	ShoesMapper mapper;
	
	public List<Shoes> selectall() {
		return mapper.selectByExample(null);
	}
	
	public List<Shoes> selecthid(Shoes shoes){
		return mapper.selecthid(shoes);
	}
	
	public Shoes selectid(Integer id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public List<Shoes> selectname(Shoes shoes){
		return mapper.selectname(shoes);
	}
	
	public int deletesid(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	public int update(Shoes shoes) {
		return mapper.updateByPrimaryKeySelective(shoes);
	}
	
	public int insertall(Shoes shoes) {
		return mapper.insertSelective(shoes);
	}

}
