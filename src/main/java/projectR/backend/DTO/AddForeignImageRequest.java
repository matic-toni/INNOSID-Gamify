package projectR.backend.DTO;

public class AddForeignImageRequest {
	private Long eventID;
	private String imageURL;
	
	public AddForeignImageRequest(Long eventID, String imageURL) {
		this.eventID = eventID;
		this.imageURL = imageURL;
	}
	
	public Long getEventID() {
		return eventID;
	}
	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}
