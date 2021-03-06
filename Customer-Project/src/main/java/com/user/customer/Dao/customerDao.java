package com.user.customer.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.customer.Model.Customer;

public class customerDao {

	private String url = "jdbc:mysql://localhost:3306/customer?useSSL=false";
	private String username = "root";
	private String password = "";

	private static final String insert_cust = "insert into tblcustomer"
			+ "(name,addr1,addr2,street,country,zip,city,phone,fax,web,email,Notes)values"
			+ "(?,?,?,?,?,?,?,?,?,?,?,?);";

	private static final String select_cust_by_id = "select * from tblcustomer where id=?;";

	private static final String select_cust = "select * from tblcustomer";

	private static final String delete_cust = "delete from tblcustomer where id=?;";

	private static final String update_cust = "update tblcustomer set name=?,addr1=?,addr2=?,street=?,country=?,zip=?,city=?,phone=?,fax=?,web=?,email=?,notes=? where id=?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public customerDao() {

	}

	// insert customer
	public void insertCustomer(Customer customer) throws SQLException {
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(insert_cust)) {

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddr1());
			ps.setString(3, customer.getAddr2());
			ps.setString(4, customer.getStreet());
			ps.setString(5, customer.getCountry());
			ps.setInt(6, customer.getZip());
			ps.setString(7, customer.getCity());
			ps.setInt(8, customer.getPhone());
			ps.setInt(9, customer.getFax());
			ps.setString(10, customer.getWeb());
			ps.setString(11, customer.getEmail());
			ps.setString(12, customer.getNotes());

			ps.executeUpdate();

		} catch (SQLException e) {
			PrinSQLException(e);
		}

	}

	// update customer

	public boolean updateCustomer(Customer customer) throws SQLException {
		boolean rowupdated;
		try (Connection connection = getConnection(); PreparedStatement ps1 = connection.prepareStatement(update_cust)) {

			ps1.setString(1, customer.getName());
			ps1.setString(2, customer.getAddr1());
			ps1.setString(3, customer.getAddr2());
			ps1.setString(4, customer.getStreet());
			ps1.setString(5, customer.getCountry());
			ps1.setInt(6, customer.getZip());
			ps1.setString(7, customer.getCity());
			ps1.setInt(8, customer.getPhone());
			ps1.setInt(9, customer.getFax());
			ps1.setString(10, customer.getWeb());
			ps1.setString(11, customer.getEmail());
			ps1.setString(12, customer.getNotes());
			ps1.setInt(13, customer.getId());

			rowupdated = ps1.executeUpdate() > 0;

		}

		return rowupdated;

	}

	// delete customer

	public boolean delCustomer(int id) throws SQLException {
		boolean rowdeleted;
		try (Connection connection = getConnection();
				PreparedStatement ps3 = connection.prepareStatement(delete_cust)) {
			ps3.setInt(1, id);
			rowdeleted = ps3.executeUpdate() > 0;

		}
		return rowdeleted;

	}
	
	
	//Select customer By id
	
	public Customer selectCustomer(int id) throws SQLException
	{
		Customer  customer=null;
		try(Connection connection = getConnection();
				PreparedStatement ps4 = connection.prepareStatement(select_cust_by_id))
		{
			
			ps4.setInt(1,id);
			ResultSet rs=ps4.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("name");
				String addr1=rs.getString("addr1");
				String addr2=rs.getString("addr2");
				String street=rs.getString("street");
				String country=rs.getString("country");
				int zip=rs.getInt("zip");
				String city=rs.getString("city");
				int phone=rs.getInt("phone");
				int fax=rs.getInt("fax");
				String web=rs.getString("web");
				String email=rs.getString("email");
				String note=rs.getString("Notes");
				
				
				customer=new  Customer(id,name, addr1, addr2, street, country, zip, city, phone, fax, web, email, note);
				
			}
			
		}
		return customer;
	}
	
	
	public List<Customer> selectAllCustomer() throws SQLException
	{
		List<Customer> c1=new ArrayList<>();
		try(Connection connection = getConnection();
				PreparedStatement ps4 = connection.prepareStatement(select_cust))
		{
			
		
			ResultSet rs=ps4.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("name");
				String addr1=rs.getString("addr1");
				String addr2=rs.getString("addr2");
				String street=rs.getString("street");
				String country=rs.getString("country");
				int zip=rs.getInt("zip");
				String city=rs.getString("city");
				int phone=rs.getInt("phone");
				int fax=rs.getInt("fax");
				String web=rs.getString("web");
				String email=rs.getString("email");
				String note=rs.getString("Notes");
				int id=rs.getInt("id");
				
				
				c1.add(new  Customer(id,name, addr1, addr2, street, country, zip, city, phone, fax, web, email, note));
				
			}
			
		}
		return c1;
	}
	

	private void PrinSQLException(SQLException ex) {
		// TODO Auto-generated method stub
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState:" + ((SQLException) e).getSQLState());
				System.err.println("Error Code:" + ((SQLException) e).getErrorCode());
				System.err.println("Message:" + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause=" + t);
					t = t.getCause();
				}

			}
		}

	}

	

}
