package com.barclays.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.barclays.domain.Employee;
import com.barclays.factory.DaoFactory;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showEmployeePage(ModelMap map) {

		map.addAttribute("employeeList", DaoFactory.getEmployeeDao().getEmployees());
		map.addAttribute("message", "In controller");
		
		return new ModelAndView("employee.jsp");
	}
	
}
