package com.travelcase.service;

import java.util.List;

import com.travelcase.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelcase.dao.ISupplierDAO;

@Service
public class SupplierService implements ISupplierService {
	@Autowired
	private ISupplierDAO supplierDAO;
	@Override
	public Supplier getSupplierById(int supplierId) {
		Supplier obj = supplierDAO.getSupplierById(supplierId);
		return obj;
	}	
	@Override
	public List<Supplier> getSuppliers(){
		return supplierDAO.getAllSuppliers();
	}
	@Override
	public synchronized boolean addSupplier(Supplier supplier){
       if (supplierDAO.supplierExists(supplier.getCode(), supplier.getName())) {
    	   return false;
       } else {
    	   supplierDAO.addSupplier(supplier);
    	   return true;
       }
	}
	@Override
	public void updateSupplier(Supplier supplier) {
		supplierDAO.updateSupplier(supplier);
	}
	@Override
	public void deleteSupplier(int supplierId) {
		supplierDAO.deleteSupplier(supplierId);
	}
}
