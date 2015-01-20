/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseEntry;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dex
 */
@Entity
@Table(name = "SalesOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s"),
    @NamedQuery(name = "SalesOrder.findByPkId", query = "SELECT s FROM SalesOrder s WHERE s.pkId = :pkId"),
    @NamedQuery(name = "SalesOrder.findByOrderDate", query = "SELECT s FROM SalesOrder s WHERE s.orderDate = :orderDate")})
public class SalesOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ID")
    private Integer pkId;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKSalesOrder")
    private Collection<SalesOrderLine> salesOrderLineCollection;
    @JoinColumn(name = "FK_customer", referencedColumnName = "PK_ID")
    @ManyToOne(optional = false)
    private Customer fKcustomer;

    public SalesOrder() {
    }

    public SalesOrder(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @XmlTransient
    public Collection<SalesOrderLine> getSalesOrderLineCollection() {
        return salesOrderLineCollection;
    }

    public void setSalesOrderLineCollection(Collection<SalesOrderLine> salesOrderLineCollection) {
        this.salesOrderLineCollection = salesOrderLineCollection;
    }

    public Customer getFKcustomer() {
        return fKcustomer;
    }

    public void setFKcustomer(Customer fKcustomer) {
        this.fKcustomer = fKcustomer;
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
        if (!(object instanceof SalesOrder)) {
            return false;
        }
        SalesOrder other = (SalesOrder) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseEntry.SalesOrder[ pkId=" + pkId + " ]";
    }
    
}
