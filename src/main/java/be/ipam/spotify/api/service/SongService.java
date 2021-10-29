package be.ipam.spotify.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.http.ResponseEntity;

import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.model.Song;

public interface SongService {
	public Optional<SongEntity> songBySongId(long songId);



	Song toModel(SongEntity e);

	public SongEntity createSong(String name);

	public void deleteSong(Long songId);
	
	public SongEntity toEntity(Song model);

	public SongEntity createSong(SongEntity entity);

	public Set<Song> toModelList(List<SongEntity> list); 

	
	
}
