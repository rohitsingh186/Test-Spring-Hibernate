package com.barclays.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.barclays.domain.Employee;
import com.barclays.factory.DaoFactory;


@Controller
@RequestMapping("/email")
public class EmailController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showEmailPage(ModelMap map) {

		map.addAttribute("emailList", DaoFactory.getEmailDao().getAllEmails());
		
		return new ModelAndView("email.jsp");
	}
	
}
