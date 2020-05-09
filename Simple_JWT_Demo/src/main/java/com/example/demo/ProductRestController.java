package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	
	@Autowired
	private JwtCommonCode jwtCommonCode;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService; 

	@RequestMapping(value = "/api/product")
	public String getAllProduct( ) {
		return "Get All Producut";
	}
	
	@RequestMapping(value = "/api/gettoken",method = RequestMethod.POST)
	public String getJWTToken(@RequestBody() JwtRequest jwtRequest) throws Exception {
		
		try {
		//valid in db
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						jwtRequest.getUserName(), 
						jwtRequest.getPassword()));
		}catch (BadCredentialsException e) {
			throw new Exception("User name or passoword not match");
		}
		catch (Exception e) {
			throw new Exception("Please contact admin - unablto to authonticate");
		}
		
		//jwt gneerate and return 
		UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUserName());
		 
		String jwtToken = jwtCommonCode.generateTokenFromUser(userDetails);
		
		
		return jwtToken;
		
		
	}
}







