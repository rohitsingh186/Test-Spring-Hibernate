package com.barclays.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.barclays.factory.DaoFactory;


@Controller
@RequestMapping("/address")
public class AddressController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAddressPage(ModelMap map) {

		map.addAttribute("addressList", DaoFactory.getAddressDao().getAllAddresses());
		
		return new ModelAndView("address.jsp");
	}
	
}
