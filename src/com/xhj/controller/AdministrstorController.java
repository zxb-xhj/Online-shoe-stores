package com.xhj.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xhj.bean.Administrator;
import com.xhj.bean.Footwear;
import com.xhj.bean.Indent;
import com.xhj.bean.Shoes;
import com.xhj.service.AdministratorService;
import com.xhj.service.FootwearService;
import com.xhj.service.IndentService;
import com.xhj.service.ShoesService;
import com.xhj.service.ShoppingServie;

@Controller
public class AdministrstorController {
	
	@Autowired
	ShoesService shoesService;
	
	@Autowired
	FootwearService footwearService;
	
	@Autowired
	ShoppingServie shoppingServie;
	
	@Autowired
	AdministratorService administratorService;
	
	@Autowired
	IndentService indentService;
	
	
	@RequestMapping("/admin")
	public String admin() {
		
		return "adminlogin";
	}
	
	@RequestMapping("/admin1")
	public String admin1(Model model) {
		List<Shoes> shoes = shoesService.selectall();
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("shoes", shoes);
		model.addAttribute("footwear", footwear);
		return "caozuoxie";
	}
	
	@RequestMapping("/adselectall")
	public String selectall(@RequestParam("name")String name,@RequestParam("pwd")String pwd,Model model) {
		System.out.println(name);
		System.out.println(pwd);
		Administrator administrator = administratorService.selectall(new Administrator(name,pwd));
		if(administrator!=null) {
			List<Shoes> shoes = shoesService.selectall();
			List<Footwear> footwear = footwearService.selectall();
			int i = shoppingServie.selectint();
			model.addAttribute("shoes", shoes);
			model.addAttribute("i", i);
			model.addAttribute("footwear", footwear);
			model.addAttribute("dd", "登录成功");
			return "caozuoxie";
		}
		model.addAttribute("dd", "登录失败");
		return "adminlogin";
	}
	
	@RequestMapping("/adfoot")
	public String foot(Model model) {
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("footwear", footwear);
		return "caozuobiaoqian";
	}
	
	@RequestMapping("/adsosou")
	public String selectname(Model model,@RequestParam("name")String name) {
		System.out.println(name);
		List<Shoes> shoes = shoesService.selectname(new Shoes(name));
		int i = shoppingServie.selectint();
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("footwear", footwear);
		model.addAttribute("shoes", shoes);
		model.addAttribute("i", i);
		return "caozuoxie";
	}
	
	@RequestMapping("/adinsertname")
	public String insertname(Model model,@RequestParam("name")String name) {
		footwearService.insertname(new Footwear(name));
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("footwear", footwear);
		return "redirect:/adfoot";
	}
	
	@RequestMapping("/addeleteid/{id}")
	public String deleteid(Model model,@PathVariable("id")Integer id) {
		footwearService.deleteid(id);
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("footwear", footwear);
		return "redirect:/adfoot";
	}
	
	@RequestMapping("/adinsertid/{id}")
	public String insertid(Model model,@PathVariable("id")Integer id) {
		Footwear footwear = footwearService.selectid(id);
		List<Footwear> list = new ArrayList<>();
		list.add(footwear);
		model.addAttribute("footwear", list);
		return "xiugaibiaoqian";
	}
	@RequestMapping("/adupdate")
	public String update(Model model,@RequestParam("id")Integer id,@RequestParam("name")String name) {
		footwearService.update(new Footwear(id,name));
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("footwear", footwear);
		return "redirect:/adfoot";
	}
	
	@RequestMapping("/addeletesid/{id}/{name}")
	public String deletesid(Model model,@PathVariable("id")Integer id,@PathVariable("name")String name,HttpServletRequest request) {
		System.out.println(id);
		shoesService.deletesid(id);
		String path = "E:/eclipse/eclipse-workspace/"+request.getContextPath()+"/WebContent/img/";
		//更改图片名称
		String string1 = name+".jpg";
		
		File file2 = new File(path+string1);
		if(file2.isFile() && file2.exists()) {
			System.out.println(file2.delete());
		}
		List<Shoes> shoes = shoesService.selectall();
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("footwear", footwear);
		model.addAttribute("shoes", shoes);
		model.addAttribute("shanchu", name);
		return "redirect:/admin1";
	}
	
