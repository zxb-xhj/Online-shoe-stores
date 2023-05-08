package com.xhj.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xhj.bean.Footwear;
import com.xhj.bean.Shoes;
import com.xhj.service.FootwearService;
import com.xhj.service.ShoesService;
import com.xhj.service.ShoppingServie;

@Controller
public class FootwearController {
	
	@Autowired
	ShoesService shoesService;
	
	@Autowired
	FootwearService footwearService;
	
	@Autowired
	ShoppingServie shoppingServie;
	
	@RequestMapping("/ft/{hid}")
	public String selectid(@PathVariable("hid")Integer hid,Model model) {
		List<Shoes> shoes = shoesService.selecthid(new Shoes(hid));
		List<Footwear> footwear = footwearService.selectall();
		int i = shoppingServie.selectint();
		model.addAttribute("shoes", shoes);
		model.addAttribute("footwear", footwear);
		model.addAttribute("i", i);
		return "zhuye";
	}
	


}
