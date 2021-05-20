package projectR.backend.DTO;

import java.util.Set;
import java.util.TreeSet;

import projectR.backend.model.App;
import projectR.backend.model.ImageResource;

public class AppDTO {
	private Set<String> imageResources = new TreeSet<>();
	
	public AppDTO(App app) {
		this.imageResources = getOnlyURLs(app.getImageResources());
	}
	
	public Set<String> getImageResources() {
		return imageResources;
	}
	
	public void setImageResources(Set<String> imageResources) {
		this.imageResources = imageResources;
	}

	private Set<String> getOnlyURLs(Set<ImageResource> images) {
		Set<String> imageURLs = new TreeSet<>();
		for(ImageResource i : images) {
			imageURLs.add(i.getImageURL());
		}
		return imageURLs;
	}
	
}
