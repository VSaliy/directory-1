package com.home.directory.dao;

import java.util.ArrayList;

import com.home.directory.domain.PartyContact;

public interface DAO {
	public  ArrayList<PartyContact> read() throws Exception;
	public void write(PartyContact pc);

}
