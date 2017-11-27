/**
 * 
 */
package com.gc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Herman
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homePage(){
		return "index";
	}
	
	@RequestMapping("/list")
	public ModelAndView getAllItems(@RequestParam("sku")String sku){
		
		DaoJDBCImpl dao = new DaoJDBCImpl();//TODO replace with factory design pattern here
		
		ItemDto listItem = dao.listById(Integer.valueOf(sku));//valueOf() is a factory design pattern here
			
		
		return new ModelAndView("view","modeldto", listItem);
	}

}
