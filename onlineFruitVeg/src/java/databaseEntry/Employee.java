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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dex
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByPkId", query = "SELECT e FROM Employee e WHERE e.pkId = :pkId"),
    @NamedQuery(name = "Employee.findByRoleInCompany", query = "SELECT e FROM Employee e WHERE e.roleInCompany = :roleInCompany"),
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PK_ID")
    private String pkId;
    @Size(max = 255)
    @Column(name = "RoleInCompany")
    private String roleInCompany;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salary")
    private double salary;
    @JoinColumn(name = "FK_Person", referencedColumnName = "PK_ID")
    @ManyToOne(optional = false)
    private Person fKPerson;

    public Employee() {
    }

    public Employee(String pkId) {
        this.pkId = pkId;
    }

    public Employee(String pkId, double salary) {
        this.pkId = pkId;
        this.salary = salary;
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getRoleInCompany() {
        return roleInCompany;
    }

    public void setRoleInCompany(String roleInCompany) {
        this.roleInCompany = roleInCompany;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person getFKPerson() {
        return fKPerson;
    }

    public void setFKPerson(Person fKPerson) {
        this.fKPerson = fKPerson;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseEntry.Employee[ pkId=" + pkId + " ]";
    }
    
}
