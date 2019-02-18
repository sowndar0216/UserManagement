package com.bridgeit.sevice;


import com.bridgeit.dto.UserDto;
import com.bridgeit.model.User;

public interface IUserService {

	boolean addNewUser(User user);

	boolean updapteUser(User user);

	boolean deleteUser(User user);

	User getUser(String token);

	UserDto getUserByEmail(User user);

}
