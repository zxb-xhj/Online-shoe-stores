package com.xhj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xhj.bean.Footwear;
import com.xhj.bean.Shopping;
import com.xhj.service.FootwearService;
import com.xhj.service.IndentService;
import com.xhj.service.ShoesService;
import com.xhj.service.ShoppingServie;

@Controller
public class ShoppingController {
	
	@Autowired
	ShoppingServie shoppingServie;
	
	@Autowired
	ShoesService shoesService;
	
	@Autowired
	FootwearService footwearService;
	
	@Autowired
	IndentService indentService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(@RequestParam("name")String name,
			@RequestParam("mashu")Integer code,
			@RequestParam("price")Integer price) {
		Shopping shopping = new Shopping(name,code,price);
		shoppingServie.insertall(shopping);
		return name;
	}
	
	@RequestMapping("/sp")
	public String selectall(Model model) {
		List<Shopping> shopping = shoppingServie.selectall();
		List<Footwear> footwear = footwearService.selectall();
		int i = shoppingServie.selectint();
		int price = shoppingServie.selectprice();
		model.addAttribute("shopping", shopping);
		model.addAttribute("footwear", footwear);
		model.addAttribute("i", i);
		model.addAttribute("price", price);
		return "gouwuche";
	}
	
	@RequestMapping("/deleteid/{id}")
	public String deleteid(Model model,@PathVariable("id")Integer id) {
		shoppingServie.deleteid(id);
		List<Shopping> shopping = shoppingServie.selectall();
		List<Footwear> footwear = footwearService.selectall();
		int i = shoppingServie.selectint();
		int price = shoppingServie.selectprice();
		model.addAttribute("shopping", shopping);
		model.addAttribute("footwear", footwear);
		model.addAttribute("i", i);
		model.addAttribute("price", price);
		return "redirect:/sp";
	}
	
	@RequestMapping("/tijiao")
	public String deleteall(Model model) {
		indentService.insertall();
		shoppingServie.deleteall();
		List<Shopping> shopping = shoppingServie.selectall();
		List<Footwear> footwear = footwearService.selectall();
		int i = shoppingServie.selectint();
		int price = shoppingServie.selectprice();
		model.addAttribute("shopping", shopping);
		model.addAttribute("footwear", footwear);
		model.addAttribute("i", i);
		model.addAttribute("price", price);
		return "redirect:/sp";
	}
	
}
