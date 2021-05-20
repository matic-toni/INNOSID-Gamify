package projectR.backend.DTO;

import projectR.backend.model.Speech;

import java.util.List;
import java.util.stream.Collectors;

public class DeleteSpeechRequest {

    private Long speechID;
    private String title;
    private String startTime;
    private String endTime;
    private EventsDTO event;
    private List<SpeakerDTO> speakers;

    public DeleteSpeechRequest() {
    }

    public DeleteSpeechRequest(Long speechID, String title, String startTime, String endTime, EventsDTO event, List<SpeakerDTO> speakers) {
        this.speechID = speechID;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.event = event;
        this.speakers = speakers;
    }

    public DeleteSpeechRequest(Speech speech) {
        this.speechID = speech.getSpeechID();
        this.title = speech.getName();
        this.startTime = speech.getStartTime().toString();
        this.endTime = speech.getEndTime().toString();
        this.event = new EventsDTO(speech.getEvent());
        this.speakers = speech
                .getSpeakers()
                .stream()
                .map(s -> new SpeakerDTO(s))
                .collect(Collectors.toList());
    }

    public Long getSpeechID() {
        return speechID;
    }

    public void setSpeechID(Long speechID) {
        this.speechID = speechID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public EventsDTO getEvent() {
        return event;
    }

    public void setEvent(EventsDTO event) {
        this.event = event;
    }

    public List<SpeakerDTO> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<SpeakerDTO> speakers) {
        this.speakers = speakers;
    }
}
