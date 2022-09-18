package com.cf.dao;
import com.cf.model.Home;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cf.repository.Connection;
import com.cf.repository.Home;
import com.cf.repository.IHomeDao;
import com.cf.repository.PreparedStatement;
import com.cf.repository.ResultSet;
import com.cf.repository.SQLException;

public class HomeDaoImpl implements IHomeDao {
	private static final String STR = "insert into home values(?,?,?,?,?,?,?)";
	private static final String DELETE_HOME_SQL = "delete from home where addNo=(?)";
	private static final String GET_ALL_DETAILS_HOME_SQL = "select * from home ";
	private static final String GET_DETAILS_BY_LOCATION_USERS_SQL = "select * from home where loc= (?)";
	private static final String GET_DETAILS_BY_ADDNO_USERS_SQL = "select * from home where addNo= (?)";
	private static final String UPDATE_DETAILS = "update home set loc=(?),style=(?),paint=(?),bhk=(?),floor=(?),rent=(?) where addNo=(?)";
	private static final String UPDATE_LOC = "update home set loc=(?) where addNo=(?)";
	private static final String UPDATE_ADDNO = "update home set addNo=(?) where addNo=(?)";
	private static final String UPDATE_STYLE = "update home set style=(?) where addNo=(?)";
	private static final String UPDATE_PAINT = "update home set paint=(?) where addNo=(?)";
	private static final String UPDATE_BHK = "update home set bhk=(?) where addNo=(?)";
	private static final String UPDATE_FLOOR = "update car set floor=(?) where addNo=(?)";
	private static final String UPDATE_RENT = "update car set rent=(?) where addNo=(?)";
	@Override
	public Home addHome(Home home) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		PreparedStatement prep = connection.prepareStatement(STR);

		int addrNo = home.getAddNo();
		String loc = home.getLoc();
		String style = home.getStyle();
		String paint = home.getPaint();
		String bhk = home.getBhk();
		String floor = home.getFloor();
		int rent = home.getRent();

		prep.setInt(1, addrNo);
		prep.setString(2, loc);
		prep.setString(3, style);
		prep.setString(4, paint);
		prep.setString(5, bhk);
		prep.setString(6, floor);
		prep.setInt(7, rent);

		prep.addBatch();

