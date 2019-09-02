package com.techzone.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.model.UserModel;
import com.techzone.springmvc.service.RoleService;
import com.techzone.springmvc.service.SecurityService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.validator.UserValidator;

@Controller
public class RegisterController {

	// TODO : Dependency Injection
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private RoleService roleService;
	// TODO : Dependency Injection

	private Map<Integer, String> roleUser;

	void initListRole(ModelMap theModel) {
		roleUser = new HashMap<Integer, String>();
		List<Role> roles = roleService.getRoles();
		for (int i = 0; i < roles.size(); i++) {
			roleUser.put(roles.get(i).getId(), roles.get(i).getRoleName().toString());
		}
		theModel.addAttribute("roles", roleUser);
	}

	@GetMapping("/registration")
	public String registration(ModelMap model) {

		initListRole(model);

		model.addAttribute("userForm", new UserModel());
		return "registration";
	}

	@PostMapping(value = "/registration")
	public String registration(@ModelAttribute("userForm") UserModel userForm, BindingResult bindingResult,
			ModelMap model) {

		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			initListRole(model);
			model.addAttribute("userForm", userForm);
			return "registration";
		}

		User user = userForm.getUser();

		List<String> listRole = null;
		try {
			listRole = userForm.getRoles();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		if (listRole != null) { // TODO : save user with multiple selected role

			User newUser = userForm.getUser();

			int[] roles = new int[listRole.size()];
			for (int i = 0; i < listRole.size(); i++) {
				roles[i] = Integer.parseInt(listRole.get(i));
			}
			userService.saveWithRole(newUser, roles);
			return "redirect:/welcome";

		}
		
		userService.save(user);// TODO : save user with default role

		// has something error at here , I will repair to support auto login after register , don't remove this line
//        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}
	// test for model object //

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String sendToLogin() {

		return "redirect:/showMyLoginPage";

	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

}
