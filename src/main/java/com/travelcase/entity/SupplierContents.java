package com.travelcase.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "supplier_contents")
public class SupplierContents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "content_id")
    private int contentId;
    @Column(name = "supplier_id")
    private int supplierId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_image")
    private String productImage;
    @Column(name = "other_image")
    private String otherImage;

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getOtherImage() {
        return otherImage;
    }

    public void setOtherImage(String otherImage) {
        this.otherImage = otherImage;
    }
}