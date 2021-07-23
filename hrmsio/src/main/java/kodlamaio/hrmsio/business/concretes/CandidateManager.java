package kodlamaio.hrmsio.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsio.core.utilities.results.ErrorResult;
import kodlamaio.hrmsio.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsio.entities.dtos.CandidateCv;
import kodlamaio.hrmsio.business.abstracts.CandidateSkillService;
import kodlamaio.hrmsio.business.abstracts.ImageService;
import kodlamaio.hrmsio.business.abstracts.KnownLanguageService;
import kodlamaio.hrmsio.business.abstracts.SchoolService;
import kodlamaio.hrmsio.business.abstracts.CandidateService;
import kodlamaio.hrmsio.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsio.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private JobAdvertisementService jobAdvertisementService;
	private KnownLanguageService knownLanguageService;
	private SchoolService schoolService;
	private CandidateSkillService candidateSkillService;
	private ImageService imageService;
	@Autowired
	public CandidateManager(CandidateDao candidateDao,JobAdvertisementService jobAdvertisementService,KnownLanguageService knownLanguageService,
			SchoolService schoolService,CandidateSkillService candidateSkillService,ImageService imageService) {
		super();
		this.candidateDao = candidateDao;
		this.jobAdvertisementService=jobAdvertisementService;
		this.knownLanguageService=knownLanguageService;
		this.schoolService=schoolService;
		this.candidateSkillService=candidateSkillService;
		this.imageService=imageService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult();
	}

	@Override
	public Result likeJobAdvertisement(int candidateId, int jobAdvertisementId) {
		Candidate currentCandidate = this.candidateDao.findById(candidateId);
		List<JobAdvertisement> currentFavouriteJobAdvertisements = currentCandidate.getFavouriteJobAdvertisements();
		JobAdvertisement newFavouriteJobAdvertisement = this.jobAdvertisementService.findById(jobAdvertisementId).getData();
		if (!currentFavouriteJobAdvertisements.contains(newFavouriteJobAdvertisement)) {
			currentFavouriteJobAdvertisements.add(newFavouriteJobAdvertisement);
			currentCandidate.setFavouriteJobAdvertisements(currentFavouriteJobAdvertisements);
			this.candidateDao.save(currentCandidate);// updated jobSeeker
			return new SuccessResult("Favorilere eklendi.");
		} else {
			return new ErrorResult("eklenemedi.");
		}
	}

	@Override
	public Result dislikeJobAdvertisement(int candidateId, int jobAdvertisementId) {
		Candidate currentCandidate = this.candidateDao.findById(candidateId);
		List<JobAdvertisement> currentFavouriteJobAdvertisements = currentCandidate.getFavouriteJobAdvertisements();
		JobAdvertisement jobAdvertisementDislike = this.jobAdvertisementService.findById(jobAdvertisementId).getData();
		if (currentFavouriteJobAdvertisements.remove(jobAdvertisementDislike)) {
			currentCandidate.setFavouriteJobAdvertisements(currentFavouriteJobAdvertisements);
			this.candidateDao.save(currentCandidate);// updated jobSeeker
			return new SuccessResult("favorilerden çıkartıldı.");
		} else {
			return new ErrorResult("favorilerden çıkartılamadı.");
		}
	}

	@Override
	public DataResult<List<Candidate>> getAllByFavouriteJobAdvertisementsId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CandidateCv>> getAllCv() {
		List<CandidateCv> cvs=new ArrayList<CandidateCv>();
		List<Candidate> candidates= this.candidateDao.findAll();
		for (Candidate candidate : candidates) {
			cvs.add(new CandidateCv(
					candidate.getFirst_name(),
					candidate.getLast_name(),
					candidate.getIdentity_number(),
					candidate.getBirth_date(),
					candidate.getNationalityId(),
					candidate.getLinkedInAccount(),
					candidate.getGithubAccount(),
					this.knownLanguageService.getByUserId(candidate.getId()).getData(),
					this.candidateSkillService.getByUserId(candidate.getId()).getData(),
					this.schoolService.getByUserId(candidate.getId()).getData(),
					this.imageService.getByUserId(candidate.getId()).getData()
					
					));
		}
		return new SuccessDataResult<List<CandidateCv>>(cvs,"Cvler Listelendi");
	}

	@Override
	public DataResult<CandidateCv> getByCandidateId(int candidateId) {
		CandidateCv candidateCv= new CandidateCv();
		Candidate candidate=this.candidateDao.getById(candidateId);
		candidateCv.setFirst_name(candidate.getFirst_name());
		candidateCv.setLast_name(candidate.getLast_name());
		candidateCv.setIdentity_number(candidate.getIdentity_number());
		candidateCv.setBirth_date(candidate.getBirth_date());
		candidateCv.setNationalityId(candidate.getNationalityId());
		candidateCv.setLinkedInAccount(candidate.getLinkedInAccount());
		candidateCv.setGithubAccount(candidate.getGithubAccount());
		candidateCv.setLanguages(this.knownLanguageService.getByUserId(candidateId).getData());
		candidateCv.setCandidateSkills(this.candidateSkillService.getByUserId(candidateId).getData());
		candidateCv.setSchools(this.schoolService.getByUserId(candidateId).getData());
		candidateCv.setImages(this.imageService.getByUserId(candidateId).getData());
		return new SuccessDataResult<CandidateCv>(candidateCv);
	}

	@Override
	public Result updateGithub(String githublink, int candidateId) {
		Candidate candidate= this.candidateDao.findById(candidateId);
		candidate.setGithubAccount(githublink);
		this.candidateDao.save(candidate);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result deleteGithub(int candidateId) {
		Candidate candidate= this.candidateDao.getById(candidateId);
		candidate.setGithubAccount(null);
		this.candidateDao.save(candidate);
		return new SuccessResult("Silindi");
	}

	@Override
	public Result updateLinkedin(String linkedinlink, int candidateId) {
		Candidate candidate= this.candidateDao.findById(candidateId);
		candidate.setLinkedInAccount(linkedinlink);
		this.candidateDao.save(candidate);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result deleteLinkedin(int candidateId) {
		Candidate candidate= this.candidateDao.getById(candidateId);
		candidate.setLinkedInAccount(null);
		this.candidateDao.save(candidate);
		return new SuccessResult("Silindi");
	}

}
