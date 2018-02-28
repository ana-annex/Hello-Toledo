/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Alumno
 */
@Entity
@Table(catalog = "tienda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codigopostal.findAll", query = "SELECT c FROM Codigopostal c")
    , @NamedQuery(name = "Codigopostal.findByIdcodigopostal", query = "SELECT c FROM Codigopostal c WHERE c.idcodigopostal = :idcodigopostal")
    , @NamedQuery(name = "Codigopostal.findByCiudad", query = "SELECT c FROM Codigopostal c WHERE c.ciudad = :ciudad")})
public class Codigopostal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idcodigopostal;
    @Size(max = 45)
    @Column(length = 45)
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcodigopostal")
    private Collection<Proveedor> proveedorCollection;

    public Codigopostal() {
    }

    public Codigopostal(Integer idcodigopostal) {
        this.idcodigopostal = idcodigopostal;
    }

    public Integer getIdcodigopostal() {
        return idcodigopostal;
    }

    public void setIdcodigopostal(Integer idcodigopostal) {
        this.idcodigopostal = idcodigopostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcodigopostal != null ? idcodigopostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codigopostal)) {
            return false;
        }
        Codigopostal other = (Codigopostal) object;
        if ((this.idcodigopostal == null && other.idcodigopostal != null) || (this.idcodigopostal != null && !this.idcodigopostal.equals(other.idcodigopostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Codigopostal[ idcodigopostal=" + idcodigopostal + " ]";
    }
    
}
