package com.zsouzaz.estoque.authentication;

import java.time.Instant;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
	private final JwtEncoder encoder;

	public JwtService(JwtEncoder encoder) {
		this.encoder = encoder;
	}
	
	public String generateToken(Authentication authencation) {
		Instant agora = Instant.now();
		long expiraEm = 3600L;
		
		String escopos = authencation.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
		var claims = JwtClaimsSet.builder()
				.issuer("spring-security-jwt")
				.issuedAt(agora)
				.expiresAt(agora.plusSeconds(expiraEm))
				.subject(authencation.getName())
				.claim("scope", escopos)
				.build();
		
		return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}	
}
