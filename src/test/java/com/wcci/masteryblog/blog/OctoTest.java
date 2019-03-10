package com.wcci.masteryblog.blog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wcci.masteryblog.blog.models.Octothorp;
import com.wcci.masteryblog.blog.repositories.OctoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class OctoTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	OctoRepository octoRepo;
	
	@Test
	public void shouldAddTagToTags(){
		Octothorp tag = octoRepo.save(new Octothorp("tag"));
		
		entityManager.persist(tag);
		entityManager.flush();
		entityManager.clear();
		
		Long idToFind = 1L;
		Octothorp tagFromDB = octoRepo.findById(idToFind).get();
		
		assertThat(tagFromDB.getId(), is(1L));
	}
}
