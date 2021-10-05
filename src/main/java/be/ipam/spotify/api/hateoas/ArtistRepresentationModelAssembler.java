package be.ipam.spotify.api.hateoas;

import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.ipam.spotify.api.controllers.ArtistsController;
import be.ipam.spotify.api.controllers.SongsController;
import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.model.Song;
import be.ipam.spotify.api.service.ArtistService;
import be.ipam.spotify.api.service.SongService;

@Component
public class ArtistRepresentationModelAssembler extends RepresentationModelAssemblerSupport<ArtistEntity,Artist>{

	
	private SongService songService;
	
	public ArtistRepresentationModelAssembler(SongService songService) {
		super(ArtistsController.class,Artist.class);
		this.songService=songService;
	}


	@Override
	public Artist toModel(ArtistEntity entity) {
		Artist resource = createModelWithId(entity.getArtistId(), entity);
	    BeanUtils.copyProperties(entity, resource);
	    
	    
	    resource.artistId(entity.getArtistId())
        .songs(songService.toModelList(entity.getSongs()));
	    

	    
	    
	    System.out.println("resource = " + resource);
	    
	    return resource;
	}


	
	
	
	
}
