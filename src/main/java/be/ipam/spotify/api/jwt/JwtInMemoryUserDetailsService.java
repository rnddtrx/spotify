package be.ipam.spotify.api.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import be.ipam.spotify.api.entity.UserappEntity;
import be.ipam.spotify.api.model.Userapp;
import be.ipam.spotify.api.service.SongServiceImpl;
import be.ipam.spotify.api.service.UserappServiceImpl;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(JwtInMemoryUserDetailsService.class);
	
  @Autowired
  UserappServiceImpl userSer;

  //static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  //static {
  //inMemoryUserList.add(new JwtUserDetails(1L, "toto",
  //      "$2a$10$Bi7DWJTLZp4fjT8oT96q0erNCzQD5QtR62uT1v7QFWddmp3c9.g.G", "ADMIN"));
  //}

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	  
	    
	  Optional<JwtUserDetails> user = Optional.empty();
	  
	  Optional<UserappEntity> userapp = userSer.findUserByUsername(username);
	  

	  if(userapp.isPresent()) {
		UserappEntity ua = userapp.get();
		log.info("FOUND " + ua.getLogin() +" "+ ua.getPassword());
		user = Optional.of(new JwtUserDetails(ua.getUserappId(),ua.getLogin(),ua.getPassword(),ua.getRole()));

	  }
	  
	  //if(pat.isPresent()) {
		//  user = Optional.of(new JwtUserDetails(pat.get().getId(),pat.get().getMail(),pat.get().getPw(),"ROLE_PATIENT")); 
	  //}
	  
	  //Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
      //  .filter(u -> u.getUsername().equals(username)).findFirst();
	  

	  if (user.isEmpty()) {
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
	  }

	  return user.get();
  }

}