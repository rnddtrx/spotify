package be.ipam.spotify.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import be.ipam.spotify.api.entity.AlbumEntity;
import be.ipam.spotify.api.entity.SongEntity;
import be.ipam.spotify.api.model.Album;
import be.ipam.spotify.api.model.Song;

public interface AlbumService {
	public Optional<AlbumEntity> albumByAlbumId(long albumId);


	public List<SongEntity> songsByAlbumId(long albumId);

	public Album toModel(AlbumEntity album);

	public List<Song> toModelList(List<SongEntity> list);
}
