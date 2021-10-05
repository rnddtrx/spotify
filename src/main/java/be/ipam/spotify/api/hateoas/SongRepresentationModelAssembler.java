package be.ipam.spotify.api.hateoas;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Song;
import be.ipam.spotify.api.service.ArtistService;
import be.ipam.spotify.api.controllers.SongsController;

@Component
public class SongRepresentationModelAssembler extends RepresentationModelAssemblerSupport<SongEntity,Song> {

	private ArtistService artistService;
	private ArtistRepresentationModelAssembler artAssembler;
	
	public SongRepresentationModelAssembler(ArtistService artistService,ArtistRepresentationModelAssembler artAssembler) {
		super(SongsController.class,Song.class);
		this.artistService=artistService;
		this.artAssembler=artAssembler;
	}

	@Override
	public Song toModel(SongEntity entity) {
		System.out.println("\n\n\nentity = " + entity);
	    Song resource = createModelWithId(entity.getSongId(), entity);
	    BeanUtils.copyProperties(entity, resource);
	    
	    resource.songId(entity.getSongId())
        .artists(artistService.toModelList(entity.getArtists()));
	    
	    System.out.println("resource = " + resource);
	       
	    return resource;
	}

}
