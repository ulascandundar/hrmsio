package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.Image;

public interface ImageService {
	Result add(Image image);
	DataResult<Image> upload(MultipartFile image, int candidateId);
	DataResult<List<Image>> getByUserId(int userId);
	DataResult<Image> getById(int photoId);
	DataResult<List<Image>> getAll();
}
