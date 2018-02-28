/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno
 */
@Entity
@Table(catalog = "tienda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByCodigoVenta", query = "SELECT v FROM Venta v WHERE v.codigoVenta = :codigoVenta")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByCantidad", query = "SELECT v FROM Venta v WHERE v.cantidad = :cantidad")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cantidad;
    @JoinColumn(name = "Dni", referencedColumnName = "Dni", nullable = false)
    @ManyToOne(optional = false)
    private Cliente dni;
    @JoinColumn(name = "codigoProducto", referencedColumnName = "codigoProducto", nullable = false)
    @ManyToOne(optional = false)
    private Producto codigoProducto;

    public Venta() {
    }

    public Venta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Venta(Integer codigoVenta, Date fecha, int cantidad) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getDni() {
        return dni;
    }

    public void setDni(Cliente dni) {
        this.dni = dni;
    }

    public Producto getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Producto codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVenta != null ? codigoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.codigoVenta == null && other.codigoVenta != null) || (this.codigoVenta != null && !this.codigoVenta.equals(other.codigoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Venta[ codigoVenta=" + codigoVenta + " ]";
    }
    
}
