package hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
	Greeting findById(Long id);

	Greeting findByMsg(String msg);

	Greeting findByIdAndMsg(Long id, String msg);
}
