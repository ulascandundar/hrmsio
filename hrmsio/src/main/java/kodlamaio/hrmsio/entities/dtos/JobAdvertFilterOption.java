package kodlamaio.hrmsio.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilterOption {

	private List<Integer> city_id;
	private List<Integer> jobposition_id;
	private List<Integer> time_id;
}
