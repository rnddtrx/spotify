package be.ipam.spotify.api.service;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.model.Song;
import be.ipam.spotify.api.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

	private SongRepository songRep;
	
	public SongServiceImpl(SongRepository songRep) {
		this.songRep=songRep;
	}
	
	@Override
	public Optional<SongEntity> songBySongId(long songId) {
		Optional<SongEntity> se = this.songRep.findById(songId);
		return se;
	}

	
	@Override
	public Song toModel(SongEntity e) {
	    Song m = new Song();
	    m.songId(e.getSongId()).name(e.getName());
	    return m;
	  }
	
	

	@Override
	public List<Song> toModelList(Set<SongEntity> songs) {
		if (Objects.isNull(songs)) {
			return Collections.emptyList();
		}
		return songs.stream().map(e -> toModel(e)).collect(toList());
	}




}
