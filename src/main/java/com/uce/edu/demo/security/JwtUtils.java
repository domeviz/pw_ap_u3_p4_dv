package com.uce.edu.demo.security;

import java.util.Date;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtUtils {

	private static final Logger LOG=LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${app.jwt.secret}")
    private String jwtSecret;

	public boolean validateJwtToken(String token) {
		try {
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		return true;
		} catch(ExpiredJwtException e) {
			LOG.error("Token expirado {}",e.getMessage());
		} catch(SignatureException e) {
			LOG.error("Token expirado {}",e.getMessage());
		}
		return false;
	}
	public String getUsernameFromJwtToken(String token) {
		//El subject esta en el body, se puede ver en el jwt.io 
		//Aqui se obtiene el nombre a partir del token
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
}
