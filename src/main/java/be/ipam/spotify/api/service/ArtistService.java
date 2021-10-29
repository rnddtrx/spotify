package be.ipam.spotify.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import be.ipam.spotify.api.entity.ArtistEntity;
import be.ipam.spotify.api.model.Artist;

public interface ArtistService {
	public Optional<ArtistEntity> artistByArtistId(long artistId);

	public List<Artist> toModelList(List<ArtistEntity> list);

	Artist toModel(ArtistEntity e);
}
