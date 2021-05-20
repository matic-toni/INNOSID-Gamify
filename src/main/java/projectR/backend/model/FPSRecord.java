package projectR.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gamerecord_fps")
public class FPSRecord {
	
	@Id
	@GeneratedValue
	@Column(name = "recordID")
	private Long id;
	
	private String email;
	
	private String username;
	
	private Integer score;

	
	public FPSRecord() {
		super();
	}

	public FPSRecord(String email, String username, Integer score) {
		this.email = email;
		this.username = username;
		this.score = score;
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "RankingFPS [email=" + email + ", username=" + username + ", score=" + score + "]";
	}
	
}
