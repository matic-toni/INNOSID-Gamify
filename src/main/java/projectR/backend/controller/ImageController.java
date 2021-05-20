package projectR.backend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import projectR.backend.model.Image;
import projectR.backend.service.ImageService;

@RolesAllowed({"ADMIN"})
@Controller
@RequestMapping("/images")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@GetMapping("/upload")
	public String uploadImage() {
		return "uploadImage";
	}
	
	@GetMapping("/manage")
	public ModelAndView manageImages(@RequestParam Optional<String> name) {
		ModelAndView mv =  new ModelAndView("manageImages");
		List<Image> list = new ArrayList<>();
		if(name.isEmpty()) {
			list = imageService.retrieveAll();
		} else {
			list = imageService.retrieveByNameContaining(name.get());
		}
		mv.addObject("list", list);
		return mv;
	}
	
	@PostMapping("/upload")
	public ModelAndView uploadImage(@RequestParam MultipartFile file) throws IOException {
		Image img = imageService.saveImageCompressed(file.getOriginalFilename(), file.getBytes());
		ModelAndView mv = new ModelAndView("uploadStatus");
		
		mv.addObject("isSuccesful", img != null ? true : false);
		return mv;
	}
	
	@PostMapping("/delete/{imageName}")
	@ResponseBody
	public ModelAndView deleteImage(@PathVariable String imageName) {
		imageService.deleteImage(imageName);
		return new ModelAndView("redirect:" + "/images/manage");
	}
}
