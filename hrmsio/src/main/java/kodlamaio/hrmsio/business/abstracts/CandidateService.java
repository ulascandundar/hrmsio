package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.entities.dtos.CandidateCv;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.Candidate;


public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	Result likeJobAdvertisement(int candidateId, int jobAdvertisementId);
	Result dislikeJobAdvertisement(int candidateId, int jobAdvertisementId);
	DataResult<List<Candidate>> getAllByFavouriteJobAdvertisementsId(int id);
	DataResult<List<CandidateCv>> getAllCv();
}
