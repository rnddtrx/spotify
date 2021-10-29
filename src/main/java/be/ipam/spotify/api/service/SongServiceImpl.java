package be.ipam.spotify.api.service;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Service;

import be.ipam.spotify.api.controllers.SongsController;
import be.ipam.spotify.api.entity.AlbumEntity;
import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.model.Song;
import be.ipam.spotify.api.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

	private SongRepository songRep;
	//private AlbumService albSer;
	private static final Logger log = LoggerFactory.getLogger(SongServiceImpl.class);

	
	public SongServiceImpl(SongRepository songRep) {
		this.songRep=songRep;
		//this.albSer=albSer;
	}
	
	@Override
	public Optional<SongEntity> songBySongId(long songId) {
		log.info("Service "+songId);
		Optional<SongEntity> se = this.songRep.findById(songId);
		log.info("return ");
		return se;
	}

	
	@Override
	public Song toModel(SongEntity e) {
	    Song m = new Song();
	    m.songId(e.getSongId()).name(e.getName());
	    return m;
	  }
	
	

	@Override
	public Set<Song> toModelList(List<SongEntity> songs) {
		if (Objects.isNull(songs)) {
			return Collections.emptySet();
		}
		return songs.stream().map(e -> toModel(e)).collect(toSet());
	}

	@Override
	public SongEntity createSong(String name) {
		SongEntity song = new SongEntity();
		song.setName(name);
		return this.songRep.save(song);
	}

	@Override
	public void deleteSong(Long songId) {
		this.songRep.deleteById(songId);		
	}

	@Override
	public SongEntity toEntity(Song model) {
		SongEntity entity = new SongEntity();		
		entity.setName(model.getName());
		//if(model.getAlbum() != null && model.getAlbum().getAlbumId()!=null) {
			//Optional<AlbumEntity> al = albSer.albumByAlbumId(model.getAlbum().getAlbumId());
			
			//if(al.isPresent()) {
			//	log.info(al.get().getName());
			//	entity.setAlbum(al.get());
			//}
		//}
		return entity;
	}

	@Override
	public SongEntity createSong(SongEntity entity) {
		return songRep.save(entity);
		
	}







}
