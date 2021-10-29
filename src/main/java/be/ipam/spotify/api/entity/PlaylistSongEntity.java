package be.ipam.spotify.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PlaylistSong")
@Data
public class PlaylistSongEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long playlistSongId;
	
	@ManyToOne
	@JoinColumn(name="PlaylistId")
	PlaylistEntity playlist;
	
	@ManyToOne
	@JoinColumn(name="SongId")
	SongEntity song;
	
	int position;

	
}
