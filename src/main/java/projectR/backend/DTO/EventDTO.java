package projectR.backend.DTO;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import projectR.backend.model.Event;
import projectR.backend.model.ImageResource;
import projectR.backend.model.Speech;

public class EventDTO {
	private long eventID;
	private String date;
	private String time;
	private String location;
	private String description;
	private Set<String> imageResources;
	private Set<SpeechDTO> speeches;
	
	public EventDTO() {
		
	}
	
	public EventDTO(Event event) {
		this.eventID = event.getEventID();
		this.date = formatDate(event.getDate());
		this.time = formatTime(event.getTime());
		this.location = event.getLocation();
		this.description = event.getDescription();
		this.imageResources = getOnlyUrls(event.getImageResources());
		this.speeches = formatSpeeches(event.getSpeeches());
	}
	
	public EventDTO(String date, String time, String location, String description) {
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
	}

	private Set<SpeechDTO> formatSpeeches(Set<Speech> speeches) {
		Set<SpeechDTO> speechDTO = new HashSet<>();
		for (Speech s : speeches) {
			SpeechDTO sDTO = new SpeechDTO(s);
			speechDTO.add(sDTO);
		}
		return speechDTO;
	}

	private String formatTime(Time time) {
		SimpleDateFormat formatter = new SimpleDateFormat("H:mm");
		String formattedTime = formatter.format(time);
		return formattedTime;
	}

	private String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String formattedDate = formatter.format(date);
		return formattedDate;
	}
	
	public Set<String> getOnlyUrls(Set<ImageResource> images) {
		Set<String> imageURLs = new HashSet<>();
		for(ImageResource i : images) {
			imageURLs.add(i.getImageURL());
		}
		return imageURLs;
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public Set<SpeechDTO> getSpeeches() {
		return speeches;
	}

	public void setSpeeches(Set<SpeechDTO> speeches) {
		this.speeches = speeches;
	}

	public Set<String> getImageResources() {
		return imageResources;
	}
	
	public void setImageResources(Set<String> imageResources) {
		this.imageResources = imageResources;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
