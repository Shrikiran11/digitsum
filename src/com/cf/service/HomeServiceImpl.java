package com.cf.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cf.dao.HomeDaoImpl;
import com.cf.dao.IHomeDao;
import com.cf.model.Home;

public class HomeServiceImpl implements IHomeService
{

	@Override
	public Home addHome(Home home) throws SQLException
	{
		IHomeDao idao=new HomeDaoImpl();
		idao.addHome(home);
		return null;
	}

	@Override
	public Home deleteHome(int tid) 
	{
		IHomeDao idao=new HomeDaoImpl();
		idao.deleteHome(tid);
		return null;
	}

	@Override
	public Home updateHome(Home home) throws SQLException 
	{
		IHomeDao idao2=new HomeDaoImpl();
		idao2.updateHome(home);
		return null;
	}

	@Override
	public List<Home> getByLoc(String name) throws SQLException 
	{
		IHomeDao idao=new HomeDaoImpl();
		List<Home> homeList1=null;
		homeList1 =idao.getByLoc(name);
		return homeList1;
	}

	@Override
	public List<Home> getByAddNo(int id) throws SQLException {
		IHomeDao idao=new HomeDaoImpl();
		List<Home> homeList2=null;
		homeList2 =idao.getByAddNo(id);
		return homeList2;
	}

	@Override
	public List<Home> displayAll() throws SQLException 
	{
		IHomeDao idao=new HomeDaoImpl();
		List<Home> homeList=null;
		homeList =idao.displayAll();
		return homeList;
	}

	@Override
	public Home UpdateAddNo(Home home) 
	{
		IHomeDao idao=new HomeDaoImpl();
		idao.UpdateAddNo(home);
		return null;
	}

	@Override
	public Home UpdateLoc(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao.UpdateLoc(home);
		return null;
	}

	@Override
	public Home UpdateStyle(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao.UpdateStyle(home);
		return null;
	}

	@Override
	public Home UpdatePaint(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao.UpdatePaint(home);
		return null;
	}

	@Override
	public Home UpdateBhk(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao.UpdateBhk(home);
		return null;
	}

	@Override
	public Home UpdateFloor(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao.UpdateFloor(home);
		return null;
	}

	@Override
	public Home UpdateRent(Home home) {
		IHomeDao idao=new HomeDaoImpl();
		idao.UpdateRent(home);
		return null;
	}
	public static boolean isValidLocation(String loc){
		boolean check=false;
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(loc);
		boolean valid= nameMatcher.matches();
		if(loc.equalsIgnoreCase("Tambaram")||loc.equalsIgnoreCase("chengalpattu")||loc.equalsIgnoreCase("sholinganalur")&&valid==true)
			check=true;
		return check;
	}
	public static boolean isValidStyle(String style){
		boolean check=false;
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(style);
		boolean valid= nameMatcher.matches();
		if(style.equalsIgnoreCase("classic")||style.equalsIgnoreCase("modern")&&valid==true)
			check=true;
		return check;
	}
	public static boolean isValidPaint(String paint){
		boolean check=false;
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(paint);
		boolean valid= nameMatcher.matches();
		if(paint.equalsIgnoreCase("yellow")||paint.equalsIgnoreCase("blue")||paint.equalsIgnoreCase("green")&&valid==true)
			check=true;
		return check;
	}
	public static boolean isValidBhk(String bhk){
		boolean check=false;
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(bhk);
		boolean valid= nameMatcher.matches();
		if(bhk.equalsIgnoreCase("1bhk")||bhk.equalsIgnoreCase("2bhk")||bhk.equalsIgnoreCase("3bhk")&&valid==true)
			check=true;
		return check;
	}
	public static boolean isValidFloor(String floor){
		boolean check=false;
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(floor);
		boolean valid= nameMatcher.matches();
		if(floor.equalsIgnoreCase("marbles")||floor.equalsIgnoreCase("tiles")||floor.equalsIgnoreCase("granite")&&valid==true)
			check=true;
		return check;
	}
	public static boolean isValidAddNo(int addNo) 
	{
		return (addNo>0);
	}public static boolean isValidRent(int charges) 
	{
		return (charges>0);
	}

}