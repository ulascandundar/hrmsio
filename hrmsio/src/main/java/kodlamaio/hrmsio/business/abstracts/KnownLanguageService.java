package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.KnownLanguage;

public interface KnownLanguageService {

	DataResult<List<KnownLanguage>> getAll();
	Result add(KnownLanguage knownLanguage);
	DataResult<List<KnownLanguage>> getByUserId(int userId);
}

