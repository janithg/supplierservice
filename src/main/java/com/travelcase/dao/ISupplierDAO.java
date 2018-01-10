package com.travelcase.dao;
import java.util.List;
import com.travelcase.entity.Supplier;

public interface ISupplierDAO {
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(int spplierId);
    void addSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(int supplierId);
    boolean supplierExists(String code, String name);
}
 