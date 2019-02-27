package com.bridgeit.dao;



import java.util.List;

import com.bridgeit.dto.UserDto;
import com.bridgeit.model.LogInTime;
import com.bridgeit.model.User;

public interface IUserDao {

	boolean addNewUer(User user);

	boolean updateUser(User user);

	boolean deleteUser(User user);

	User getUserById(int id);

	UserDto getUserByEmail(User user);

	User getUser(UserDto user);

	User checkemail(String email);

	List<LogInTime> getTime(int id);

	List<User> getUserList();


}
