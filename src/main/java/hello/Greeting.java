package hello;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "greeting")
public class Greeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final long id;
	private final String msg;

}