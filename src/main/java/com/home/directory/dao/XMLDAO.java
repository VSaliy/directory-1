package com.home.directory.dao;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import com.home.directory.domain.PartyContact;


public class XMLDAO implements DAO {

	String id, lastname, firstname, secondname, mobilephone, homephone,
			address, email;

	public List<PartyContact> read() {

		final List<PartyContact> builder;

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		NodeList nodeList = null;

		try {

			documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new File("xmlFiles/directory.xml"));
			// document.getDocumentElement().normalize();
			nodeList = document.getElementsByTagName("person");
			// String rootElement = document.getDocumentElement().getNodeName();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		builder = new ArrayList<PartyContact>();

		for (int temp = 0; temp < nodeList.getLength(); temp++) {
			Node node = nodeList.item(temp);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element person = (Element) node;

				id = person.getAttribute("id");
				lastname = person.getElementsByTagName("lastname").item(0)
						.getTextContent();
				firstname = person.getElementsByTagName("firstname").item(0)
						.getTextContent();
				secondname = person.getElementsByTagName("secondname").item(0)
						.getTextContent();
				mobilephone = person.getElementsByTagName("mobilephone")
						.item(0).getTextContent();
				homephone = person.getElementsByTagName("homephone").item(0)
						.getTextContent();
				address = person.getElementsByTagName("address").item(0)
						.getTextContent();
				email = person.getElementsByTagName("email").item(0)
						.getTextContent();
			}

			builder.add(new PartyContact.PartyContactBuilder()
					.withLastName(lastname).withFirstName(firstname)
					.withSecondName(secondname).withMobilePhone(mobilephone)
					.withHomePhone(homephone).withPostalAdress(address).withEMail(email).build());

		}

		return builder;

	}

	public void write(List<PartyContact> pcList) {
		
		
		try {

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentFactory
					.newDocumentBuilder();

			// define root elements
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("directory");
			document.appendChild(rootElement);
			
			int i = 0;
			
			Iterator<PartyContact> itr = pcList.iterator();
			while(itr.hasNext()) {
				PartyContact pc = itr.next();	
			i++;
			
			String id = String.valueOf(i);
				
			lastname = pc.getLastName();
			firstname = pc.getFirstName();
			secondname = pc.getSecondName();
			mobilephone = pc.getMobilePhone();
			homephone = pc.getHomePhone();
			address = pc.getAddress();
			email = pc.geteMail();
			
				
			Element person = document.createElement("person");
			rootElement.appendChild(person);

			Attr attribute = document.createAttribute("id");
			attribute.setValue(id);
			person.setAttributeNode(attribute);

			// lastname elements
			Element lastnameE = document.createElement("lastname");
			lastnameE.appendChild(document.createTextNode(lastname));
			person.appendChild(lastnameE);

			// firstname elements
			Element firstnameE = document.createElement("firstname");
			firstnameE.appendChild(document.createTextNode(firstname));
			person.appendChild(firstnameE);

			// secondname elements
			Element secondnameE = document.createElement("secondname");
			secondnameE.appendChild(document.createTextNode(secondname));
			person.appendChild(secondnameE);

			// mobilephone elements
			Element mobilephoneE = document.createElement("mobilephone");
			mobilephoneE.appendChild(document.createTextNode(mobilephone));
			person.appendChild(mobilephoneE);

			// phone elements
			Element homePhoneE = document.createElement("phone");
			homePhoneE.appendChild(document.createTextNode(homephone));
			person.appendChild(homePhoneE);

			// address elements
			Element addressE = document.createElement("address");
			addressE.appendChild(document.createTextNode(address));
			person.appendChild(addressE);

			// email elements
			Element emailE = document.createElement("email");
			emailE.appendChild(document.createTextNode(email));
			person.appendChild(emailE);
			
			}

			// creating and writing to xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(
					"xmlFiles/directory1.xml"));

			transformer.transform(domSource, streamResult);

			System.out.println("File saved to specified path!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}

}
