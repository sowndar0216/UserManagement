package com.bridgeit.sevice;


import java.util.List;

import com.bridgeit.dto.UserDto;
import com.bridgeit.model.LogInTime;
import com.bridgeit.model.User;

public interface IUserService {

	boolean addNewUser(User user);

	boolean updapteUser(User user);

	boolean deleteUser(User user);

	User getUser(String token);

	UserDto getUserByEmail(User user);

	User verifyUser(UserDto user);

	User checkEmail(String email);

	boolean sendEmail(User user);

	List<LogInTime> getTime(String token);

}
