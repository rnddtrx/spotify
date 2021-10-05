package be.ipam.spotify.api.controllers;

import static org.springframework.http.ResponseEntity.notFound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import be.ipam.spotify.api.ArtistApi;
import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.hateoas.ArtistRepresentationModelAssembler;
import be.ipam.spotify.api.hateoas.SongRepresentationModelAssembler;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.service.ArtistService;
import be.ipam.spotify.api.service.SongService;

import java.util.Map;
import java.util.Optional;

@RestController
public class ArtistsController implements ArtistApi {

	private static final Logger log = LoggerFactory.getLogger(ArtistsController.class);
	private ArtistService service;
	private ArtistRepresentationModelAssembler assembler;
	
	public ArtistsController(ArtistService service, ArtistRepresentationModelAssembler assembler) {
		    this.service = service;
		    this.assembler = assembler;
		  }
	
	@Override
	
	
	public ResponseEntity<Artist> getArtistById(Long artistId) {
		//Optional<ArtistEntity> ae = service.artistByArtistId(artistId);
		//log.info(ae.get().getSongs().toString());
		return service.artistByArtistId(artistId).map(assembler::toModel).map(ResponseEntity::ok).orElse(notFound().build());
	}

}
