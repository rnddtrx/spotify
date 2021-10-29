package be.ipam.spotify.api.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Playlist")
@Data
public class PlaylistEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long playlistId;
	String name;
	
	@OneToMany(mappedBy="playlist")
	List<PlaylistSongEntity> playlistSongs;

	
}
