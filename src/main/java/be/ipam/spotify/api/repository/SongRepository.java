package be.ipam.spotify.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.entity.SongEntity;

@Repository
public interface SongRepository extends CrudRepository<SongEntity, Long> {

	//Derived query
	List<SongEntity> findByName(String name);

	//JPQL
	@Query("SELECT s FROM SongEntity s WHERE s.name = :name")
	List<SongEntity> findByName2(@Param("name") String name);
	
	//Native
	@Query(value = "SELECT * FROM Song s WHERE s.name = :name", nativeQuery = true)
	List<SongEntity> findByName3(@Param("name") String name);
	

}
