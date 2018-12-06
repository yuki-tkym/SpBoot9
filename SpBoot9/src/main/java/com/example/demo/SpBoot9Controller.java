package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpBoot9Controller {
	@Autowired
    private SampleDao dao;
		
	@RequestMapping(value = "/", method =RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		
		dao.update();
		return mv;
	}
}