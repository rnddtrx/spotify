package be.ipam.spotify.api.controllers;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.notFound;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import be.ipam.spotify.api.SongApi;
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
	
	
	@Override
	public ResponseEntity<Void> deleteSong(BigDecimal songId) {
		// TODO Auto-generated method stub
		return SongApi.super.deleteSong(songId);
	}

	@Override
	public ResponseEntity<Song> getSongById(Integer songId) {
		return service.songBySongId(songId).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
		
		
		//return ok(assembler.toModel(service.songBySongId(songId)));
	}


	@Override
	public ResponseEntity<List<Artist>> getArtistsBySongId(String songId) {
		return ok(Collections.EMPTY_LIST);
	}
	
	
	
}
