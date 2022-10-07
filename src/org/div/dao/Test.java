package org.div.dao;

import java.util.List;

import org.div.Customer;

public class Test {

	public static void main(String[] args) {
		
		CustomerDao dao=new CustomerJDBCimpl();
//		Customer customer= new Customer(3,"Prashant","Kanpur");
//		if(dao.insert(customer)) {
//			System.out.println("Successfully Inserted the Customer");
//		}
		List<Customer> customers=dao.getAll();
		customers.forEach(customer->System.out.println(customer.getCid()+"\t"+customer.getcName()+"\t"+customer.getLoc()));
	}

}
