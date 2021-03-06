package kodlamaio.hrmsio.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_skills")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;



	@Column(name = "skill_name")
	private String skillName;
	
	@Column(name = "user_id")
	private int userId;
}
