/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseEntry;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dex
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByPkId", query = "SELECT p FROM Product p WHERE p.pkId = :pkId"),
    @NamedQuery(name = "Product.findByPName", query = "SELECT p FROM Product p WHERE p.pName = :pName"),
    @NamedQuery(name = "Product.findByStockLevel", query = "SELECT p FROM Product p WHERE p.stockLevel = :stockLevel"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ID")
    private Integer pkId;
    @Size(max = 255)
    @Column(name = "PName")
    private String pName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StockLevel")
    private int stockLevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "FK_supplierInfo", referencedColumnName = "PK_ID")
    @ManyToOne(optional = false)
    private SupplierInfo fKsupplierInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKproduct")
    private Collection<SalesOrderLine> salesOrderLineCollection;

    public Product() {
    }

    public Product(Integer pkId) {
        this.pkId = pkId;
    }

    public Product(Integer pkId, int stockLevel, double price) {
        this.pkId = pkId;
        this.stockLevel = stockLevel;
        this.price = price;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SupplierInfo getFKsupplierInfo() {
        return fKsupplierInfo;
    }

    public void setFKsupplierInfo(SupplierInfo fKsupplierInfo) {
        this.fKsupplierInfo = fKsupplierInfo;
    }

    @XmlTransient
    public Collection<SalesOrderLine> getSalesOrderLineCollection() {
        return salesOrderLineCollection;
    }

    public void setSalesOrderLineCollection(Collection<SalesOrderLine> salesOrderLineCollection) {
        this.salesOrderLineCollection = salesOrderLineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkId != null ? pkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseEntry.Product[ pkId=" + pkId + " ]";
    }
    
}
