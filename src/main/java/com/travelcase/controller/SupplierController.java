package com.travelcase.controller;
import java.util.List;

import com.travelcase.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.travelcase.service.ISupplierService;

@Controller
@RequestMapping("travel-supplier")
public class SupplierController {
	@Autowired
	private ISupplierService supplierService;
	
	
	@GetMapping("/")
	public ResponseEntity<String> getRoot( ) {		
		return new ResponseEntity<String>("Welcome to Supplier Service.... ! <br> Following API methods are available <br> 1. [GET] /suppliers  <br> 2. {GET] /supplier/{id} <br> 3. [POST} /supplier <br> 4. [PUT] /suppliers <br> 5. [DELETE] /supplier/{id}", HttpStatus.OK);
	}
	
	
	@GetMapping("supplier/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") Integer id) {
		Supplier supplier = supplierService.getSupplierById(id);
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}
	@GetMapping("suppliers")
	public ResponseEntity<List<Supplier>> getSuppliers() {
		List<Supplier> list = supplierService.getSuppliers();
		return new ResponseEntity<List<Supplier>>(list, HttpStatus.OK);
	}
	@PostMapping("supplier")
	public ResponseEntity<Void> addSupplier(@RequestBody Supplier supplier, UriComponentsBuilder builder) {
        boolean flag = supplierService.addSupplier(supplier);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/supplier/{id}").buildAndExpand(supplier.getSupplierId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("supplier")
	public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier) {
		supplierService.updateSupplier(supplier);
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}
	@DeleteMapping("supplier/{id}")
	public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Integer id) {
		supplierService.deleteSupplier(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 