		int[] updateCounts = prep.executeBatch();
		System.out.println(Arrays.toString(updateCounts) + "ADDED");
		return null;
	}

	@Override
	public Home deleteHome(int tid) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_HOME_SQL)) {
			preparedStatement.setInt(1, tid);

			System.out.println("DELETED ");
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// print SQL exception information
			System.err.println("SQLState: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("Message: " + e.getMessage());
		}
		return null;
	}

	@Override
	public Home updateHome(Home home) throws SQLException {

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger"); 
				PreparedStatement ps = connection.prepareStatement(UPDATE_DETAILS)) {
			int addrNo = home.getAddNo();
			String loc = home.getLoc();
			String style = home.getStyle();
			String paint = home.getPaint();
			String bhk = home.getBhk();
			String floor = home.getFloor();
			int rent = home.getRent();

			ps.setString(1, loc);
			ps.setString(2, style);
			ps.setString(3, paint);
			ps.setString(4, bhk);
			ps.setString(5, floor);
			ps.setInt(6, rent);
			ps.setInt(7, addrNo);

			int result = ps.executeUpdate();
			System.out.println("Number Of Record Updated" + result);
		} catch (SQLException e) {
			System.err.println("SQLState: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("Message: " + e.getMessage());
		}

		return null;
	}

	@Override
	public List<Home> getByLoc(String loc) {

		int count = 0;
		List<Home> List1 = new ArrayList<Home>();
		ResultSet resultset1 = null;
		try (

				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"tiger");
				PreparedStatement ps = connection.prepareStatement(GET_DETAILS_BY_LOCATION_USERS_SQL)) {

			ps.setString(1, loc);
			resultset1 = ps.executeQuery();

			while (resultset1.next()) {
				Home home = new Home();
				home.setAddNo(resultset1.getInt(1));
				home.setLoc(resultset1.getString(2));
				home.setStyle(resultset1.getString(3));
				home.setPaint(resultset1.getString(4));
				home.setBhk(resultset1.getString(5));
				home.setFloor(resultset1.getString(6));
				home.setRent(resultset1.getInt(7));
				List1.add(home);

				count++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (count == 0) {
			return null;
		} else {
			return List1;
		}
	}

	@Override
	public List<Home> getByAddNo(int addNo) {
		int count = 0;
		List<Home> List2 = new ArrayList<Home>();
		ResultSet resultset2 = null;
		try (

				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"tiger");
				PreparedStatement ps = connection.prepareStatement(GET_DETAILS_BY_ADDNO_USERS_SQL)) {

			ps.setInt(1, addNo);
			resultset2 = ps.executeQuery();

			while (resultset2.next()) {
				
				Home home = new Home();
				home.setAddNo(resultset2.getInt(1));
				home.setLoc(resultset2.getString(2));
				home.setStyle(resultset2.getString(3));
				home.setPaint(resultset2.getString(4));
				home.setBhk(resultset2.getString(5));
				home.setFloor(resultset2.getString(6));
				home.setRent(resultset2.getInt(7));
				List2.add(home);

				count++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (count == 0) {
			return null;
		} else {
			return List2;
		}
	}

	@Override
	public List<Home> displayAll() throws SQLException {

		int count = 0;
		ResultSet resultset = null;

		List<Home> List = new ArrayList<Home>();
		try (

				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"tiger");
				PreparedStatement ps = connection.prepareStatement(GET_ALL_DETAILS_HOME_SQL)) {
			resultset = ps.executeQuery();

			while (resultset.next()) {
				Home home = new Home();
				home.setAddNo(resultset.getInt(1));
				home.setLoc(resultset.getString(2));
				home.setStyle(resultset.getString(3));
				home.setPaint(resultset.getString(4));
				home.setBhk(resultset.getString(5));
				home.setFloor(resultset.getString(6));
				home.setRent(resultset.getInt(7));
				List.add(home);

				count++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (count == 0) {
			return null;
		} else {
			return List;
		}

	}

	@Override
	public Home UpdateAddNo(Home home) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger");
				PreparedStatement ps = connection.prepareStatement(UPDATE_ADDNO)) {
			int addNo = home.getAddNo();
			int addNo2 = home.getNumbers();
			ps.setInt(1,addNo2);
			ps.setInt(2,addNo);
			int result = ps.executeUpdate();
			System.out.println("Door Number Updated");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home UpdateLoc(Home home) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger");
				PreparedStatement ps = connection.prepareStatement(UPDATE_LOC)) {
			int addNo = home.getNumbers();
			String loc = home.getWords();

			ps.setString(1,loc);
			ps.setInt(2,addNo);
			int result = ps.executeUpdate();
			System.out.println("Location Updated");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home UpdateStyle(Home home) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger");
				PreparedStatement ps = connection.prepareStatement(UPDATE_STYLE)) {
			int addNo = home.getAddNo();
			String style = home.getWords();

			ps.setString(1,style);
			ps.setInt(2,addNo);
			int result = ps.executeUpdate();
			System.out.println("Brand Updated");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home UpdatePaint(Home home) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger");
				PreparedStatement ps = connection.prepareStatement(UPDATE_PAINT)) {
			int addNo = home.getAddNo();
			String paint =home.getWords();

			ps.setString(1,paint);
			ps.setInt(2,addNo);
			int result = ps.executeUpdate();
			System.out.println("Colour Updated");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home UpdateBhk(Home home) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger");
				PreparedStatement ps = connection.prepareStatement(UPDATE_BHK)) {
			int addNo = home.getAddNo();
			String bhk = home.getWords();

			ps.setString(1,bhk);
			ps.setInt(2,addNo);
			int result = ps.executeUpdate();
			System.out.println("Model Updated");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home UpdateFloor(Home home) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger");
				PreparedStatement ps = connection.prepareStatement(UPDATE_FLOOR)) {
			int addNo = home.getAddNo();
			String floor = home.getWords();

			ps.setString(1,floor);
			ps.setInt(2,addNo);
			int result = ps.executeUpdate();
			System.out.println("flooring Changed");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home UpdateRent(Home home) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"tiger");
				PreparedStatement ps = connection.prepareStatement(UPDATE_RENT)) {
			int addNo = home.getAddNo();
			int rent = home.getNumbers();
			ps.setInt(1,rent);
			ps.setInt(2,addNo);
			int result = ps.executeUpdate();
			System.out.println("Charges Updated");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
}