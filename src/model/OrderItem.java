package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author christophermortensen
 */
@Entity
@Table(name = "ORDER_ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o")
    , @NamedQuery(name = "OrderItem.findByOrderId", query = "SELECT o FROM OrderItem o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "OrderItem.findByOrderDate", query = "SELECT o FROM OrderItem o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "OrderItem.findByRequiredDate", query = "SELECT o FROM OrderItem o WHERE o.requiredDate = :requiredDate")
    , @NamedQuery(name = "OrderItem.findByShippedDate", query = "SELECT o FROM OrderItem o WHERE o.shippedDate = :shippedDate")
    , @NamedQuery(name = "OrderItem.findByFreight", query = "SELECT o FROM OrderItem o WHERE o.freight = :freight")
    , @NamedQuery(name = "OrderItem.findByShipName", query = "SELECT o FROM OrderItem o WHERE o.shipName = :shipName")
    , @NamedQuery(name = "OrderItem.findByShipAddress", query = "SELECT o FROM OrderItem o WHERE o.shipAddress = :shipAddress")
    , @NamedQuery(name = "OrderItem.findByShipCity", query = "SELECT o FROM OrderItem o WHERE o.shipCity = :shipCity")
    , @NamedQuery(name = "OrderItem.findByShipRegion", query = "SELECT o FROM OrderItem o WHERE o.shipRegion = :shipRegion")
    , @NamedQuery(name = "OrderItem.findByShipPostalCode", query = "SELECT o FROM OrderItem o WHERE o.shipPostalCode = :shipPostalCode")
    , @NamedQuery(name = "OrderItem.findByShipCountry", query = "SELECT o FROM OrderItem o WHERE o.shipCountry = :shipCountry")})
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "REQUIRED_DATE")
    @Temporal(TemporalType.DATE)
    private Date requiredDate;
    @Column(name = "SHIPPED_DATE")
    @Temporal(TemporalType.DATE)
    private Date shippedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FREIGHT")
    private Double freight;
    @Column(name = "SHIP_NAME")
    private String shipName;
    @Column(name = "SHIP_ADDRESS")
    private String shipAddress;
    @Column(name = "SHIP_CITY")
    private String shipCity;
    @Column(name = "SHIP_REGION")
    private String shipRegion;
    @Column(name = "SHIP_POSTAL_CODE")
    private String shipPostalCode;
    @Column(name = "SHIP_COUNTRY")
    private String shipCountry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderItem")
    private Collection<OrderDetail> orderDetailCollection;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "SHIP_VIA", referencedColumnName = "SHIPPER_ID")
    @ManyToOne
    private Shipper shipVia;

    public OrderItem() {
    }

    public OrderItem(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderItem(Integer orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Shipper getShipVia() {
        return shipVia;
    }

    public void setShipVia(Shipper shipVia) {
        this.shipVia = shipVia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrderItem[ orderId=" + orderId + " ]";
    }

}
