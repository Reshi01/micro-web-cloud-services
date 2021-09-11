package co.edu.javeriana.ws.rest;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "paseo")
@XmlAccessorType (XmlAccessType.FIELD)
public class Paseo {
	private String id;
	private String name;
	private String startLocation;
	private String endLocation;
	private String date;
	
	public Paseo() {
		super();
	}
	
	public Paseo(String id, String name, String startLocation, String endLocation, String date) {
		super();
		this.id = id;
		this.name = name;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
