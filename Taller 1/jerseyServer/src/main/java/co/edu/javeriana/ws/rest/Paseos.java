package co.edu.javeriana.ws.rest;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement(name = "paseos")
@XmlAccessorType (XmlAccessType.FIELD)
public class Paseos {
	
	@XmlElement(name = "paseo")
	private List<Paseo> paseos=null;

	public Paseos() {
		super();
	}

	public Paseos(List<Paseo> paseos) {
		super();
		this.paseos = paseos;
	}

	public List<Paseo> getPaseos() {
		return paseos;
	}

	public void setPaseos(List<Paseo> paseos) {
		this.paseos = paseos;
	}
	
	
}
