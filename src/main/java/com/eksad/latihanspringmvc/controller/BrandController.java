package com.eksad.latihanspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.repository.BrandRepositoryDAO;

@Controller
@RequestMapping("/brand")
public class BrandController {
	@Autowired
	BrandRepositoryDAO brandRepositoryDao;
	
	@RequestMapping("")
	public String index(Model model) {
		List<Brand> list = brandRepositoryDao.findAll();
		
		model.addAttribute("listBrand", list);
		return "listbrand";
	
	}
@RequestMapping("/add")
public String addBrand(Model model) {
	Brand brand = new Brand();
	model.addAttribute("brand", brand);
	return "addbrand";
	
}

@RequestMapping(value="/save", method = RequestMethod.POST)
public String save(@ModelAttribute Brand brand) {
	brandRepositoryDao.save(brand);
	return "redirect:/brand";
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public String delete(Brand brand) {
	brandRepositoryDao.delete(brand);
	return "redirect:/brand";
	
}
@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
public String edit(@PathVariable Long id, Model model) {
	Brand brand = brandRepositoryDao.findOne(id);
	model.addAttribute("brand", brand);
	return "addbrand";
}
	
	
	

}
