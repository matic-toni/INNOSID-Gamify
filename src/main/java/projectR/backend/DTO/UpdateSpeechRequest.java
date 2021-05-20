package projectR.backend.DTO;

import java.util.Set;

public class UpdateSpeechRequest {

    private Long speechID;
    private String title;
    private String startTime;
    private String endTime;
    private Long eventID;
    private Set<Long> speakerID;

    public UpdateSpeechRequest() {
    }

    public UpdateSpeechRequest(Long speechID, String title, String startTime, String endTime, Long eventID, Set<Long> speakerID) {
        this.speechID = speechID;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventID = eventID;
        this.speakerID = speakerID;
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

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public Set<Long> getSpeakerID() {
        return speakerID;
    }

    public void setSpeakerID(Set<Long> speakerID) {
        this.speakerID = speakerID;
    }
}
