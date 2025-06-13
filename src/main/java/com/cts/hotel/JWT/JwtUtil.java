package com.cts.hotel.JWT;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;
import java.security.Key;

import io.jsonwebtoken.*;
import java.util.function.Function;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

	private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final long EXPIRATION_TIME = 1000 * 60 * 60;

	public String generateToken(String email, Long userId, String role) {
	    return Jwts.builder()
	            .subject(email) // ✅ Authenticate using email
	            .claim("userId", userId) // ✅ Include user ID in token
	            .claim("role", role) // ✅ Include user role
	            .issuedAt(new Date())
	            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	            .signWith(SECRET_KEY)
	            .compact();
	}


	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public Boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().verifyWith((SecretKey) SECRET_KEY).build().parseSignedClaims(token);
			return true;
		} catch (JwtException e) {
			return false; // Invalid token
		}
	}

	Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith((SecretKey) SECRET_KEY).build().parseSignedClaims(token).getPayload();
	}

	public Long extractUserId(String token) {
		return extractClaim(token, claims -> claims.get("userId", Long.class)); // ✅ Extract user ID
	}

	public String extractRole(String token) {
		return extractClaim(token, claims -> claims.get("role", String.class)); // ✅ Extract role
	}

	public String extractEmail(String token) {
		return extractClaim(token, Claims::getSubject); // ✅ Extract email (since email is the subject)
	}

}
