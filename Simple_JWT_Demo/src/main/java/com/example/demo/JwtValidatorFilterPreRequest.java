package com.example.demo;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtValidatorFilterPreRequest extends OncePerRequestFilter {

	@Autowired
	private JwtCommonCode jwtCommonCode;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getHeader("token");
		
		//if(token==null)  response.sendError(401);
		
		if(token!=null) {			
			String userName = jwtCommonCode.getUserName(token);
			UserDetails userDetail =  userDetailsService.loadUserByUsername(userName);
			if(userDetail != null) {
				
				UsernamePasswordAuthenticationToken authoToken = new UsernamePasswordAuthenticationToken
						(userDetail.getUsername(),null, userDetail.getAuthorities());
				
				authoToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authoToken);
			}
		}
	 
		//Next task to execute 
		filterChain.doFilter(request, response);
	}

}
