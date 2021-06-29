package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.CandidateSkill;

public interface CandidateSkillService {

	Result add(CandidateSkill candidateSkill);
	DataResult<List<CandidateSkill>> getAll();
	DataResult<List<CandidateSkill>> getByUserId(int userId);
}
