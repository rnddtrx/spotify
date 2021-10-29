package be.ipam.spotify.api.repository;

import org.springframework.data.repository.CrudRepository;

import be.ipam.spotify.api.entity.AlbumEntity;
import be.ipam.spotify.api.entity.ArtistEntity;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long>{

}
