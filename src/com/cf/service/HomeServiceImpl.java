package com.cf.service;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Car;
import model.Home;
import repository.CarDaoImpl;
import repository.HomeDaoImpl;
import repository.ICarDao;
import repository.IHomeDao;

public class HomeServiceImpl implements IHomeService
{

	@Override
	public Home addHome(Home car) throws SQLException
	{
		IHomeDao idao=new HomeDaoImpl();
		idao.addCar(car);
		return null;
	}

	@Override
	public Home deleteHome(int tid) 
	{
		IHomeDao idao=new HomeDaoImpl();
		idao.deleteCar(tid);
		return null;
	}

	@Override
	public Home updateHome(Home car) throws SQLException 
	{
		IHomeDao idao=new HomeDaoImpl();
		idao2.updateCar(car);
		return null;
	}

	@Override
	public List<Home> getByLoc(String name) throws SQLException 
	{
		IHomeDao idao=new HomeDaoImpl();
		List<Car> carList1=null;
		carList1 =idao2.getByName(name);
		return carList1;
	}

	@Override
	public List<Home> getByAddNo(int id) throws SQLException {
		IHomeDao idao=new HomeDaoImpl();
		List<Car> carList2=null;
		carList2 =idao3.getById(id);
		return carList2;
	}

	@Override
	public List<Home> displayAll() throws SQLException 
	{
		IHomeDao idao=new HomeDaoImpl();
		List<Home> homeList=null;
		homeList =idao1.displayAll();
		return homeList;
	}

	@Override
	public Home UpdateId(Home home) 
	{
		IHomeDao idao=new HomeDaoImpl();
		idao2.UpdateId(home);
		return null;
	}

	@Override
	public Home UpdateName(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao2.UpdateName(home);
		return null;
	}

	@Override
	public Home UpdateBrand(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao2.UpdateBrand(home);
		return null;
	}

	@Override
	public Home UpdateColour(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao2.UpdateColour(home);
		return null;
	}

	@Override
	public Home UpdateModel(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao2.UpdateModel(home);
		return null;
	}

	@Override
	public Home UpdateVariant(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao2.UpdateVariant(home);
		return null;
	}

	@Override
	public Home UpdateCharges(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao2.UpdateCharges(home);
		return null;
	}
	public static boolean isValidLocation(String loc){
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(loc);
		return nameMatcher.matches();
	}
	public static boolean isValidStyle(String style){
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(style);
		return nameMatcher.matches();
	}
	public static boolean isValidPaint(String paint){
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(paint);
		return nameMatcher.matches();
	}
	public static boolean isValidBhk(String model){
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(model);
		return nameMatcher.matches();
	}
	public static boolean isValidFloor(String floor){
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(floor);
		return nameMatcher.matches();
	}
	public static boolean isValidAddNo(int addNo) 
	{
		return (id>0);
	}public static boolean isValidRent(int charges) 
	{
		return (charges>0);
	}

}