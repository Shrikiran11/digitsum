package com.cf.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cf.model.Home;
import com.cf.repository.HomeDaoImpl;
import com.cf.repository.IHomeDao;
import com.cf.service.HomeServiceImpl;
import com.cf.service.IHomeService;

public class HomeUi {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("************HOME RENTAL MANAGEMENT ************");
		System.out.println();
		System.out.println("Login Using Valid Username & Password");
		System.out.println();
		System.out.println("Enter Username");
		String uname = scn.next();
		System.out.println("Enter Password");
		String pass = scn.next();
		if (uname.equalsIgnoreCase("Admin") && pass.equals("admin")) {
			System.out.println("Login Admin Succesfull");
			while (true) {
				System.out.println();
				System.out.println(" 1. Add home \n 2.Delete home \n 3. Update home"
						+ "\n 4. Get home by location \n 5. Get home by sqft \n 6. Get all home available \n 7. Exit");
				System.out.println();
				int option = scn.nextInt();
				switch (option) {
				case 1:

					System.out.println("Enter home no ");
					int addrNo = scn.nextInt();
					while (true) {
						if (HomeServiceImpl.isValidAddNo(addrNo)) {
							break;
						} else {
							System.err.println("Please give the valid ID,Try Again..");
							System.out.println("Re-enter the no");
							addrNo = scn.nextInt();
						}
					}
					System.out.println("Enter location of the home");
					String loc = scn.next();
					loc = loc.toUpperCase();
					while (true) {
						if (HomeServiceImpl.isValidLocation(loc)) {
							break;
						} else {
							System.err.println("Please give the valid location,Try Again..");
							System.out.println("Re-enter the location");
							loc = scn.next();
						}
					}
					System.out.println("Enter style");
					String style = scn.next();
					style = style.toUpperCase();
					while (true) {
						if (HomeServiceImpl.isValidStyle(style)) {
							break;
						} else {
							System.err.println("Please give the valid Brand,Try Again..");
							style = scn.next();
						}
					}
					System.out.println("Enter painting");
					String paint = scn.next();
					paint = paint.toUpperCase();
					while (true) {
						if (HomeServiceImpl.isValidPaint(paint)) {
							break;
						} else {
							System.err.println("Please give the valid paint,Try Again..");
							System.out.println("Re-enter the Paint");
							paint = scn.next();
						}
					}
					System.out.println("Enter style");
					String bhk = scn.next();
					bhk = bhk.toUpperCase();
					while (true) {
						if (HomeServiceImpl.isValidBhk(bhk)) {
							break;
						} else {
							System.err.println("Please give the valid Model,Try Again..");
							System.out.println("Re-enter the rooms styles");
							bhk = scn.next();
						}
					}
					System.out.println("Enter flooring");
					String floor = scn.next();
					floor = floor.toUpperCase();
					while (true) {
						if (HomeServiceImpl.isValidFloor(floor)) {
							break;
						} else {
							System.err.println("Please give the valid Variant,Try Again..");
							System.out.println("Re-enter the floor");
							floor = scn.next();
						}
					}
					System.out.println("Enter the Price of Property");
					int rent = scn.nextInt();
					while (true) {
						if (HomeServiceImpl.isValidRent(rent)) {
							break;
						} else {
							System.err.println("Please give the valid Amount,Try Again..");
							System.out.println("Re-enter Amount");
							rent = scn.nextInt();
						}
					}
					Home home = new Home(addrNo, loc, style, paint, bhk, floor, rent);
					IHomeService serv = new HomeServiceImpl();
					try {
						serv.addHome(home);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Enter home doorNo which you want to delete");
					int id1 = scn.nextInt();
					Home home1 = new Home(id1);
					IHomeService serv1 = new HomeServiceImpl();
					serv1.deleteHome(id1);
					break;
				case 3:
					System.out.println("Enter doorNo of the home which you want to update");
					int id2 = scn.nextInt();

					System.out.println();
					System.out.println("Enter a option which you want to Update");
					System.out.println();
					System.out.println(" 1. Home doorNo \n 2.Home Location \n 3.Home Style"
							+ "\n 4. Home Paint \n 5. Home Bhk \n 6. Home Floor\n 7. Price listed for the property\n 8.Update all details\n 9.exit");
					System.out.println();
					int option1 = scn.nextInt();
					switch (option1) {

					case 1:

						System.out.println("Enter door no of the Home");
						int addNo3 = scn.nextInt();
						Home home4 = new Home(id2, addNo3);
						IHomeService serv2 = new HomeServiceImpl();
						serv2.UpdateAddNo(home4);
						break;
					case 2:
						System.out.println("Enter location of the Car");
						String loc2 = scn.next();
						loc2 = loc2.toUpperCase();
						Home home5 = new Home(id2, loc2);
						IHomeService serv3 = new HomeServiceImpl();
						serv3.UpdateLoc(home5);
						break;
					case 3:
						System.out.println("Enter style");
						String style2 = scn.next();
						style2 = style2.toUpperCase();
						Home home6 = new Home(id2, style2);
						IHomeService serv4 = new HomeServiceImpl();
						serv4.UpdateStyle(home6);
						break;
					case 4:

						System.out.println("Enter paint");
						String paint2 = scn.next();
						paint2 = paint2.toUpperCase();
						Home home7 = new Home(id2, paint2);
						IHomeService serv5 = new HomeServiceImpl();
						serv5.UpdatePaint(home7);
						break;
					case 5:
						System.out.println("Enter Bhk");
						String bhk2 = scn.next();
						bhk2 = bhk2.toUpperCase();
						Home home8 = new Home(id2, bhk2);
						IHomeService serv6 = new HomeServiceImpl();
						serv6.UpdateBhk(home8);
						break;
					case 6:
						System.out.println("Enter flooring");
						String floor2 = scn.next();
						floor2 = floor2.toUpperCase();
						Home home9 = new Home(id2, floor2);
						IHomeService serv7 = new HomeServiceImpl();
						serv7.UpdateFloor(home9);
						break;
					case 7:
						System.out.println("Enter the price");
						int rent2 = scn.nextInt();
						Home home10 = new Home(id2, rent2);
						IHomeService serv8 = new HomeServiceImpl();
						serv8.UpdateRent(home10);
						break;
					case 8:
						System.out.println("Enter location of the home");
						String loc3 = scn.next();
						System.out.println("Enter style");
						String style3 = scn.next();
						System.out.println("Enter paint");
						String paint3 = scn.next();
						System.out.println("Enter bhk");
						String bhk3 = scn.next();
						System.out.println("Enter floor");
						String floor3 = scn.next();
						System.out.println("Enter the Price");
						int rent3 = scn.nextInt();
						Home home2 = new Home(id2, loc3, style3, paint3, bhk3, floor3, rent3);
						IHomeService serv11 = new HomeServiceImpl();
						try {
							serv11.updateCar(home2);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					break;

				case 4:
					System.out.println("Enter the name of the car");
					String name1 = scn.next();
					name1 = name1.toUpperCase();
					IHomeDao dao1 = new HomeDaoImpl();
					try {

						List<Home> carList1 = new ArrayList<Home>();
						carList1 = dao1.getByName(name1);

						if (carList1 != null) {
							System.out.println();
							System.out.println("DoorNo\\t\\tLOCATION\\t\\tSTYLE\\t\\tPAINT\\t\\tBHK\\t\\tFLOOR\\t\\tPRICE");
							System.out.println(
									"*****************************************************************************************************************");

							Iterator<Home> itr1 = carList1.iterator();
							while (itr1.hasNext()) {
								System.out.println(itr1.next());
								System.out.println();
							}
						} else {
							System.err.println("No records Found...");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("Enter addNo of the Home which you want to display");
					int id3 = scn.nextInt();
					IHomeDao dao2 = new HomeDaoImpl();
					try {

						List<Home> carList2 = new ArrayList<Home>();
						carList2 = dao2.getById(id3);

						if (carList2 != null) {
							System.out.println();
							System.out.println("DoorNo\t\tLOCATION\t\tSTYLE\t\tPAINT\t\tBHK\t\tFLOOR\t\tPRICE");
							System.out.println(
									"*****************************************************************************************************************");

							Iterator<Home> itr2 = carList2.iterator();
							while (itr2.hasNext()) {
								System.out.println(itr2.next());
								System.out.println();
							}
						} else {
							System.err.println("No records Found...");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					System.out.println("Display all the Car Details");
					System.out.println();
					System.out.println("DoorNo\\t\\tLOCATION\\t\\tSTYLE\\t\\tPAINT\\t\\tBHK\\t\\tFLOOR\\t\\tPRICE");
					System.out.println(
							"*****************************************************************************************************************");
					IHomeDao dao = new HomeDaoImpl();
					try {
						List<Home> homeList = new ArrayList<Home>();
						homeList = dao.displayAll();
						if (homeList != null) {
							Iterator<Home> itr = homeList.iterator();
							while (itr.hasNext()) {
								System.out.println(itr.next());
								System.out.println();
							}
						} else {
							System.out.println("No records Found...");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 7:
					System.out.println("APPLICATION CLOSED");
					System.exit(1);
				default:
					System.out.println("Invalid Option");
					System.exit(1);

				}
				System.out.println();
			}

		} else if (uname.equalsIgnoreCase("User") && pass.equals("user")) {
			System.out.println("User Login Successfull");

			while (true) {
				System.out.println();
				System.out.println(" 1. Get all Property list\n 2. Get Home by Location \n 3. Get Home by DoorNo  \n 4. Exit");
				System.out.println();
				int option = scn.nextInt();
				switch (option) {
				case 1:
					System.out.println("Display all the Car Details");
					System.out.println();
					System.out.println("DoorNo\t\tOCATION\t\tSTYLE\t\tPAINT\t\tBHK\t\tFLOOR\t\tPRICE");
					System.out.println(
							"*****************************************************************************************************************");
					IHomeDao dao = new HomeDaoImpl();
					try {
						List<Home> carList = new ArrayList<Home>();
						carList = dao.displayAll();
						if (carList != null) {
							Iterator<Home> itr = carList.iterator();
							while (itr.hasNext()) {
								System.out.println(itr.next());
								System.out.println();
							}
						} else {
							System.out.println("No records Found...");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Enter the name of the car");
					String name1 = scn.next();
					name1 = name1.toUpperCase();
					IHomeDao dao1 = new HomeDaoImpl();
					try {

						List<Home> homeList1 = new ArrayList<Home>();
						homeList1 = dao1.getByLoc(name1);

						if (homeList1 != null) {
							System.out.println();
							System.out.println("DoorNo\\t\\tOCATION\\t\\tSTYLE\\t\\tPAINT\\t\\tBHK\\t\\tFLOOR\\t\\tPRICE");
							System.out.println(
									"*****************************************************************************************************************");

							Iterator<Home> itr1 = homeList1.iterator();
							while (itr1.hasNext()) {
								System.out.println(itr1.next());
								System.out.println();
							}
						} else {
							System.err.println("No records Found...");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter doorNo of the Home which you want to See");
					int id3 = scn.nextInt();
					IHomeDao dao2 = new HomeDaoImpl();
					try {

						List<Home> homeList2 = new ArrayList<Home>();
						homeList2 = dao2.getByAddNo(id3);

						if (homeList2 != null) {
							System.out.println();
							System.out.println("DoorNo\\t\\tOCATION\\t\\tSTYLE\\t\\tPAINT\\t\\tBHK\\t\\tFLOOR\\t\\tPRICE");
							System.out.println(
									"*****************************************************************************************************************");

							Iterator<Home> itr2 = homeList2.iterator();
							while (itr2.hasNext()) {
								System.out.println(itr2.next());
								System.out.println();
							}
						} else {
							System.err.println("No records Found...");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("APPLICATION CLOSED");
					System.exit(1);
					break;
				default:
					System.out.println("Invalid Option");
					System.exit(1);

				}
			}
		} else {
			System.err.println("Invalid Username or Password,Try Again..");
		}
	}
}