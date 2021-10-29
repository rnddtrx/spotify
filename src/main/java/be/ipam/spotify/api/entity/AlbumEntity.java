package be.ipam.spotify.api.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Album")
@Data
public class AlbumEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long albumId;
	String name;
	
	
	@OneToMany(mappedBy="album")
	List<SongEntity> songs;
		
	
}
