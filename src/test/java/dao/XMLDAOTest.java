package dao;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.home.directory.dao.XMLDAO;
import com.home.directory.domain.PartyContact;

public class XMLDAOTest {

	private XMLDAO xmlDao;
	private List<PartyContact> pcList;
	private PartyContact pc1, pc2;

	public List<PartyContact> setList() {

		pc1 = new PartyContact.PartyContactBuilder().withLastName("Don")
				.withFirstName("Ben").withSecondName("Din")
				.withMobilePhone("0639858585").withHomePhone("4582356")
				.withPostalAdress("Ukraine").withEMail("rty@tyr.com").build();

		pc2 = new PartyContact.PartyContactBuilder().withLastName("Bill")
				.withFirstName("Ader").withSecondName("Nick")
				.withMobilePhone("896585588").withHomePhone("345235")
				.withPostalAdress("Ukraine").withEMail("89000@tyr.com").build();

		pcList = new ArrayList<PartyContact>();
		pcList.add(pc1);
		pcList.add(pc2);

		return pcList;
	}

	@Before
	public void initObject() {
		xmlDao = new XMLDAO();

		setList();

	}

	@Test
	public void readFromXML() {

		assertNotNull(xmlDao);
		assertEquals("Who", xmlDao.read().get(0).getLastName());

		assertEquals("Zerov", xmlDao.read().get(1).getLastName());

	}

	@Test
	public void writeToXML() {
		xmlDao.write(pcList);

	}

}
