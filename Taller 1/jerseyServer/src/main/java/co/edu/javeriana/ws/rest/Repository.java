package co.edu.javeriana.ws.rest;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class Repository {
	
	public List<Paseo> getAllPaseo(){
		try {
		    File file = new File("paseos.xml");
		    JAXBContext jaxbContext = JAXBContext.newInstance(Paseos.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Paseos paseos = (Paseos) jaxbUnmarshaller.unmarshal(file);
		    System.out.println("Lectura");
		    return paseos.getPaseos();
		} catch (JAXBException ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
	public boolean addPaseo(Paseo paseo) {
		List<Paseo> paseos= getAllPaseo();
		for (Paseo p : paseos) {
			if(p.getId().equals(paseo.getId())) {
				return false;
			}
		}
		paseos.add(paseo);
		save(paseos);	
		return true;
	}
	
	public Paseo modifyPaseo(String id, String name, String startLocation, String endLocation) {
		if(id==null) {
			return null;
		}
		Paseo paseo=null;
		List<Paseo> paseos= getAllPaseo();
		for (Paseo p : paseos) {
			if(p.getId().equals(id)) {
				paseo=p;
				break;
			}
		}
		if(paseo!=null) {
			if(name!=null) {
				paseo.setName(name);
			}
			if(startLocation!=null) {
				paseo.setStartLocation(startLocation);
			}
			if(endLocation!=null) {
				paseo.setEndLocation(endLocation);
			}
		}
		save(paseos);
		return paseo;
	}
	
	public boolean deletPaseo(String id) {
		if(id==null) {
			return false;
		}
		List<Paseo> paseos= getAllPaseo();
		for (Paseo p : paseos) {
			if(p.getId().equals(id)){
				paseos.remove(p);
				save(paseos);
				return true;
			}
		}
		return false;
	}
	
	private void save(List<Paseo> paseos) {
		try {
			File file = new File("paseos.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Paseos.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			System.out.println("Escritura");
			jaxbMarshaller.marshal(paseos, System.out);
			jaxbMarshaller.marshal(paseos, file);
		} catch (JAXBException ex) {
		    ex.printStackTrace();
		}
	}
}
