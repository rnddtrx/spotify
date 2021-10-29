package be.ipam.spotify.api.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Song")
@Data
public class SongEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long songId;
	
	String name;
	
	@ManyToMany(mappedBy="songs")
	List<ArtistEntity> artists;
	
    @ManyToOne
	@JoinColumn(name="AlbumId")
	AlbumEntity album;
    
	@OneToMany(mappedBy="song")
	List<PlaylistSongEntity> playlistSongs;

		
		
}
