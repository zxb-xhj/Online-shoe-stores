package com.xhj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.bean.Footwear;
import com.xhj.bean.Indent;
import com.xhj.service.FootwearService;
import com.xhj.service.IndentService;
import com.xhj.service.ShoesService;
import com.xhj.service.ShoppingServie;

@Controller
public class IndentController {
	
	@Autowired
	IndentService indentService;
	
	@Autowired
	FootwearService footwearService;
	
	@Autowired
	ShoppingServie shoppingServie;
	
	@RequestMapping("/id")
	public String selectall(Model model) {
		List<Indent> indent = indentService.selectall();
		List<Footwear> footwear = footwearService.selectall();
		int i = shoppingServie.selectint();
		model.addAttribute("indent", indent);
		model.addAttribute("i", i);
		model.addAttribute("footwear", footwear);
		return "dingdan";
	}

}
