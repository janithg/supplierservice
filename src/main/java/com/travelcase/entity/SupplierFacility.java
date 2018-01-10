package com.travelcase.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "supplier_facilities")
public class SupplierFacility implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "facility_id")
    private int facilityId;
    @Column(name = "supplier_id")
    private int supplierId;
    @Column(name = "facility_type")
    private String facilityType;
    @Column(name = "description")
    private String description;

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}