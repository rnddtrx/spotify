package be.ipam.spotify.api.entity;

import java.util.List;
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

import lombok.Data;


@Entity
@Table(name="Artist")
@Data
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
		List<SongEntity> songs;
		
		
		


		
		
		
}
