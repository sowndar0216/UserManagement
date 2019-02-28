package com.bridgeit.sevice;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.dao.IUserDao;
import com.bridgeit.dto.UserCount;
import com.bridgeit.dto.UserDto;
import com.bridgeit.dto.UserList;
import com.bridgeit.model.LogInTime;
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

		String password = user.getPassword();
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

		if (user.getUserName().equals(userDto.getUserName()) && user.getPassword().equals(userDto.getPassword())) {

			return user;
		}
		return null;

	}

	@Override
	public User checkEmail(String email) {

		return userDao.checkemail(email);
	}

	@Override
	public boolean sendEmail(User user) {

		String password = user.getPassword();
		Utility.emailOtp(user, password);
		return true;
	}

	@Override
	public List<LogInTime> getTime(String token) {

		try {
			int id = UserToken.tokenVerify(token);

			List<LogInTime> logTime = userDao.getTime(id);
			System.out.println(logTime);

			return logTime;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserCount getUserCount(String token) {

		long active = 0;
		long inactive = 0;
		try {
			int id = UserToken.tokenVerify(token);
			User user = userDao.getUserById(id);
			System.out.println("sowndar" + user);
			if (user.getRole().equals("admin")) {
				System.out.println("list");
				List<User> userList = userDao.getUserList();
				System.out.println("ll");
				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getRole().equals("user")) {
						if (userList.get(i).isStatus() == false) {

							inactive++;
						} else {
							active++;
						}

					}
				}
				UserCount count = new UserCount();
				count.setActive(active);
				count.setInactive(inactive);

				return count;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<UserList> getAccountList() {

		List<User> userList = userDao.getUserList();
		ModelMapper mapper = new ModelMapper();
		List<UserList> list = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			list.add(mapper.map(userList.get(i), UserList.class));

		}
		return list;

	}
}
