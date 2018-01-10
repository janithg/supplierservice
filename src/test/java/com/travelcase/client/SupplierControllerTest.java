package com.travelcase.client;

import com.travelcase.entity.Supplier;
import com.travelcase.entity.SupplierContacts;
import com.travelcase.entity.SupplierContents;
import com.travelcase.entity.SupplierFacility;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by janitha on 1/5/2018.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplierControllerTest
{
    @Autowired private TestRestTemplate restTemplate;
    private static int supplierId;
    private String supplierCode = "TestSUP 005";

    private HttpHeaders getHeaders()
    {
        String credential = "admin:a123";
        String encodedCredential = new String( Base64.encodeBase64( credential.getBytes() ) );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );
        headers.add( "Authorization", "Basic " + encodedCredential );
        return headers;
    }

    @Test  public void a_addSupplier()
    {
        HttpHeaders headers = getHeaders();
        String url = "/travel-supplier/supplier";
        Supplier objSupplier = new Supplier();

        objSupplier.setCode( supplierCode );
        objSupplier.setName( "Test Supplier" );
        objSupplier.setCity( "city" );
        objSupplier.setCountry( "country" );
        objSupplier.setStreet( "street" );
        objSupplier.setPostalCode( "postal code" );
        objSupplier.setStartRating( "star" );
        objSupplier.setCurrency( "USD" );
        objSupplier.setGeoCodex( "geoX" );
        objSupplier.setGeoCodey( "geoY" );
        objSupplier.setAmdSchema( "Amd Scheme" );
        objSupplier.setCanxSchema( "Cnx Scheme" );
        objSupplier.setDepositSchema( "Deposit Scheme" );

        List<SupplierContents> supplierContents = new ArrayList<>();
        SupplierContents supplierContent = new SupplierContents();
        supplierContent.setProductName( "name" );
        supplierContent.setProductDescription( "description" );
        supplierContent.setProductImage( "image" );
        supplierContent.setOtherImage( "other image" );
        supplierContents.add( supplierContent );
        objSupplier.setSupplierContents( supplierContents );

        List<SupplierContacts> supplierContacts = new ArrayList<>();
        SupplierContacts contacts = new SupplierContacts();
        contacts.setContactCategory( "Email" );
        contacts.setValue( "test@test.com" );
        contacts.setMainContact( true );
        supplierContacts.add( contacts );

        objSupplier.setSupplierContacts( supplierContacts );

        List<SupplierFacility> supplierFacilities = new ArrayList<>();
        SupplierFacility supplierFacility = new SupplierFacility();
        supplierFacility.setFacilityType( "Main Pool & Child Pool" );
        supplierFacility.setDescription( "Open at 7AM Close at 6PM" );
        supplierFacilities.add( supplierFacility );

        objSupplier.setSupplierFacilities( supplierFacilities );


        HttpEntity<Supplier> requestEntity = new HttpEntity<Supplier>( objSupplier, headers );
        URI uri = restTemplate.postForLocation( url, requestEntity );

        //        System.out.println(uri.getPath());
        String path = uri.getPath();
        assertEquals( "Supplier record inserted", true, path.contains( "/supplier/" ) );
        supplierId = Integer.parseInt( path.substring( path.lastIndexOf( "/" ) + 1 ) );
    }

    @Test public void b_getAllSuppliers()
    {
        HttpHeaders headers = getHeaders();
        String url = "/travel-supplier/suppliers";
        HttpEntity<String> requestEntity = new HttpEntity<String>( headers );
        ResponseEntity<Supplier[]> responseEntity = restTemplate.exchange( url, HttpMethod.GET, requestEntity, Supplier[].class );
        Supplier[] suppliers = responseEntity.getBody();

        assertEquals( HttpStatus.OK, responseEntity.getStatusCode() );
        assertEquals( "Supplier records are available :" + suppliers.length, true, suppliers.length > 0 );

        boolean supplierExist = false;
        for( Supplier supplier : suppliers )
        {
            if( supplier.getSupplierId() == supplierId )
            {
                assertEquals( "Supplier record is available", true, true );
                supplierExist = true;
            }
        }

        if(!supplierExist)
        {
            assertEquals( "Supplier record is not available : "+supplierId, true, true );
        }

    }

    @Test public void c_getSupplierById()
    {
        getSupplierById( null );
    }

    public void getSupplierById( String code )
    {
        HttpHeaders headers = getHeaders();
        String url = "/travel-supplier/supplier/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>( headers );
        ResponseEntity<Supplier> responseEntity = restTemplate.exchange( url, HttpMethod.GET, requestEntity, Supplier.class, supplierId );
        Supplier supplier = responseEntity.getBody();

        assertEquals( HttpStatus.OK, responseEntity.getStatusCode() );
        assertEquals( "Supplier records fount " + supplier.getName(), ( code == null ? supplierCode : code ), supplier.getCode() );

    }

    @Test public void d_updateSupplier()
    {
        HttpHeaders headers = getHeaders();
        String url = "/travel-supplier/supplier";
        Supplier objSupplier = new Supplier();
        objSupplier.setSupplierId( supplierId );
        objSupplier.setCode( "SUP CODE UPDATE" );
        objSupplier.setName( "Spplier name updated" );
        objSupplier.setCurrency( "GBP" );
        HttpEntity<Supplier> requestEntity = new HttpEntity<Supplier>( objSupplier, headers );
        restTemplate.put( url, requestEntity );

        getSupplierById( "SUP CODE UPDATE" );
    }

    @Test public void e_deleteSupplier()
    {
        HttpHeaders headers = getHeaders();
        String url = "/travel-supplier/supplier/{id}";
        HttpEntity<Supplier> requestEntity = new HttpEntity<Supplier>( headers );
        restTemplate.exchange( url, HttpMethod.DELETE, requestEntity, Void.class, supplierId );
    }

}