package org.div.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.div.Customer;
import org.div.util.DbContants;
import org.div.util.DbHelper;

public class CustomerJDBCimpl implements CustomerDao{

	@Override
	public boolean insert(Customer customers) {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement pst=null;
		boolean isInserted=false;
		try {
			con= DbHelper.establishConnection(DbContants.URL, DbContants.USERNAME, DbContants.PASSWORD);
			if(con!=null) {
				{
					pst = con.prepareStatement("insert into customers values(?,?,?)");
					pst.setInt(1, customers.getCid());
					pst.setString(2, customers.getcName());
					pst.setString(3, customers.getLoc());
					int i= pst.executeUpdate();
					if(i>0)
						isInserted=true; 
					con.close();
				
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isInserted;
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> customers = new ArrayList<>();
		try(Connection con= DbHelper.establishConnection(DbContants.URL, DbContants.USERNAME, DbContants.PASSWORD);Statement st= con.createStatement();ResultSet rs= st.executeQuery("select * from customers");)
		{
				
			while(rs.next()) {
				customers.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Optional<Customer> get(int cid) {
		Customer customer=null;
	
		try(Connection con= DbHelper.establishConnection(DbContants.URL, DbContants.USERNAME, DbContants.PASSWORD);PreparedStatement pst= con.prepareStatement("select * from customers where cid=?");)
		{
				pst.setInt(1, cid);
				ResultSet rs=pst.executeQuery();
				rs.next();
				customer = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3));	
				
	}
		catch (Exception e) {
			e.printStackTrace();
		}
			return Optional.ofNullable(customer);
	}
	
	@Override
	public boolean delete(int cid) {
		boolean isdeleted= false;
		try (Connection con= DbHelper.establishConnection(DbContants.URL, DbContants.USERNAME, DbContants.PASSWORD);PreparedStatement pst= con.prepareStatement("delete from customers where cid=?");)
		{
			int i= pst.executeUpdate();
			if(i>0) {
				isdeleted=true;
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return isdeleted;
	}

	
}
