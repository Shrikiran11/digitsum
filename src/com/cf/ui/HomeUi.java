package com.cf.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import mdoel.Car;
import repository.CarDaoImpl;
import repository.ICarDao;
import service.CarServiceImpl;
import service.ICarService;

public class HomeRentalUi {
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
						if (CarServiceImpl.isValidId(addrNo)) {
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
						if (CarServiceImpl.isValidName(loc)) {
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
						if (CarServiceImpl.isValidBrand(style)) {
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
						if (CarServiceImpl.isValidColour(paint)) {
							break;
						} else {
							System.err.println("Please give the valid Colour,Try Again..");
							System.out.println("Re-enter the colour");
							paint = scn.next();
						}
					}
					System.out.println("Enter rooms and models");
					String bhk = scn.next();
					bhk = bhk.toUpperCase();
					while (true) {
						if (CarServiceImpl.isValidModel(bhk)) {
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
						if (CarServiceImpl.isValidVariant(floor)) {
							break;
						} else {
							System.err.println("Please give the valid Variant,Try Again..");
							System.out.println("Re-enter the Variant");
							floor = scn.next();
						}
					}
					System.out.println("Enter the rent amount per month");
					int rent = scn.nextInt();
					while (true) {
						if (CarServiceImpl.isValidAmount(rent)) {
							break;
						} else {
							System.err.println("Please give the valid Amount,Try Again..");
							System.out.println("Re-enter Amount");
							rent = scn.nextInt();
						}
					}
					Home h = new Home(addrNo, loc, style, paint, bhk, floor, rent);
					ICarService serv = new CarServiceImpl();
					try {
						serv.addCar(car);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Enter car id which you want to delete");
					int id1 = scn.nextInt();
					Car car1 = new Car(id1);
					ICarService serv1 = new CarServiceImpl();
					serv1.deleteCar(id1);
					break;
				case 3:
					System.out.println("Enter id of the car which you want to update");
					int id2 = scn.nextInt();

					System.out.println();
					System.out.println("Enter a option which you want to Update");
					System.out.println();
					System.out.println(" 1. Car Id \n 2.Car Name \n 3.Car Brand"
							+ "\n 4. Car Colour \n 5. Car Model \n 6. Car Variant\n 7. Car Charges per day\n 8.Update all details\n 9.exit");
					System.out.println();
					int option1 = scn.nextInt();
					switch (option1) {

					case 1:

						System.out.println("Enter id of the Car");
						int id3 = scn.nextInt();
						Car car4 = new Car(id2, id3);
						ICarService serv2 = new CarServiceImpl();
						serv2.UpdateId(car4);
						break;
					case 2:
						System.out.println("Enter name of the Car");
						String name2 = scn.next();
						name2 = name2.toUpperCase();
						Car car5 = new Car(id2, name2);
						ICarService serv3 = new CarServiceImpl();
						serv3.UpdateName(car5);
						break;
					case 3:
						System.out.println("Enter brand");
						String brand2 = scn.next();
						brand2 = brand2.toUpperCase();
						Car car6 = new Car(id2, brand2);
						ICarService serv4 = new CarServiceImpl();
						serv4.UpdateBrand(car6);
						break;
					case 4:

						System.out.println("Enter colour");
						String colour2 = scn.next();
						colour2 = colour2.toUpperCase();
						Car car7 = new Car(id2, colour2);
						ICarService serv5 = new CarServiceImpl();
						serv5.UpdateColour(car7);
						break;
					case 5:
						System.out.println("Enter model");
						String model2 = scn.next();
						model2 = model2.toUpperCase();
						Car car8 = new Car(id2, model2);
						ICarService serv6 = new CarServiceImpl();
						serv6.UpdateModel(car8);
						break;
					case 6:
						System.out.println("Enter variant");
						String variant2 = scn.next();
						variant2 = variant2.toUpperCase();
						Car car9 = new Car(id2, variant2);
						ICarService serv7 = new CarServiceImpl();
						serv7.UpdateVariant(car9);
						break;
					case 7:
						System.out.println("Enter the charges amount per day");
						int charges2 = scn.nextInt();
						Car car10 = new Car(id2, charges2);
						ICarService serv8 = new CarServiceImpl();
						serv8.UpdateCharges(car10);
						break;
					case 8:
						System.out.println("Enter name of the Car");
						String name3 = scn.next();
						System.out.println("Enter brand");
						String brand3 = scn.next();
						System.out.println("Enter colour");
						String colour3 = scn.next();
						System.out.println("Enter model");
						String model3 = scn.next();
						System.out.println("Enter variant");
						String variant3 = scn.next();
						System.out.println("Enter the charges amount per day");
						int charges3 = scn.nextInt();
						Car car2 = new Car(id2, name3, brand3, colour3, model3, variant3, charges3);
						ICarService serv11 = new CarServiceImpl();
						try {
							serv11.updateCar(car2);
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
					ICarDao dao1 = new CarDaoImpl();
					try {

						List<Car> carList1 = new ArrayList<Car>();
						carList1 = dao1.getByName(name1);

						if (carList1 != null) {
							System.out.println();
							System.out.println("ID\t\tNAME\t\tBRAND\t\tCOLOUR\t\tMODEL\t\tVARIANT\t\tCHARGES PER DAY");
							System.out.println(
									"*****************************************************************************************************************");

							Iterator<Car> itr1 = carList1.iterator();
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
					System.out.println("Enter id of the Car which you want to display");
					int id3 = scn.nextInt();
					ICarDao dao2 = new CarDaoImpl();
					try {

						List<Car> carList2 = new ArrayList<Car>();
						carList2 = dao2.getById(id3);

						if (carList2 != null) {
							System.out.println();
							System.out.println("ID\t\tNAME\t\tBRAND\t\tCOLOUR\t\tMODEL\t\tVARIANT\t\tCHARGES PER DAY");
							System.out.println(
									"*****************************************************************************************************************");

							Iterator<Car> itr2 = carList2.iterator();
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
					System.out.println("ID\t\tNAME\t\tBRAND\t\tCOLOUR\t\tMODEL\t\tVARIANT\t\tCHARGES PER DAY");
					System.out.println(
							"*****************************************************************************************************************");
					ICarDao dao = new CarDaoImpl();
					try {
						List<Car> carList = new ArrayList<Car>();
						carList = dao.displayAll();
						if (carList != null) {
							Iterator<Car> itr = carList.iterator();
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
				System.out.println(" 1. Get all Car list\n 2. Get Car by name \n 3. Get Car by id  \n 4. Exit");
				System.out.println();
				int option = scn.nextInt();
				switch (option) {
				case 1:
					System.out.println("Display all the Car Details");
					System.out.println();
					System.out.println("ID\t\tNAME\t\tBRAND\t\tCOLOUR\t\tMODEL\t\tVARIANT\t\tCHARGES PER DAY");
					System.out.println(
							"*****************************************************************************************************************");
					ICarDao dao = new CarDaoImpl();
					try {
						List<Car> carList = new ArrayList<Car>();
						carList = dao.displayAll();
						if (carList != null) {
							Iterator<Car> itr = carList.iterator();
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
					ICarDao dao1 = new CarDaoImpl();
					try {

						List<Car> carList1 = new ArrayList<Car>();
						carList1 = dao1.getByName(name1);

						if (carList1 != null) {
							System.out.println();
							System.out.println("ID\t\tNAME\t\tBRAND\t\tCOLOUR\t\tMODEL\t\tVARIANT\t\tCHARGES PER DAY");
							System.out.println(
									"*****************************************************************************************************************");

							Iterator<Car> itr1 = carList1.iterator();
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
					System.out.println("Enter id of the Car which you want to display");
					int id3 = scn.nextInt();
					ICarDao dao2 = new CarDaoImpl();
					try {

						List<Car> carList2 = new ArrayList<Car>();
						carList2 = dao2.getById(id3);

						if (carList2 != null) {
							System.out.println();
							System.out.println("ID\t\tNAME\t\tBRAND\t\tCOLOUR\t\tMODEL\t\tVARIANT\t\tCHARGES PER DAY");
							System.out.println(
									"*****************************************************************************************************************");

							Iterator<Car> itr2 = carList2.iterator();
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