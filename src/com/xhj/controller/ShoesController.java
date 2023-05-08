package com.xhj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class ShoesController {
	
	@Autowired
	ShoesService shoesService;
	
	@Autowired
	FootwearService footwearService;
	
	@Autowired
	ShoppingServie shoppingServie;
	
	@RequestMapping("/se")
	public String selectall(Model model) {
		List<Shoes> shoes = shoesService.selectall();
		List<Footwear> footwear = footwearService.selectall();
		int i = shoppingServie.selectint();
		model.addAttribute("shoes", shoes);
		model.addAttribute("i", i);
		model.addAttribute("footwear", footwear);
		return "zhuye";
	}
	
	@RequestMapping("/sosou")
	public String selectname(Model model,@RequestParam("name")String name) {
		System.out.println(name);
		List<Shoes> shoes = shoesService.selectname(new Shoes(name));
		List<Footwear> footwear = footwearService.selectall();
		int i = shoppingServie.selectint();
		model.addAttribute("shoes", shoes);
		model.addAttribute("i", i);
		model.addAttribute("footwear", footwear);
		return "zhuye";
	}
	
}
