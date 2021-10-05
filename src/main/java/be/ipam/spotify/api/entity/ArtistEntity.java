package be.ipam.spotify.api.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Artist")
public class ArtistEntity {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		long artistId;
		String name;
		@ManyToMany(cascade = {CascadeType.ALL})
		@JoinTable(
				name="ArtistSong",
				joinColumns= {@JoinColumn(name="ArtistId")},
				inverseJoinColumns= {@JoinColumn(name="SongId")}
		)
		Set<SongEntity> songs;

		public long getArtistId() {
			return artistId;
		}

		public void setArtistId(long artistId) {
			this.artistId = artistId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<SongEntity> getSongs() {
			return songs;
		}

		public void setSongs(Set<SongEntity> songs) {
			this.songs = songs;
		}
		
		
		
}
