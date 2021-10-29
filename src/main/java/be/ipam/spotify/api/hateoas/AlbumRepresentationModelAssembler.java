package be.ipam.spotify.api.hateoas;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Set;

import be.ipam.spotify.api.controllers.AlbumsController;
import be.ipam.spotify.api.controllers.ArtistsController;
import be.ipam.spotify.api.entity.AlbumEntity;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Album;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.service.AlbumService;
import be.ipam.spotify.api.service.SongService;

@Component
public class AlbumRepresentationModelAssembler extends RepresentationModelAssemblerSupport<AlbumEntity,Album>{

	private AlbumService albumService;
	
	
	public AlbumRepresentationModelAssembler(AlbumService albumService) {
		super(AlbumsController.class,Album.class);
		this.albumService=albumService;
	}

	@Override
	public Album toModel(AlbumEntity entity) {
		Album resource = createModelWithId(entity.getAlbumId(), entity);
		resource.removeLinks();
		BeanUtils.copyProperties(entity, resource);
	      
	    resource.albumId(entity.getAlbumId())
        .songs(albumService.toModelList(entity.getSongs()));
	    
	    resource.add(linkTo(methodOn(AlbumsController.class).getAlbumById(entity.getAlbumId())).withSelfRel());
	    
	    //Set<SongEntity> songs = entity.getSongs();
	    
	    //resource.add(linkTo(methodOn(A.class).toModelList(songs)));
	    
	    
	    
	    System.out.println("resource = " + resource);
	    
	    return resource;
	}

}
