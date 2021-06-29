package kodlamaio.hrmsio.entities.dtos;

import java.util.Date;
import java.util.List;

import kodlamaio.hrmsio.entities.concretes.CandidateSkill;
import kodlamaio.hrmsio.entities.concretes.Image;
import kodlamaio.hrmsio.entities.concretes.KnownLanguage;
import kodlamaio.hrmsio.entities.concretes.School;
import kodlamaio.hrmsio.entities.dtos.CandidateCv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCv {
	private String first_name;
	private String last_name;
	private int identity_number;
	private Date birth_date;
	private long nationalityId;
	private String linkedInAccount; 
	private String githubAccount;
	private List<KnownLanguage> languages;
	private List<CandidateSkill> candidateSkills;
	private List<School> schools;
	private List<Image> images;

}
