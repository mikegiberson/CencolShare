package com.cencolshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends BaseController {
	
	@RequestMapping(value={"", "index"}, method=RequestMethod.GET)
	public ModelAndView showDashboard() {
		ModelAndView mav = new ModelAndView("dashboard/index");
		return setSelectedMenu(mav);
	}
	
}
