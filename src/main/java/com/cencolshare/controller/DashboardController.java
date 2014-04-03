package com.cencolshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.model.response.StatResponse;
import com.cencolshare.service.StatService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends BaseController {
	
	@Autowired
	StatService statService;
	
	@RequestMapping(value={"", "index"}, method=RequestMethod.GET)
	public ModelAndView showDashboard() {
		
		final StatResponse statResponse = statService.getStatistics(getLoggedInUser());
		
		ModelAndView mav = new ModelAndView("dashboard/index");
		mav.addObject("stats", statResponse);
		return setSelectedMenu(mav);
	}
	
}
