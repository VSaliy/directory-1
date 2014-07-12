package dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.home.directory.dao.XMLDAO;
import com.home.directory.domain.PartyContact;

public class XMLDAOTest {
	
	private XMLDAO xmlDao;
	private PartyContact pc;
	
	@Before
	public void initObject(){
	xmlDao = new XMLDAO();
	
	pc = new PartyContact.PartyContactBuilder()
	.withLastName("Don").withFirstName("Ben")
	.withSecondName("Din").withMobilePhone("0639858585")
	.withHomePhone("4582356").withPostalAdress("Ukraine").withEMail("rty@tyr.com").build();
	}
	
	@Test
	public void readFromXML(){
		
		assertNotNull(xmlDao);
		assertEquals("Who", xmlDao.read().get(0).getLastName());
		
		assertEquals("Zerov", xmlDao.read().get(1).getLastName());
		
		
		
		
	}
	
	
	
	@Test
	public void writeToXML(){
		xmlDao.write(pc);
		
	}
	

}
