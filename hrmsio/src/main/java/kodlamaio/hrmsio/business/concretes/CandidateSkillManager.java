package kodlamaio.hrmsio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsio.business.abstracts.CandidateSkillService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.dataAccess.abstracts.CandidateSkillDao;
import kodlamaio.hrmsio.entities.concretes.CandidateSkill;
@Service
public class CandidateSkillManager implements CandidateSkillService{

	private CandidateSkillDao candidateSkillDao;
	
	@Autowired
	public CandidateSkillManager(CandidateSkillDao candidateSkillDao) {
		super();
		this.candidateSkillDao = candidateSkillDao;
	}

	@Override
	public Result add(CandidateSkill candidateSkill) {
		this.candidateSkillDao.save(candidateSkill);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateSkill>> getAll() {
		return new SuccessDataResult<List<CandidateSkill>>(this.candidateSkillDao.findAll());
	}

	@Override
	public DataResult<List<CandidateSkill>> getByUserId(int candidateId) {
		return new SuccessDataResult<List<CandidateSkill>>(this.candidateSkillDao.findByUserId(candidateId));
	}

}
