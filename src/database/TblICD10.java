/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author the_fegati
 */
@Entity
@Table(name = "tblICD10")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblICD10.findAll", query = "SELECT t FROM TblICD10 t"),
    @NamedQuery(name = "TblICD10.findByDcode", query = "SELECT t FROM TblICD10 t WHERE t.dcode = :dcode"),
    @NamedQuery(name = "TblICD10.findByShortDescription", query = "SELECT t FROM TblICD10 t WHERE t.shortDescription = :shortDescription"),
    @NamedQuery(name = "TblICD10.findByLongDescription", query = "SELECT t FROM TblICD10 t WHERE t.longDescription = :longDescription")})
public class TblICD10 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dcode")
    private String dcode;
    @Basic(optional = false)
    @Column(name = "shortDescription")
    private String shortDescription;
    @Basic(optional = false)
    @Column(name = "longDescription")
    private String longDescription;

    public TblICD10() {
    }

    public TblICD10(String dcode) {
        this.dcode = dcode;
    }

    public TblICD10(String dcode, String shortDescription, String longDescription) {
        this.dcode = dcode;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dcode != null ? dcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblICD10)) {
            return false;
        }
        TblICD10 other = (TblICD10) object;
        if ((this.dcode == null && other.dcode != null) || (this.dcode != null && !this.dcode.equals(other.dcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TblICD10[ dcode=" + dcode + " ]";
    }
    
}
