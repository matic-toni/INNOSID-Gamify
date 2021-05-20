package projectR.backend.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "speeches")
public class Speech {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long speechID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "startTime")
	private Time startTime;
	
	@Column(name = "endTime")
	private Time endTime;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "speeches_speakers",
	joinColumns = { @JoinColumn(name = "speechID")},
	inverseJoinColumns = { @JoinColumn(name = "speakerID")})
	private List<Speaker> speakers = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"eventID\"")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Event event;
	
	public Speech() {
		
	}

	public Speech(String name, String startTime, String endTime) {
		super();
		this.name = name;
		this.startTime = Time.valueOf(startTime);
		this.endTime = Time.valueOf(endTime);
	}

	public Long getSpeechID() {
		return speechID;
	}

	public void setSpeechID(Long speechID) {
		this.speechID = speechID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Speech [speechID=" + speechID + ", name=" + name + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", speakers=" + speakers + "]";
	}
	
}
