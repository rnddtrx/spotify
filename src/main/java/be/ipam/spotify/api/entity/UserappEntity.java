package be.ipam.spotify.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Userapp")
@Data
public class UserappEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long userappId;
	String login;
	String password;
	String role;
}
