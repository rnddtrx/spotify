package be.ipam.spotify.api.controllers;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import be.ipam.spotify.api.AlbumApi;
import be.ipam.spotify.api.hateoas.AlbumRepresentationModelAssembler;
import be.ipam.spotify.api.hateoas.ArtistRepresentationModelAssembler;
import be.ipam.spotify.api.hateoas.SongRepresentationModelAssembler;
import be.ipam.spotify.api.model.Album;
import be.ipam.spotify.api.model.Song;
import be.ipam.spotify.api.service.AlbumService;
import be.ipam.spotify.api.service.ArtistService;
import be.ipam.spotify.api.service.SongService;

@RestController
public class AlbumsController implements AlbumApi {

	private static final Logger log = LoggerFactory.getLogger(ArtistsController.class);
	private AlbumService service;
	private SongService serviceSong;
	private AlbumRepresentationModelAssembler assembler;
	private SongRepresentationModelAssembler songAssembler;
	
	public AlbumsController(AlbumService service,SongService serviceSong, AlbumRepresentationModelAssembler assembler,SongRepresentationModelAssembler songAssembler) {
		    this.service = service;
		    this.assembler = assembler;
		    this.songAssembler=songAssembler;
		    this.serviceSong=serviceSong;
		    
		  }


	public ResponseEntity<Album> getAlbumById(Long albumId) {
		log.info("album by id");
		return service.albumByAlbumId(albumId).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());

	}
	


	
	

}
