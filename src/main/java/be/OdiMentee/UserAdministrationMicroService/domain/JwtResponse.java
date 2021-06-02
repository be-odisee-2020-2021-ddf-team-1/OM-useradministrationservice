package be.OdiMentee.UserAdministrationMicroService.domain;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	private final UserDetails Username;

	public JwtResponse(String jwttoken, UserDetails username) {
		this.jwttoken = jwttoken;
		this.Username = username;
	}

	public String getToken() {
		return this.jwttoken;
	}
}