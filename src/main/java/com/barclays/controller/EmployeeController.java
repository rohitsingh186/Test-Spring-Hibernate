package com.barclays.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barclays.domain.Employee;
import com.barclays.factory.DaoFactory;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String showEmployeePage(ModelMap map) {

		for(Employee e : DaoFactory.getEmployeeDao().getEmployees())
		{
			System.out.println(e.getId());
			System.out.println(e.getName());
		}
		
		map.addAttribute("employeeList", DaoFactory.getEmployeeDao().getEmployees());
		map.addAttribute("msg", "In controller");
		
		return "employee";
	}
	
}
