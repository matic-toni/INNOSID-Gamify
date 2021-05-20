package projectR.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name = "speakers")
public class Speaker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long speakerID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "institution")
	private String institution;
	
	@Column(name = "pictureURL")
	private String pictureURL;

	@ManyToMany(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "speakers")
	private Set<Speech> speeches = new HashSet<>();
	
	public Speaker() {
		
	}

	public Speaker(String name, String surname, String role, String institution, String pictureURL) {
		super();
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.institution = institution;
		this.pictureURL = pictureURL;
	}

	public Long getSpeakerID() {
		return speakerID;
	}

	public void setSpeakerID(Long speakerID) {
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

	public Set<Speech> getSpeeches() {
		return null;
	}

	public void setSpeeches(Set<Speech> speeches) {
		this.speeches = speeches;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	
	@Override
	public String toString() {
		return "Speaker [speakerID=" + speakerID + ", name=" + name + ", surname=" + surname + ", role=" + role
				+ ", institution=" + institution + ", pictureURL=" + pictureURL + ", speeches=" + speeches + "]";
	}	
	
	@PreRemove
	private void removeGroupsFromUsers() {
	    for (Speech s : speeches) {
	        s.getSpeakers().remove(this);
	    }
	}
	
}
