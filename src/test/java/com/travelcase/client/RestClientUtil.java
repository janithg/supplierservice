//package com.travelcase.client;
//
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.travelcase.entity.Supplier;
//import com.travelcase.entity.SupplierContacts;
//import com.travelcase.entity.SupplierContents;
//import com.travelcase.entity.SupplierFacility;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//public class RestClientUtil {
//    private HttpHeaders getHeaders() {
//    	String credential="admin:a123";
//    	//String credential="tarun:t123";
//    	String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//     	headers.add("Authorization", "Basic " + encodedCredential);
//    	return headers;
//    }
//
//    public void getSupplierById() {
//    	HttpHeaders headers = getHeaders();
//        RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/travel-supplier/supplier/{id}";
//        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
//        ResponseEntity<Supplier> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Supplier.class, 5);
//        Supplier supplier = responseEntity.getBody();
//        System.out.println("Id:"+ supplier.getSupplierId()+", Title:"+ supplier.getCode()
//                 +", Category:"+ supplier.getName());
//    }
//	public void getAllSupplier() {
//    	HttpHeaders headers = getHeaders();
//        RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/travel-supplier/suppliers";
//        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
//        ResponseEntity<Supplier[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Supplier[].class);
//        Supplier[] suppliers = responseEntity.getBody();
//        for(Supplier supplier : suppliers) {
//              System.out.println("Id:"+ supplier.getSupplierId()+", Code:"+ supplier.getCode()
//                      +", Name: "+ supplier.getName());
//        }
//    }
//    public void addSupplier() {
//    	HttpHeaders headers = getHeaders();
//        RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/travel-supplier/supplier";
//	    Supplier objSupplier = new Supplier();
//	    objSupplier.setCode("TestSUP01");
//	    objSupplier.setName("Test Supplier");
//	    objSupplier.setCity("city");
//	    objSupplier.setCountry("country");
//	    objSupplier.setStreet("street");
//	    objSupplier.setPostalCode("postal code");
//	    objSupplier.setStartRating("star");
//	    objSupplier.setCurrency("USD");
//	    objSupplier.setGeoCodex("geoX");
//	    objSupplier.setGeoCodey("geoY");
//	    objSupplier.setAmdSchema("Amd Scheme");
//	    objSupplier.setCanxSchema("Cnx Scheme");
//	    objSupplier.setDepositSchema("Deposit Scheme");
//
//        List<SupplierContents> supplierContents =new ArrayList<>();
//        SupplierContents supplierContent =new SupplierContents();
////        supplierContent.setContactId(1);
////        supplierContent.setSupplierId(6);
//        supplierContent.setProductName("name");
//        supplierContent.setProductDescription("description");
//        supplierContent.setProductImage("image");
//        supplierContent.setOtherImage("other image");
//        supplierContents.add(supplierContent);
//        objSupplier.setSupplierContents(supplierContents);
//
//        List<SupplierContacts> supplierContacts = new ArrayList<>();
//        SupplierContacts contacts = new SupplierContacts();
//        contacts.setContactCategory("Email");
//        contacts.setValue("test@test.com");
//        contacts.setMainContact(true);
//        supplierContacts.add(contacts);
//
//        objSupplier.setSupplierContacts(supplierContacts);
//
//	    List<SupplierFacility> supplierFacilities = new ArrayList<>();
//        SupplierFacility supplierFacility = new SupplierFacility();
//        supplierFacility.setFacilityType("Main Pool & Child Pool");
//        supplierFacility.setDescription("Open at 7AM Close at 6PM");
//        supplierFacilities.add(supplierFacility);
//
//        objSupplier.setSupplierFacilities(supplierFacilities);
//
//
//        HttpEntity<Supplier> requestEntity = new HttpEntity<Supplier>(objSupplier, headers);
//        URI uri = restTemplate.postForLocation(url, requestEntity);
//        System.out.println(uri.getPath());
//    }
//    public void updateSupplier() {
//    	HttpHeaders headers = getHeaders();
//        RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/travel-supplier/supplier";
//	    Supplier objSupplier = new Supplier();
//	    objSupplier.setSupplierId(5);
//        objSupplier.setCode("Spring code");
//        objSupplier.setName("Spring name");
//        objSupplier.setCurrency("GBP");
//        HttpEntity<Supplier> requestEntity = new HttpEntity<Supplier>(objSupplier, headers);
//        restTemplate.put(url, requestEntity);
//    }
//    public void deleteSupplier() {
//    	HttpHeaders headers = getHeaders();
//        RestTemplate restTemplate = new RestTemplate();
//	    String url = "http://localhost:8080/travel-supplier/supplier/{id}";
//        HttpEntity<Supplier> requestEntity = new HttpEntity<Supplier>(headers);
//        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 5);
//    }
//    public static void main(String args[]) {
//    	RestClientUtil util = new RestClientUtil();
//        util.getSupplierById();
//        util.getAllSupplier();
//    	util.addSupplier();
////    	util.updateSupplier();
////    	util.deleteSupplier();
//    }
//}
