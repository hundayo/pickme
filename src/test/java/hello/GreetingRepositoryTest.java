package hello;

import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingRepositoryTest {

	@Autowired
	GreetingRepository greetingRepository;

	Greeting greeting1;
	Greeting greeting2;

	@Before
	public void setUp() throws Exception {
		greeting1 = Greeting.builder().msg("Hello").build();
		greeting2 = Greeting.builder().msg("JPA").build();

		greetingRepository.save(greeting1);
		greetingRepository.save(greeting2);

		assertNotNull(greeting1.getId());
		assertNotNull(greeting2.getId());
	}

	@Test
	public void findById() throws Exception {
		Greeting temp = greetingRepository.findById(greeting1.getId());

		assertNotNull(temp);
		assertEquals(greeting1.getMsg(), temp.getMsg());
		Iterable<Greeting> greetings = greetingRepository.findAll();
		Lists.newArrayList(greetings).stream().forEach(g -> System.out.println(g));

	}

	@Test
	public void findByMsg() throws Exception {
		Greeting temp = greetingRepository.findByMsg(greeting2.getMsg());

		assertNotNull(temp);
		assertEquals(greeting2.getMsg(), temp.getMsg());
	}

	@Test
	public void findByIdAndMsg() throws Exception {
		Greeting temp = greetingRepository.findByIdAndMsg(greeting1.getId(), greeting1.getMsg());

		assertNotNull(temp);
		assertEquals(greeting1.getId(), temp.getId());
		assertEquals(greeting1.getMsg(), temp.getMsg());
	}

}