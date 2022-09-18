package com.cf.dao;

import java.util.List;

import com.cf.model.Home;
public interface IHomeDao
{
	public abstract Home addHome(Home home) throws SQLException;
	public abstract Home deleteHome(int tid);
	public abstract Home updateHome(Home home) throws SQLException;
	public abstract Home UpdateAddNo(Home home);
	public abstract Home UpdateLoc(Home home);
	public abstract Home UpdateStyle(Home home);
	public abstract Home UpdatePaint(Home home);
	public abstract Home UpdateBhk(Home home);
	public abstract Home UpdateFloor(Home home);
	public abstract Home UpdateRent(Home home);


	public abstract List<Home> getByLoc(String name) throws SQLException;
	public abstract List<Home> getByAddNo(int id) throws SQLException; 
	public abstract List<Home> displayAll() throws SQLException;
}