package be.ipam.spotify.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import be.ipam.spotify.api.entity.UserappEntity;
import be.ipam.spotify.api.repository.SongRepository;
import be.ipam.spotify.api.repository.UserappRepository;

@Service
public class UserappServiceImpl implements UserappService{

	private UserappRepository userRep;

	public UserappServiceImpl(UserappRepository userRep) {
		this.userRep=userRep;	}
	
	@Override
	public Optional<UserappEntity> findUserByUsername(String username) {
		return this.userRep.findFirstByLogin(username);

	}

}
