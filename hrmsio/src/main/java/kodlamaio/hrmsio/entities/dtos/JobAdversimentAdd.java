package kodlamaio.hrmsio.entities.dtos;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdversimentAdd {

	private String jobDescription;
	private double minSalary;
	private double maxSalary;
	private int numberOfOpenPositions;
	private Date applicationDeadline;
	private Date postedDate;
	private int employer_id;
	private int time_id;
	private int jobposition_id;
	private int city_id;

}
