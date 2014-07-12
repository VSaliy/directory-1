package com.home.directory.dao;

import java.util.List;

import com.home.directory.domain.PartyContact;

public interface DAO {
	public  List<PartyContact> read() throws Exception;
	public void write(List <PartyContact> pcList);

}
