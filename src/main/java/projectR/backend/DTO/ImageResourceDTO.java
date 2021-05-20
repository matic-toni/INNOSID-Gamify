package projectR.backend.DTO;

import projectR.backend.model.ImageResource;

public class ImageResourceDTO {
	private Long imageResourceID;
	private String imageURL;
	
	public ImageResourceDTO(ImageResource res) {
		this.imageResourceID = res.getImageResourceID();
		this.imageURL = res.getImageURL();
	}

	public Long getImageResourceID() {
		return imageResourceID;
	}

	public void setImageResourceID(Long imageResourceID) {
		this.imageResourceID = imageResourceID;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}
