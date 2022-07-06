package com.gd.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.gd.dao.EmpDao;
import com.gd.model.Emp;
import com.gd.service.LoginService;

//@ModelAttribute  is scoped for each request
//@SessionAttributes("userName") is scoped at the entire application session.
@Controller
@SessionAttributes("userName")
public class EmpController {

	@Autowired
	private LoginService service;

	@Autowired
	private EmpDao dao;// will inject dao from xml file

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String homePage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelMap model, HttpSession httpsession) {
		if (Objects.isNull(httpsession.getAttribute("userName"))) {
			return directUrlAccessProhibited();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("errorMessage", "Please Login First");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = service.validateUser(name, password);
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		model.put("userName", name);
		model.put("password", password);
		return "menu";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ModelAndView showMenu(ModelMap model, HttpSession httpsession) {
		if (Objects.isNull(httpsession.getAttribute("userName"))) {
			return directUrlAccessProhibited();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("errorMessage", "Please Login First");
		return modelAndView;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model, HttpServletRequest request, SessionStatus status) {
		/*
		 * Mark the current handler's session processing as complete, allowing for
		 * cleanup of session attributes.
		 */
		status.setComplete();
		/* Invalidates this session then unbinds any objects bound to it. */
		HttpSession session = request.getSession();
		session.invalidate();
		// return "redirect:/home";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("logoutMessage", "Logout Sucessful");
		return modelAndView;
	}

	// The arguments here are(String viewName, String modelName, Object modelObject)
	// Keep in mind the second name of parameter must be same in JSP as below:
	// <form:form method="post" action="save" modelAttribute="employeeValues">
	// Also all the pojo attribute names must match exactly all html input tag
	// names.

	@RequestMapping("/add-employee")
	public ModelAndView addEmployee(ModelMap model, HttpSession httpsession) {
		if (Objects.isNull(httpsession.getAttribute("userName"))) {
			return directUrlAccessProhibited();
		}
		return new ModelAndView("add-employee", "employeeValues",
				new Emp("Put Name Here", 0.0f, "Put Designation here"));
	}

	private ModelAndView directUrlAccessProhibited() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("errorMessage", "Please Login First");
		return modelAndView;
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employeeValues") Emp gd, HttpSession httpsession) {
		if (Objects.isNull(httpsession.getAttribute("userName"))) {
			return directUrlAccessProhibited();
		}
		dao.save(gd);
		return new ModelAndView("redirect:/viewemp");
		// will redirect to viewemp request mapping,
		// If you're doing a redirect--request attributes are lost; it's a new request.
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewemp")
	public ModelAndView viewEmployees(HttpSession httpsession) {
		if (Objects.isNull(httpsession.getAttribute("userName"))) {
			return directUrlAccessProhibited();
		}
		List<Emp> list = dao.getEmployees();
		return new ModelAndView("viewemp", "list", list);
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/edit-employee/{id}")
	public ModelAndView editEmployee(@PathVariable int id, HttpSession httpsession) {
		if (Objects.isNull(httpsession.getAttribute("userName"))) {
			return directUrlAccessProhibited();
		}
		Emp emp = dao.getEmpById(id);
		return new ModelAndView("edit-employee", "populatedEmployee", emp);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView saveEditedEmployee(@ModelAttribute Emp gd, HttpSession httpsession) {
		if (Objects.isNull(httpsession.getAttribute("userName"))) {
			return directUrlAccessProhibited();
		}
		dao.update(gd);
		return new ModelAndView("redirect:/viewemp");
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable int id, HttpSession httpsession) {
		if (Objects.isNull(httpsession.getAttribute("userName"))) {
			return directUrlAccessProhibited();
		}
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp");
	}
}
