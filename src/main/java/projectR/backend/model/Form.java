package projectR.backend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "forms")
public class Form {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long formID;
	
	@NotNull
	@Column(name = "title", unique = true)
	private String title;

	@NotNull
	private String link;

	public Form() {
		
	}
	
	public Form(@NotNull String title, String link) {
		this.title = title;
		this.link = link;
	}

	
	public Long getFormID() {
		return formID;
	}

	public void setFormID(Long formID) {
		this.formID = formID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Form [formID=" + formID + ", title=" + title + ", link=" + link + "]";
	}

}
