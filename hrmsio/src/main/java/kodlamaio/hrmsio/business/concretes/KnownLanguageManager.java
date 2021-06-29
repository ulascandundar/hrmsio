package kodlamaio.hrmsio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsio.business.abstracts.KnownLanguageService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.dataAccess.abstracts.KnownLanguageDao;
import kodlamaio.hrmsio.entities.concretes.KnownLanguage;

@Service
public class KnownLanguageManager implements KnownLanguageService{

	private KnownLanguageDao knownLanguageDao;
	@Autowired
	public KnownLanguageManager(KnownLanguageDao knownLanguageDao) {
		super();
		this.knownLanguageDao = knownLanguageDao;
	}
	@Override
	public DataResult<List<KnownLanguage>> getAll() {
		return new SuccessDataResult<List<KnownLanguage>>(this.knownLanguageDao.findAll());
	}
	@Override
	public Result add(KnownLanguage knownLanguage) {
		this.knownLanguageDao.save(knownLanguage);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<KnownLanguage>> getByUserId(int userId) {
		return new SuccessDataResult<List<KnownLanguage>>(this.knownLanguageDao.findByUserId(userId));
	}
}
