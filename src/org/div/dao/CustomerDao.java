package org.div.dao;

import java.util.List;
import java.util.Optional;

import org.div.Customer;

public interface CustomerDao {
		boolean insert(Customer customers);
		List<Customer> getAll();
		Optional<Customer> get(int cid);
		boolean delete(int cid);
		
}
