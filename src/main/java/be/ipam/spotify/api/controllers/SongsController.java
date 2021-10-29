package be.ipam.spotify.api.controllers;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.notFound;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import be.ipam.spotify.api.SongApi;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.hateoas.SongRepresentationModelAssembler;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.model.Song;
import be.ipam.spotify.api.service.SongService;

@RestController
public class SongsController implements SongApi {

	private static final Logger log = LoggerFactory.getLogger(SongsController.class);
	private SongService service;
	private SongRepresentationModelAssembler assembler;
	
	public SongsController(SongService service, SongRepresentationModelAssembler assembler) {
		    this.service = service;
		    this.assembler = assembler;
		  }
	

	public ResponseEntity<Void> deleteSong(Long songId) {
		this.service.deleteSong(songId);
		return new ResponseEntity(HttpStatus.OK);
	}


	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Song> getSongById(Integer songId) {
		log.info("SongID: "+songId);
		Optional<SongEntity> ose = service.songBySongId(songId);
		log.info("ose");
		Optional<Song> s = Optional.empty();
		if(ose.isPresent()) {
			SongEntity so = ose.get();
			log.info("ose3");
			s = Optional.of(assembler.toModel(so));
		}
		
		log.info("ose2");
		
		return s.map(ResponseEntity::ok).orElse(notFound().build());
		//return ok(assembler.toModel(service.songBySongId(songId)));
	}
	
	
	


	public ResponseEntity<List<Artist>> getArtistsBySongId(String songId) {
		return ok(Collections.EMPTY_LIST);
	}



	@Override
	public ResponseEntity<Song> createSong(@Valid Song song) {
		return Optional.of(service.createSong(service.toEntity(song))).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}


//	public ResponseEntity<Song> createSong(String name) {
//		return Optional.of(service.createSong(name)).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());			
//	}
	
	
	
	
	
	
}
