package be.ipam.spotify.api.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Song")
public class SongEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long songId;
	String name;
	@ManyToMany(mappedBy="songs")
	Set<ArtistEntity> artists;
	
	
	public long getSongId() {
		return songId;
	}
	public void setSongId(long songId) {
		this.songId = songId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<ArtistEntity> getArtists() {
		return artists;
	}
	public void setArtists(Set<ArtistEntity> artists) {
		this.artists = artists;
	}
	
	
}
