package com.bridgeit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.dto.UserDto;
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
	public ResponseEntity<Response> login(@RequestBody User user, HttpServletResponse response1) throws Exception {
System.out.println(user);
		UserDto userDto = userService.getUserByEmail(user);

		String token = UserToken.generateToken(userDto.getId());

		response = new Response();

		if (token != null) {
			response1.addHeader("jwtTokenxxx", token);

			response.setMessage("done");
			response.setStatusCode(100);

			return new ResponseEntity<Response>(response, HttpStatus.OK);

		}

		response.setMessage("undone");
		response.setStatusCode(404);

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

	

}
