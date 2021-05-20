package projectR.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gamerecord_platformer")
public class PlatformerRecord {
	
	@Id
	@GeneratedValue
	@Column(name = "recordID")
	private Long id;
	
	private String email;
	
	private String username;
	
	private String duration;

	
	public PlatformerRecord() {
		super();
	}

	public PlatformerRecord(String email, String username, String duration) {
		this.email = email;
		this.username = username;
		this.duration = duration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "GameRecordPlatformer [email=" + email + ", username=" + username + ", duration="
				+ duration + "]";
	}
	
}
