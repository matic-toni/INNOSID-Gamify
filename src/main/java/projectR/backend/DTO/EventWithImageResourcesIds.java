package projectR.backend.DTO;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import projectR.backend.model.Event;

public class EventWithImageResourcesIds {
	private long eventID;
	private String date;
	private String time;
	private String location;
	private String description;
	private Set<ImageResourceDTO> imageResources;
	
	public EventWithImageResourcesIds(Event event) {
		this.eventID = event.getEventID();
		this.date = formatDate(event.getDate());
		this.time = formatTime(event.getTime());
		this.location = event.getLocation();
		this.description = event.getDescription();
		this.imageResources = event.getImageResources()
				.stream()
				.map(resource -> new ImageResourceDTO(resource))
				.collect(Collectors.toCollection(LinkedHashSet::new));
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
	

	public long getEventID() {
		return eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public Set<ImageResourceDTO> getImageResources() {
		return imageResources;
	}

	public void setImageResources(Set<ImageResourceDTO> imageResources) {
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
