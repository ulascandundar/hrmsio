package kodlamaio.hrmsio.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsio.core.utilities.results.ErrorResult;
import kodlamaio.hrmsio.core.utilities.results.ErrorDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.adapters.PhotoUploadHelper;
import kodlamaio.hrmsio.business.abstracts.ImageService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.dataAccess.abstracts.ImageDao;
import kodlamaio.hrmsio.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private PhotoUploadHelper photoUploadHelper;
	private ImageDao imageDao;
	
	@Autowired
	public ImageManager(ImageDao imageDao,PhotoUploadHelper photoUploadHelper) {
		super();
		this.imageDao = imageDao;
		this.photoUploadHelper=photoUploadHelper;
	}

	@Override
	public Result add(Image image) {
		if(this.imageDao.save(image) != null) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

	@Override
	public DataResult<Image> upload(MultipartFile image, int userId) {
		DataResult<Map<String, String>> result = this.photoUploadHelper.upload(image);

		if(result.isSuccess()) {

			Image imagee = new Image();
			imagee.setUserId(userId);
			imagee.setImagePath(result.getData().get("url"));
			imagee.setImageTitle(result.getData().get("public_id"));
			Result addingResult = this.add(imagee);
			if (addingResult.isSuccess()) {
				return new SuccessDataResult<Image>(imagee);
			}
		}
		return new ErrorDataResult<Image>(null,"Dosya yüklenemedi");
	}

	@Override
	public DataResult<List<Image>> getByUserId(int userId) {
		return new SuccessDataResult<List<Image>>(this.imageDao.findByUserId(userId));
	}

	@Override
	public DataResult<Image> getById(int photoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

}
