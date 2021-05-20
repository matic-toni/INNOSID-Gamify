package projectR.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imageResources")
public class ImageResource {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long imageResourceID;
	
	@Column(name = "imageURL")
	private String imageURL;
	
	public ImageResource() {
		
	}
	
	public ImageResource(String imageURL) {
		super();
		this.imageURL = imageURL;
	}
	
	public Long getImageResourceID() {
		return imageResourceID;
	}
	public void setImageResourceID(Long pictureID) {
		this.imageResourceID = pictureID;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	@Override
	public String toString() {
		return "Picture [imageResourceID=" + imageResourceID + ", imageURL=" + imageURL +"]";
	}
	
}
