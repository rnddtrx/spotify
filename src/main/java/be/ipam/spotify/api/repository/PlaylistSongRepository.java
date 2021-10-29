package be.ipam.spotify.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.spotify.api.entity.PlaylistSongEntity;


@Repository
public interface PlaylistSongRepository extends CrudRepository<PlaylistSongEntity, Long> {

}
