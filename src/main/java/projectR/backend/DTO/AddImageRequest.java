package projectR.backend.DTO;

import java.util.Set;

public class AddImageRequest {
	
	private Long eventID;
	private Set<String> imageName;
	
	public AddImageRequest(Long eventID, Set<String> imageName) {
		super();
		this.eventID = eventID;
		this.imageName = imageName;
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public Set<String> getImageNames() {
		return imageName;
	}

	public void setImageNames(Set<String> imageName) {
		this.imageName = imageName;
	}
	
}
