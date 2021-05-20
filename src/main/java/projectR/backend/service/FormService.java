package projectR.backend.service;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import projectR.backend.model.Form;
import projectR.backend.repository.FormRepo;

@Service
public class FormService {
	@Autowired
	private FormRepo formRepo;
	
	public List<Form> retrieveAll() {
		return formRepo.findAll();
	}

	public boolean addForm(Form form) {
		try {
			if(form.getTitle().strip() == "" || form.getLink().strip() == "")
				throw new Exception("Fill all fields!");
			
			// ako nije url baca MalformedURLException
	    	@SuppressWarnings("unused")
			URL url = new URL(form.getLink());
	    	
			this.formRepo.save(form);
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public void removeForm(long id) {
		formRepo.removeByFormID(id);
	}

	public ModelAndView getUpdateForm(Long id, String message) {
		 ModelAndView mv = new ModelAndView("updateForm");

	     Form form = formRepo.getOne(id);

	     mv.addObject("form", form);
	     mv.addObject("message", message);

	     return mv;
	}
	
	public boolean updateForm(Form form) {
    	try {
    		if(form.getTitle().strip() == "" || form.getLink().strip() == "") {
    			throw new Exception("Some fields are empty.");
    		}
    		
    		// ako nije url baca MalformedURLException
	    	@SuppressWarnings("unused")
			URL url = new URL(form.getLink());
	    	
    		formRepo.save(form);
    		return true;
    	} catch (Exception ex) {
    		System.out.println(ex);
    		return false;
    	}
    }
	
}
