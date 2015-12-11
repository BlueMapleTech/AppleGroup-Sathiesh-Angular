package com.example.angluar.idao;

import java.util.List;

import com.example.angluar.dto.User;

public interface ISignupDao {
	public User insert_user(User user);

	public User update_user(User user);
	
	public User performLogin(String username);

	public List<User> find_all_users();

	public User find_user(long userId);

	public void delete_user(long userId);

	
}
