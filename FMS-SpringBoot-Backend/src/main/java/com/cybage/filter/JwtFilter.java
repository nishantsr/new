package com.cybage.filter;

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

import com.cybage.service.CustomUserDetailsService;
import com.cybage.util.JwtUtil;
@Component
public class JwtFilter extends OncePerRequestFilter{
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService service;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String authorizationHeader= request.getHeader("Authorization");
		String token= null;
		String username= null;
		//Token= Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTYWhpbCIsImV4cCI6MTY1MDk5NjI5NiwiaWF0IjoxNjUwOTYwMjk2fQ.eL8CviSCUn-07SKpxgQqaZmF5S0H0Bxw0ZAdkaYeX_Q
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
		{
			token= authorizationHeader.substring(7);
			username= jwtUtil.extractUsername(token);
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails= service.loadUserByUsername(username);
			if (jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
			
		}
		filterChain.doFilter(request, response);
	}
		
}
