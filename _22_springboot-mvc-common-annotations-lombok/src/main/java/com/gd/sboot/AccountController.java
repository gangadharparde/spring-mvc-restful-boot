package com.gd.sboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView viewForm() {
		return new ModelAndView("accountHome", "account", new Account());
	}

	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public String submit(@ModelAttribute("account") Account account, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("id", account.getId());
		model.addAttribute("name", account.getName());
		model.addAttribute("type", account.getType());
		return "accountView";
	}
}