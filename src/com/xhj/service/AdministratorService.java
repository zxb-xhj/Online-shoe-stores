package com.xhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.bean.Administrator;
import com.xhj.dao.AdministratorMapper;


@Service
public class AdministratorService {
	
	@Autowired
	AdministratorMapper mapper;
	
	public Administrator selectall(Administrator administrator){
		return mapper.selectall(administrator);
	}
	
	public List<Administrator> selectalls(){
		return mapper.selectByExample(null);
	}
	
}
