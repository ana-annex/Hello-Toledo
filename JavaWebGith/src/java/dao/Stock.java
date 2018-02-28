/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno
 */
@Entity
@Table(catalog = "tienda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByCodigoSotck", query = "SELECT s FROM Stock s WHERE s.codigoSotck = :codigoSotck")
    , @NamedQuery(name = "Stock.findByCantidad", query = "SELECT s FROM Stock s WHERE s.cantidad = :cantidad")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigoSotck;
    private Integer cantidad;
    @JoinColumn(name = "Producto_codigoProducto", referencedColumnName = "codigoProducto", nullable = false)
    @ManyToOne(optional = false)
    private Producto productocodigoProducto;

    public Stock() {
    }

    public Stock(Integer codigoSotck) {
        this.codigoSotck = codigoSotck;
    }

    public Integer getCodigoSotck() {
        return codigoSotck;
    }

    public void setCodigoSotck(Integer codigoSotck) {
        this.codigoSotck = codigoSotck;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProductocodigoProducto() {
        return productocodigoProducto;
    }

    public void setProductocodigoProducto(Producto productocodigoProducto) {
        this.productocodigoProducto = productocodigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSotck != null ? codigoSotck.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.codigoSotck == null && other.codigoSotck != null) || (this.codigoSotck != null && !this.codigoSotck.equals(other.codigoSotck))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Stock[ codigoSotck=" + codigoSotck + " ]";
    }
    
}
