package be.ipam.spotify.api.service;
import java.util.Optional;

import be.ipam.spotify.api.entity.UserappEntity;

public interface UserappService {
	public Optional<UserappEntity> findUserByUsername(String username);
}
