package com.home.directory.core;

public class Controller {
	
	private static Controller instance;
 	
	private Controller() {
		
	}
	
	public static Controller getInstance() {
		return  instance == null ? new Controller() : instance;
	}

	private String selectedformat;

	public String getSelectedformat() {
		return selectedformat;
	}

	public void setSelectedformat(String selectedformat) {
		this.selectedformat = selectedformat;
	}
	 
//	  if (formatName.equals(xmlnameFromView)){
//		  
//		  DAO.dao = new XMLDAO();		  
//	  }else if (formatName.equals(csvnameFromView)){
//		  
//		  DAO.dao = new CSVDAO();
//	  }
//}h
	
//	private static String XMLDAO = "xmlformatName";
//	private static String CSVDAO = "csvformatName";
//	
//	private DOM dom
//	switch(Controller.getNameFromView()){
//	case XMLDAO: dao = new XMLDAO(); break;
//	case CSVDAO: dao = new CSVDAO(); break;
//	}
//	
}
