package projectR.backend.DTO;

import projectR.backend.model.Speaker;

public class SpeakerDTO {
	private long speakerID;
	private String name;
	private String surname;
	private String role;
	private String institution;
	private String pictureURL;
	
	public SpeakerDTO (Speaker speaker) {
		this.speakerID = speaker.getSpeakerID();
		this.name = speaker.getName();
		this.surname = speaker.getSurname();
		this.role = speaker.getRole();
		this.institution = speaker.getInstitution();
		this.pictureURL = speaker.getPictureURL();
	}

	public long getSpeakerID() {
		return speakerID;
	}
	
	public void setSpeakerID(long speakerID) {
		this.speakerID = speakerID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	
}
