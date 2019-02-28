package com.bridgeit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.dto.UserCount;
import com.bridgeit.dto.UserDto;
import com.bridgeit.dto.UserList;
import com.bridgeit.model.LogInTime;
import com.bridgeit.model.Response;
import com.bridgeit.model.User;
import com.bridgeit.sevice.IUserService;
import com.bridgeit.utility.UserToken;

@RestController
@CrossOrigin(origins = {})
public class UserController {

	Response response;

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/")
	public String mainPage() {
		return "wellcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Response> login(@RequestBody UserDto user) throws Exception {

		response = new Response();

		User check = userService.verifyUser(user);

		System.out.println("usercon  " + check);

		if (check != null) {
			if (check.getRole().equals("admin")) {
				String token = UserToken.generateToken(check.getId());
				check.setLastloginStamp(new Date());
				userService.updapteUser(check);
				// response1.addHeader("jwtTokenxxx", token);
				// System.out.println(token);
				response.setToken(token);
				response.setMessage("admin");
				return new ResponseEntity<Response>(response, HttpStatus.OK);

			} else if (check.getRole().equals("user")) {
				response.setMessage("user");
				return new ResponseEntity<Response>(response, HttpStatus.OK);

			}

		}

		response.setMessage("invalid");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@PostMapping(value = "/forgotPassword")
	public ResponseEntity<Response> forgotPassword(@RequestParam("email") String email) {
		response = new Response();
		System.out.println(email);
		User user = userService.checkEmail(email);

		if (user != null) {

			userService.sendEmail(user);

			response.setMessage("done");
			return new ResponseEntity<Response>(response, HttpStatus.OK);

		}

		response.setMessage("invalid user");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Response> addUser(@RequestBody User user) {

		System.out.println("hello");
		System.out.println(user);

		userService.addNewUser(user);
		response = new Response();
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Response> updateUser(@RequestBody User user) {

		System.out.println("hello");
		System.out.println(user);

		userService.updapteUser(user);
		response = new Response();
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteUser(@RequestBody User user) {

		System.out.println("hello");
		System.out.println(user);

		userService.deleteUser(user);
		response = new Response();
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestHeader("token") String token) {

		User user = userService.getUser(token);

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@GetMapping(value = "/logInTime")
	public ResponseEntity<List<LogInTime>> getTime(@RequestHeader("token") String token) {

		List<LogInTime> logTime = userService.getTime(token);

		return new ResponseEntity<List<LogInTime>>(logTime, HttpStatus.OK);

	}

	@GetMapping(value = "/getUserCount")
	public ResponseEntity<UserCount> userCount(@RequestHeader("token") String token) {

		UserCount userCount = userService.getUserCount(token);
		System.out.println(userCount);

		return new ResponseEntity<UserCount>(userCount, HttpStatus.OK);

	}

	@GetMapping(value = "/accountList")
	public ResponseEntity<List<UserList>> accountList() {

		
		List<UserList> accountList = userService.getAccountList();

		return new ResponseEntity<List<UserList>>(accountList, HttpStatus.OK);

	}

}
