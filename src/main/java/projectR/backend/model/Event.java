package projectR.backend.model;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eventID;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "time")
	private Time time;
	
	@Column(name = "location")
	private String location;

	@Column(name = "description")
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "events_image_resources",
	joinColumns = { @JoinColumn(name = "eventID")},
	inverseJoinColumns = { @JoinColumn(name = "imageResourceID")})
	private Set<ImageResource> imageResources = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "event")
	private Set<Speech> speeches;
	
	public Event() {
		
	}
	
	public Event(String date, String time, String location, String description) {
		this.date = Date.valueOf(date);
		this.time = Time.valueOf(time);
		this.location = location;
		this.description = description;
	}
	
	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
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

	public Set<ImageResource> getImageResources() {
		return imageResources;
	}

	public void setPictures(Set<ImageResource> imageResources) {
		this.imageResources = imageResources;
	}
	
	public Set<Speech> getSpeeches() {
		return speeches;
	}

	public void setSpeeches(Set<Speech> speeches) {
		this.speeches = speeches;
	}

	@Override
	public String toString() {
		return "Event [eventID=" + eventID + ", date=" + date + ", time=" + time + ", location=" + location
				+ ", imageResources=" + imageResources + ", speeches=" + speeches + "]";
	}
	
}
