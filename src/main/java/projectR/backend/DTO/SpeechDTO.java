package projectR.backend.DTO;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import projectR.backend.model.Speaker;
import projectR.backend.model.Speech;

public class SpeechDTO {
	private String name;
	private String startTime;
	private String endTime;
	private List<SpeakerDTO> speakers;
	
	public SpeechDTO (Speech speech) {
		this.name = speech.getName();
		this.startTime = formatTime(speech.getStartTime());
		this.endTime = formatTime(speech.getEndTime());
		this.speakers = formatSpeakers(speech.getSpeakers());
	}
	
	private List<SpeakerDTO> formatSpeakers(List<Speaker> speakers) {
		List<SpeakerDTO> speakerDTO = new ArrayList<>();
		for (Speaker s: speakers) {
			SpeakerDTO sDTO = new SpeakerDTO(s);
			speakerDTO.add(sDTO);
		}
		return speakerDTO;
	}

	private String formatTime(Time time) {
		SimpleDateFormat formatter = new SimpleDateFormat("H.mm");
		String timeFormatted = formatter.format(time);
		return timeFormatted;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public List<SpeakerDTO> getSpeakers() {
		return speakers;
	}
	public void setSpeakers(List<SpeakerDTO> speakers) {
		this.speakers = speakers;
	}
	
}
