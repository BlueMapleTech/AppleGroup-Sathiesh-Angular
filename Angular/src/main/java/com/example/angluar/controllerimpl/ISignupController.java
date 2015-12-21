package com.example.angluar.controllerimpl;

import java.util.List;

import com.example.angluar.dto.User;

public interface ISignupController {
	public User insert_user(User user);

	public User update_user(User user);
	
	public Object  performLogin(String username,String password);

	public List<User> find_all_users();

	public User find_user(long userId);

	public void delete_user(long userId);
}
