package projectR.backend.controller.rest;

import java.io.IOException;
import java.util.zip.DataFormatException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import projectR.backend.service.ImageService;

@RestController

public class ImageRestController {
	
	@Autowired
	ImageService imageService;
	
	@GetMapping("/images/{imageName}")
	public void getImage(@PathVariable String imageName,  HttpServletResponse response) throws IOException, DataFormatException {
		byte[] picByte = imageService.retrieveAndDecompress(imageName);
	    
		if(picByte != null) {
	    	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		    response.getOutputStream().write(picByte);
		    response.getOutputStream().close();
	    } else {
	    	response.sendError(HttpServletResponse.SC_NOT_FOUND);
	    }
	}
	
}
