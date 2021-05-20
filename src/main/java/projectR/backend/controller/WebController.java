package projectR.backend.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RolesAllowed({"ADMIN"})
@Controller
public class WebController {
	
	@GetMapping("index")
	public String manage() {
		return "index";
	}

}
