package be.ipam.spotify.api.hateoas;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Song;
import be.ipam.spotify.api.service.AlbumService;
import be.ipam.spotify.api.service.ArtistService;
import be.ipam.spotify.api.controllers.SongsController;

@Component
public class SongRepresentationModelAssembler extends RepresentationModelAssemblerSupport<SongEntity,Song> {

	private ArtistService artistService;
	private AlbumService albumService;
	private ArtistRepresentationModelAssembler artAssembler;
	
	private static final Logger log = LoggerFactory.getLogger(SongRepresentationModelAssembler.class);
	
	
	public SongRepresentationModelAssembler(ArtistService artistService,AlbumService albumService,ArtistRepresentationModelAssembler artAssembler) {
		super(SongsController.class,Song.class);
		this.artistService=artistService;
		this.artAssembler=artAssembler;
		this.albumService=albumService;
	}

	@Override
	public Song toModel(SongEntity entity) {

	    Song resource = createModelWithId(entity.getSongId(), entity);
	    BeanUtils.copyProperties(entity, resource);
	 
	    resource.songId(entity.getSongId())
        .artists(artistService.toModelList(entity.getArtists())).setAlbum(albumService.toModel(entity.getAlbum()));;
	    
	    System.out.println("resource = " + resource);

	    return resource;
	}

}
