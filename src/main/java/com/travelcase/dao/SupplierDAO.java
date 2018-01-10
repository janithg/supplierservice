package com.travelcase.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.travelcase.entity.Supplier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SupplierDAO implements ISupplierDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Supplier getSupplierById(int spplierId) {
		return entityManager.find(Supplier.class, spplierId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getAllSuppliers() {
		String hql = "FROM Supplier as sup ORDER BY sup.supplierId";
		return (List<Supplier>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addSupplier(Supplier supplier) {
		entityManager.persist(supplier);
	}
	@Override
	public void updateSupplier(Supplier supplier) {
		Supplier artcl = getSupplierById(supplier.getSupplierId());
		artcl.setCode(supplier.getCode());
		artcl.setName(supplier.getName());
		artcl.setCurrency(supplier.getCurrency());
		entityManager.flush();
	}
	@Override
	public void deleteSupplier(int supplierId) {
		entityManager.remove(getSupplierById(supplierId));
	}
	@Override
	public boolean supplierExists(String code, String name) {
		String hql = "FROM Supplier as sup WHERE sup.code = ? and sup.name = ?";
		int count = entityManager.createQuery(hql).setParameter(1, code)
		              .setParameter(2, name).getResultList().size();
		return count > 0 ? true : false;
	}
}
