package be.ipam.spotify.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.spotify.api.entity.PlaylistEntity;

@Repository
public interface PlaylistRepository extends CrudRepository<PlaylistEntity,Long> {

}
