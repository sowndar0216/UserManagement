package com.bridgeit.dao;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.bridgeit.dto.UserDto;
import com.bridgeit.model.LogInTime;
import com.bridgeit.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean addNewUer(User user) {

		getCurrentSession().save(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		getCurrentSession().update(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getUserById(int id) {

		User user = (User) getCurrentSession().get(User.class, id);
		System.out.println(user);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

	@Override
	public UserDto getUserByEmail(User user) {
		// TODO Auto-generated method stub
		List<User> userList = getUsers();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getEmail().equals(user.getEmail())
					&& userList.get(i).getPassword().equals(user.getPassword())) {
				System.out.println(userList.get(i).getId());
				ModelMapper mapper = new ModelMapper();

				UserDto dto = mapper.map(userList.get(	i), UserDto.class);

				return dto;

			}
		}
		return null;
	}

	@Override
	public User getUser(UserDto userDto) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User  where userName= :name");
		query.setParameter("name", userDto.getUserName());
		System.out.println((boolean) query.list().isEmpty());
		if ((boolean) query.list().isEmpty()) {
			return null;
		} else {
			return (User) query.list().get(0);
		}
	}

	@Override
	public User checkemail(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User  where email= :email");
		query.setParameter("email", email);

		if ((boolean) query.list().isEmpty()) {
			return null;
		} else {
			return (User) query.list().get(0);
		}
	}

	@Override
	public List<LogInTime> getTime(int id) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM LogInTime  where userId= :id");
		query.setParameter("id", id);

		return (List<LogInTime>) query.list();

	}

	@Override
	public List<User> getUserList() {

		
		return getUsers();
	}
	
	
	
	

}
