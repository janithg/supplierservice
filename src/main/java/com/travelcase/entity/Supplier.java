package com.travelcase.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supplier_id")
    private int supplierId;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "currency")
    private String currency;
    @Column(name = "star_rating")
    private String startRating;
    @Column(name = "geo_codeX ")
    private String geoCodex;
    @Column(name = "geo_codeY")
    private String geoCodey;
    @Column(name = "amendment_schema")
    private String amdSchema;
    @Column(name = "cancellation_chema")
    private String canxSchema;
    @Column(name = "deposit_schema")
    private String depositSchema;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private List<SupplierContents> supplierContents;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private List<SupplierContacts> supplierContacts;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private List<SupplierFacility> supplierFacilities;

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStartRating() {
        return startRating;
    }

    public void setStartRating(String startRating) {
        this.startRating = startRating;
    }

    public String getGeoCodex() {
        return geoCodex;
    }

    public void setGeoCodex(String geoCodex) {
        this.geoCodex = geoCodex;
    }

    public String getGeoCodey() {
        return geoCodey;
    }

    public void setGeoCodey(String geoCodey) {
        this.geoCodey = geoCodey;
    }

    public String getAmdSchema() {
        return amdSchema;
    }

    public void setAmdSchema(String amdSchema) {
        this.amdSchema = amdSchema;
    }

    public String getCanxSchema() {
        return canxSchema;
    }

    public void setCanxSchema(String canxSchema) {
        this.canxSchema = canxSchema;
    }

    public String getDepositSchema() {
        return depositSchema;
    }

    public void setDepositSchema(String depositSchema) {
        this.depositSchema = depositSchema;
    }

    public List<SupplierContents> getSupplierContents() {
        return supplierContents;
    }

    public void setSupplierContents(List<SupplierContents> supplierContents) {
        this.supplierContents = supplierContents;
    }

    public List<SupplierContacts> getSupplierContacts() {
        return supplierContacts;
    }

    public void setSupplierContacts(List<SupplierContacts> supplierContacts) {
        this.supplierContacts = supplierContacts;
    }

    public List<SupplierFacility> getSupplierFacilities() {
        return supplierFacilities;
    }

    public void setSupplierFacilities(List<SupplierFacility> supplierFacilities) {
        this.supplierFacilities = supplierFacilities;
    }
}