package com.travelcase.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "supplier_contacts")
public class SupplierContacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private int contactId;
    @Column(name = "supplier_id")
    private int supplierId;
    @Column(name = "contact_category")
    private String contactCategory;
    @Column(name = "value")
    private String value;
    @Column(name = "main_contact")
    private boolean mainContact;

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContactCategory() {
        return contactCategory;
    }

    public void setContactCategory(String contactCategory) {
        this.contactCategory = contactCategory;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isMainContact() {
        return mainContact;
    }

    public void setMainContact(boolean mainContact) {
        this.mainContact = mainContact;
    }
}