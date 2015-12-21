package com.example.angluar.icontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.angluar.controllerimpl.ISignupController;
import com.example.angluar.dto.User;
import com.example.angluar.iservice.ISignupService;

@Controller
@RequestMapping(value = "/signup")
public class SignupController implements ISignupController {

	private static final Logger LOG = LoggerFactory
			.getLogger(SignupController.class);

	@Autowired
	private ISignupService signupService;

	public ISignupService getSignupService() {
		return signupService;
	}

	public void setSignupService(ISignupService signupService) {
		this.signupService = signupService;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public User insert_user(@RequestBody User user) {

		LOG.info("create user service has been called.!");
		return this.signupService.insert_user(user);
	}
    @RequestMapping(value="/updateUser",method=RequestMethod.POST,headers="Accept=application/json")
    @ResponseBody
	public User update_user(@RequestBody User user) {
    	LOG.info(user.getEmailAddress());
    	LOG.info("update controller has been called.!");
		return signupService.update_user(user);
	}

	@RequestMapping(value = "/personList", method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseBody
	public List<User> find_all_users() {
		LOG.info("user list service has been called.!");
		List<User> user = signupService.find_all_users();
		return user;
	}

	@RequestMapping(value = "/findUser", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public User find_user(@RequestParam("userId")long userId) {
		LOG.debug("find user controller");
     return signupService.find_user(userId);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void delete_user(@RequestParam("userId")long userId) {
		signupService.delete_user(userId);
	}

	@RequestMapping(value = "/performLogin", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Object performLogin(
			@RequestParam("emailAddress") String emailAddress,
			@RequestParam("password") String password) {
		LOG.debug(password);
		LOG.debug(emailAddress);
		if (emailAddress == null || emailAddress.isEmpty() || password == null
				|| password.isEmpty()) {
			LOG.debug("Invalid username/password, please try again!");
			return null;
		}
		User user = signupService.performLogin(emailAddress);
		if (user != null) {
			if (user.getEmailAddress().equals(emailAddress)
					&& (user.getPassword().equals(password))&&(user.getRole_id()==1)) {
				LOG.debug("Admin Logged!");
		       LOG.debug("Returned user:" + user.toString());
				return user;
			}if (user.getEmailAddress().equals(emailAddress)
					&& (user.getPassword().equals(password))&&(user.getRole_id()==2)) {
				LOG.debug("User!");
				
				LOG.debug("Returned user:" + user.toString());
				return user;
			}else {
				return user.equals(null);
			}
		}
		return null;
	}
}
