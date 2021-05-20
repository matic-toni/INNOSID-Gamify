package projectR.backend.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class Image {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	
	@Column(name = "picByte", length = 10000)
	private byte[] picByte;
	
	
	public Image() {
		
	}
	
	public Image(String name, byte[] picByte) {
		this.name = name;
		this.picByte = picByte;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", picByte=" + Arrays.toString(picByte) + "]";
	}
	
}
