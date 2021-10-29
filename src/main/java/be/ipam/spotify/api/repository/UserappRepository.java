package be.ipam.spotify.api.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.ipam.spotify.api.entity.UserappEntity;

@Repository
public interface UserappRepository extends CrudRepository<UserappEntity, Long> {

	//Derived query
	Optional<UserappEntity> findFirstByLogin(String login);	

}