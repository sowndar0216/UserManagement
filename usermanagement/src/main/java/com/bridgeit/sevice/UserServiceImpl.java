package com.bridgeit.sevice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.dao.IUserDao;
import com.bridgeit.dto.UserDto;
import com.bridgeit.model.User;
import com.bridgeit.utility.UserToken;
import com.bridgeit.utility.Utility;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public boolean addNewUser(User user) {

		String password=user.getPassword();
		Utility.emailOtp(user, password);

		userDao.addNewUer(user);
		
		
		return true;
	}

	@Override
	public boolean updapteUser(User user) {
		// TODO Auto-generated method stub

		userDao.updateUser(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
		return true;
	}

	@Override
	public User getUser(String token) {

		try {
			int id = UserToken.tokenVerify(token);

			return userDao.getUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserDto getUserByEmail(User user) {

		return userDao.getUserByEmail(user);
	}

	@Override
	public User verifyUser(UserDto userDto) {
		System.out.println("userService");
		User user = userDao.getUser(userDto);
		System.out.println(user);

		return user;
	}

	@Override
	public User checkEmail(String email) {

		return userDao.checkemail(email);
	}

	@Override
	public boolean sendEmail(User user) {
		
		String password=user.getPassword();
		Utility.emailOtp(user, password);
		return true;
	}
}
