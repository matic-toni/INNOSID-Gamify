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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "apps")
public class App {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appID;
	
	@NotNull
	@Column(name = "name", unique = true)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "apps_image_resources",
	joinColumns = { @JoinColumn(name = "appID")},
	inverseJoinColumns = { @JoinColumn(name = "imageResourceID")})
	private Set<ImageResource> imageResources = new HashSet<>();

	public App() {
		
	}
	
	public App(String name) {
		this.name = name;
	}
	
	public Long getAppID() {
		return appID;
	}

	public void setAppID(Long appID) {
		this.appID = appID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ImageResource> getImageResources() {
		return imageResources;
	}

	public void setImageResources(Set<ImageResource> imageResources) {
		this.imageResources = imageResources;
	}

	@Override
	public String toString() {
		return "Apps [appID=" + appID + ", image_resources=" + imageResources + "]";
	}
	
}
