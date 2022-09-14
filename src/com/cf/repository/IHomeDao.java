package com.cf.repository;


import java.sql.SQLException;
import java.util.List;

import mdoel.Car;
import mdoel.Home;

public interface IHomeDao
{
	public abstract Home addCar(Home car) throws SQLException;
	public abstract Home deleteCar(int tid);
	public abstract Home updateCar(Home car) throws SQLException;
	public abstract Home UpdateId(Home car);
	public abstract Home UpdateName(Home car);
	public abstract Home UpdateBrand(Home car);
	public abstract Home UpdateColour(Home car);
	public abstract Home UpdateModel(Home car);
	public abstract Home UpdateVariant(Home car);
	public abstract Home UpdateCharges(Home car);
	public abstract List<Home> getByName(String name) throws SQLException;
	public abstract List<Home> getById(int id)  throws SQLException;
	public abstract List<Home> displayAll() throws SQLException;
}