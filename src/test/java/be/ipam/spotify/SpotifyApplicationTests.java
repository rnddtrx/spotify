package be.ipam.spotify;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.ipam.spotify.api.controllers.SongsController;
import be.ipam.spotify.api.repository.SongRepository;

@SpringBootTest
class SpotifyApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpotifyApplicationTests.class);

	
	@Autowired
	SongRepository songRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@Transactional
	void testDB() {
		songRepo.findAll().forEach(s ->
			{
				if(s.getArtists().size()>1) {
					log.info(s.getName());
					s.getArtists().forEach( a ->
					{
						log.info("--- By : "+a.getName());
					});
			}
		});
	}

}
