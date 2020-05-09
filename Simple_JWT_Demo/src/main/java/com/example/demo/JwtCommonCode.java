package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtCommonCode {

	private String SECRET_KEY="mysecreatekey";
	
	/**************** decoding user info from jwt token **************************/
	//{
	//"jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJkaWsiLCJleHAiOjE1ODkwMzQ5MTAsImlhdCI6MTU4ODk5ODkxMH0.roVk8kWODpKE0L1goc0y2nS3EzinDHznl_eV6sEPIP0"
	//}
	public String getUserName(String token) {
		return executeFunction(token,Claims::getSubject);
	}
	
	public Date getExpiraDate(String token) {
		return executeFunction(token,Claims::getExpiration);
	}
	
	public <T>T executeFunction(String token,Function<Claims, T> executeFun) {
		Claims c = extractAllClaims(token);
		return executeFun.apply(c);
	}
	
	
	public Claims extractAllClaims(String tokent) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(tokent).getBody();
	}
	
	/*************** encoding user inform in JWT algo *******************/
	
	public String generateTokenFromUser(UserDetails userDetails) {
		Map<String, Object>  claims = new HashMap<>();
		String subject = userDetails.getUsername();
		
		return createToken(claims, subject);
	}
	
	
	public String createToken(Map<String, Object> claims,String subject) {
		
		return Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60+10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
		
	}
	
}
