package com.bridgeit.dao;


import com.bridgeit.dto.UserDto;
import com.bridgeit.model.User;

public interface IUserDao {

	boolean addNewUer(User user);

	boolean updateUser(User user);

	boolean deleteUser(User user);

	User getUserById(int id);

	UserDto getUserByEmail(User user);

}
