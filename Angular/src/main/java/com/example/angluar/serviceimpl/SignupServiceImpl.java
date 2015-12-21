package com.example.angluar.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.angluar.dto.User;
import com.example.angluar.idao.ISignupDao;
import com.example.angluar.iservice.ISignupService;

@Service
@Transactional
public class SignupServiceImpl implements ISignupService {

	private static final Logger LOG = LoggerFactory
			.getLogger(SignupServiceImpl.class);

	@Autowired
	private ISignupDao signupDao;

	public ISignupDao getSignupDao() {
		return signupDao;
	}

	public void setSignupDao(ISignupDao signupDao) {
		this.signupDao = signupDao;
	}

	@Transactional
	public User insert_user(User user) {
		LOG.info("Insert service called.!");
		return this.signupDao.insert_user(user);
	}

	@Transactional
	public User update_user(User user) {
		LOG.info("update service has been called.!");
		return signupDao.update_user(user);
	}

	@Transactional
	public List<User> find_all_users() {
		LOG.info("create user dao has been called.!");
		return signupDao.find_all_users();
	}

	@Transactional
	public User find_user(long userId) {
		LOG.debug("find user Service");
		return signupDao.find_user(userId);
	}

	@Transactional
	public void delete_user(long userId) {
		signupDao.delete_user(userId);

	}
	
	@Transactional
	public User performLogin(String emailAddress) {
		LOG.debug("Login Dao has been called!");
		
		return this.signupDao.performLogin(emailAddress);
	}

}
