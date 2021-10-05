package be.ipam.spotify.api.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.entity.SongEntity;

@Repository
public interface ArtistRepository extends CrudRepository<ArtistEntity, Long>{

}