	@RequestMapping("/adinsertsid/{id}")
	public String insertsid(Model model,@PathVariable("id")Integer id) {
		Shoes shoes = shoesService.selectid(id);
		List<Shoes> list = new ArrayList<>();
		list.add(shoes);
		System.out.println(list);
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("Footwear", footwear);
		model.addAttribute("shoes", list);
		return "xiugaixie";
	}
	
	@RequestMapping("/adupdates")
	public String updates(Model model,@RequestParam(value="file",required=false)String file,@RequestParam("id")Integer id,
			@RequestParam("name")String name,@RequestParam("sname")String sname,
			@RequestParam("price")Integer price,HttpServletRequest request) throws Exception {
		System.out.println(file);
		shoesService.update(new Shoes(id, name, price));
		if(file!=null&&file!="") {
			
			//获取图片
			File newFile = new File("C:\\Users\\DELL\\Desktop\\xie\\"+file);
			//转换成MultipartFile
			InputStream inputStream2 = new FileInputStream(newFile);
			MultipartFile mockMultipartFile = new MockMultipartFile(newFile.getName(), inputStream2);
			//获取图片要存放的地址
			String path = "E:/eclipse/eclipse-workspace/"+request.getContextPath()+"/WebContent/img/";
			//更改图片名称
			String string1 = name+".jpg";
			
			File file2 = new File(path+string1);
			if(file2.isFile() && file2.exists()) {
				System.out.println(file2.delete());
			}
			//存入磁盘
			mockMultipartFile.transferTo(file2);
		}else {
			String path = "E:/eclipse/eclipse-workspace/"+request.getContextPath()+"/WebContent/img/";
			//获取图片
			File newFile = new File(path+sname+".jpg");
			//转换成MultipartFile
			InputStream inputStream2 = new FileInputStream(newFile);
			MultipartFile mockMultipartFile = new MockMultipartFile(newFile.getName(), inputStream2);
			//更改名称
			String string1 = name+".jpg";
			File file2 = new File(path+string1);
			if(newFile.isFile() && newFile.exists()) {
				//如果有就删除
				System.out.println(newFile.delete());
			}
			//存入磁盘 
			mockMultipartFile.transferTo(file2);
		}
		List<Shoes> shoes = shoesService.selectall();
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("footwear", footwear);
		model.addAttribute("shoes", shoes);
		return "redirect:/admin1";
	}
	
	@RequestMapping("/adinsertall")
	public String insertall(Model model,@RequestParam(value="file",required=false)String file,@RequestParam("hid")Integer hid,
			@RequestParam("name")String name,
			@RequestParam("price")Integer price,HttpServletRequest request) throws Exception {
		System.out.println(file);
		shoesService.insertall(new Shoes(name, price,hid));
			//获取图片
			File newFile = new File("C:\\Users\\DELL\\Desktop\\xie\\"+file);
			//转换成MultipartFile
			InputStream inputStream2 = new FileInputStream(newFile);
			MultipartFile mockMultipartFile = new MockMultipartFile(newFile.getName(), inputStream2);
			//获取图片要存放的地址
			String path = "E:/eclipse/eclipse-workspace/"+request.getContextPath()+"/WebContent/img/";
			//更改图片名称
			String string1 = name+".jpg";
			
			File file2 = new File(path+string1);
			if(file2.isFile() && file2.exists()) {
				System.out.println(file2.delete());
			}
			//存入磁盘
			mockMultipartFile.transferTo(file2);
		
		List<Shoes> shoes = shoesService.selectall();
		List<Footwear> footwear = footwearService.selectall();
		model.addAttribute("footwear", footwear);
		model.addAttribute("shoes", shoes);
		return "redirect:/admin1";
	}
	
	@RequestMapping("/adid")
	public String selectall(Model model) {
		List<Indent> indent = indentService.selectall();
		List<Footwear> footwear = footwearService.selectall();
		int i = shoppingServie.selectint();
		model.addAttribute("indent", indent);
		model.addAttribute("i", i);
		model.addAttribute("footwear", footwear);
		return "guanlidingdan";
	}
	
	@RequestMapping("/addeleteding/{id}")
	public String deleteding(Model model,@PathVariable("id")Integer id) {
		indentService.deleteding(id);
		return "redirect:/adid";
	}

}
