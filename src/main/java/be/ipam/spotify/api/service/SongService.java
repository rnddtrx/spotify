package be.ipam.spotify.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.model.Song;

public interface SongService {
	public Optional<SongEntity> songBySongId(long songId);

	public List<Song> toModelList(Set<SongEntity> songs);

	Song toModel(SongEntity e);
	
	
}
