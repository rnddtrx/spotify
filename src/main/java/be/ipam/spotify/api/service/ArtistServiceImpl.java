package be.ipam.spotify.api.service;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.model.Artist;
import be.ipam.spotify.api.repository.ArtistRepository;
import be.ipam.spotify.api.repository.SongRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

	private ArtistRepository artistRep;
	
	public ArtistServiceImpl(ArtistRepository artistRep) {
		this.artistRep=artistRep;
	}
	
	@Override
	public Optional<ArtistEntity> artistByArtistId(long artistId) {
		return artistRep.findById(artistId);
		
	}
	
	@Override
	public Artist toModel(ArtistEntity e) {
	    Artist m = new Artist();
	    m.artistId(e.getArtistId()).name(e.getName());
	    return m;
	  }

	@Override
	public List<Artist> toModelList(Set<ArtistEntity> artists) {
		if (Objects.isNull(artists)) {
			return Collections.emptyList();
		}
		   return artists.stream().map(e -> toModel(e)).collect(toList());
	}
	
	

}
