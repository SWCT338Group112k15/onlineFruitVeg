/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseEntry;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dex
 */
@Entity
@Table(name = "SalesOrderLine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrderLine.findAll", query = "SELECT s FROM SalesOrderLine s"),
    @NamedQuery(name = "SalesOrderLine.findByPkId", query = "SELECT s FROM SalesOrderLine s WHERE s.pkId = :pkId"),
    @NamedQuery(name = "SalesOrderLine.findByQuantity", query = "SELECT s FROM SalesOrderLine s WHERE s.quantity = :quantity")})
public class SalesOrderLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ID")
    private Integer pkId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "FK_SalesOrder", referencedColumnName = "PK_ID")
    @ManyToOne(optional = false)
    private SalesOrder fKSalesOrder;
    @JoinColumn(name = "FK_product", referencedColumnName = "PK_ID")
    @ManyToOne(optional = false)
    private Product fKproduct;

    public SalesOrderLine() {
    }

    public SalesOrderLine(Integer pkId) {
        this.pkId = pkId;
    }

    public SalesOrderLine(Integer pkId, int quantity) {
        this.pkId = pkId;
        this.quantity = quantity;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SalesOrder getFKSalesOrder() {
        return fKSalesOrder;
    }

    public void setFKSalesOrder(SalesOrder fKSalesOrder) {
        this.fKSalesOrder = fKSalesOrder;
    }

    public Product getFKproduct() {
        return fKproduct;
    }

    public void setFKproduct(Product fKproduct) {
        this.fKproduct = fKproduct;
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
        if (!(object instanceof SalesOrderLine)) {
            return false;
        }
        SalesOrderLine other = (SalesOrderLine) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseEntry.SalesOrderLine[ pkId=" + pkId + " ]";
    }
    
}
