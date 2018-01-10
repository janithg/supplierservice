package com.travelcase.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.travelcase.entity.Supplier;

public interface ISupplierService {
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     List<Supplier> getSuppliers();
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     Supplier getSupplierById(int supplierId);
	 @Secured ({"ROLE_ADMIN"})
     boolean addSupplier(Supplier supplier);
	 @Secured ({"ROLE_ADMIN"})
     void updateSupplier(Supplier supplier);
	 @Secured ({"ROLE_ADMIN"})
     void deleteSupplier(int supplierId);
}
