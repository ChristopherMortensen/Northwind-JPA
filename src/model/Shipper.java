package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author christophermortensen
 */
@Entity
@Table(name = "SHIPPER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipper.findAll", query = "SELECT s FROM Shipper s")
    , @NamedQuery(name = "Shipper.findByShipperId", query = "SELECT s FROM Shipper s WHERE s.shipperId = :shipperId")
    , @NamedQuery(name = "Shipper.findByCompanyName", query = "SELECT s FROM Shipper s WHERE s.companyName = :companyName")
    , @NamedQuery(name = "Shipper.findByPhone", query = "SELECT s FROM Shipper s WHERE s.phone = :phone")})
public class Shipper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SHIPPER_ID")
    private Integer shipperId;
    @Basic(optional = false)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(mappedBy = "shipVia")
    private Collection<OrderItem> orderItemCollection;

    public Shipper() {
    }

    public Shipper(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public Shipper(Integer shipperId, String companyName) {
        this.shipperId = shipperId;
        this.companyName = companyName;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<OrderItem> getOrderItemCollection() {
        return orderItemCollection;
    }

    public void setOrderItemCollection(Collection<OrderItem> orderItemCollection) {
        this.orderItemCollection = orderItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipperId != null ? shipperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipper)) {
            return false;
        }
        Shipper other = (Shipper) object;
        if ((this.shipperId == null && other.shipperId != null) || (this.shipperId != null && !this.shipperId.equals(other.shipperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shipper[ shipperId=" + shipperId + " ]";
    }

}
