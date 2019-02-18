package com.bridgeit.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.dao.IUserDao;
import com.bridgeit.dao.UserDaoImpl;
import com.bridgeit.dto.UserDto;
import com.bridgeit.model.User;
import com.bridgeit.utility.UserToken;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public boolean addNewUser(User user) {

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
}
