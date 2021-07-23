package kodlamaio.hrmsio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsio.business.abstracts.ImageService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.Image;

@RestController
@RequestMapping("/api/image")
@CrossOrigin
public class ImageController {

	private ImageService imageService;

	@Autowired
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody Image image) {
		return this.imageService.add(image);
	}
	@PostMapping("/photoUpload")
	public ResponseEntity<?> photoUpload(@RequestParam MultipartFile multipartFile ,@RequestParam int userId) {
		return ResponseEntity.ok(this.imageService.upload(multipartFile,userId));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Image>> getAll(){
		return this.imageService.getAll();
	}
	
	@GetMapping("/getbyuserid")
	public DataResult<List<Image>> getByUserId(@RequestParam int id){
		return this.imageService.getByUserId(id);
	}
}
