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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dex
 */
@Entity
@Table(name = "supplierInfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierInfo.findAll", query = "SELECT s FROM SupplierInfo s"),
    @NamedQuery(name = "SupplierInfo.findByPkId", query = "SELECT s FROM SupplierInfo s WHERE s.pkId = :pkId"),
    @NamedQuery(name = "SupplierInfo.findByBusinessName", query = "SELECT s FROM SupplierInfo s WHERE s.businessName = :businessName"),
    @NamedQuery(name = "SupplierInfo.findByBillingInformation", query = "SELECT s FROM SupplierInfo s WHERE s.billingInformation = :billingInformation")})
public class SupplierInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ID")
    private Integer pkId;
    @Size(max = 255)
    @Column(name = "BusinessName")
    private String businessName;
    @Size(max = 255)
    @Column(name = "BillingInformation")
    private String billingInformation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKsupplierInfo")
    private Collection<Product> productCollection;

    public SupplierInfo() {
    }

    public SupplierInfo(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBillingInformation() {
        return billingInformation;
    }

    public void setBillingInformation(String billingInformation) {
        this.billingInformation = billingInformation;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
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
        if (!(object instanceof SupplierInfo)) {
            return false;
        }
        SupplierInfo other = (SupplierInfo) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseEntry.SupplierInfo[ pkId=" + pkId + " ]";
    }
    
}
