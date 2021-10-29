package be.ipam.spotify.api.service;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import be.ipam.spotify.api.entity.AlbumEntity;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Album;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.model.Song;
import be.ipam.spotify.api.repository.AlbumRepository;
import be.ipam.spotify.api.repository.ArtistRepository;

@Service
public class AlbumServiceImpl implements AlbumService {

	
	private AlbumRepository albumRep;
	
	public AlbumServiceImpl(AlbumRepository albumRep) {
		this.albumRep=albumRep;
	}
	
	
	@Override
	public Optional<AlbumEntity> albumByAlbumId(long albumId) {
		Optional<AlbumEntity> se = this.albumRep.findById(albumId);
		return se;
	}


	@Override
	public List<Song> toModelList(List<SongEntity> songs) {
		if (Objects.isNull(songs)) {
			return Collections.emptyList();
		}
		   return songs.stream().map(e -> toModel(e)).collect(toList());
	}


	private Song toModel(SongEntity e) {
	    Song m = new Song();
	    m.songId(e.getSongId()).name(e.getName());
	    return m;
	}


	@Override
	public List<SongEntity> songsByAlbumId(long albumId) {
		AlbumEntity se = this.albumRep.findById(albumId).get();
		return se.getSongs();
	}


	@Override
	public Album toModel(AlbumEntity album) {
		Album m = new Album();
		m.setAlbumId(album.getAlbumId());
		m.setName(album.getName());
		return m;
	}
	
	

}
