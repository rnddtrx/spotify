package be.ipam.spotify;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
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
					log.info("--- On : "+s.getAlbum().getName() );
			}
				
		});
	}
	
	@Test
	@Transactional
	void testDerivedQuery() {
		String name="deep end";
		log.info(songRepo.findByName(name).get(0).getName());
	}
	
	
	@Test
	@Transactional
	void testJPQLQuery() {
		String name="deep end";
		log.info("JPQL");
		log.info(songRepo.findByName2(name).get(0).getName());
	}
	
	@Test
	@Transactional
	void testNativeQuery() {
		String name="deep end";
		log.info("Native");
		log.info(songRepo.findByName3(name).get(0).getName());
	}
	
	

}
