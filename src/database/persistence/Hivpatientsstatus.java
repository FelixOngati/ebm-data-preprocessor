/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author the_fegati
 */
@Entity
@Table(name = "hivpatientsstatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hivpatientsstatus.findAll", query = "SELECT h FROM Hivpatientsstatus h"),
    @NamedQuery(name = "Hivpatientsstatus.findById", query = "SELECT h FROM Hivpatientsstatus h WHERE h.id = :id"),
    @NamedQuery(name = "Hivpatientsstatus.findByPatientid", query = "SELECT h FROM Hivpatientsstatus h WHERE h.patientid = :patientid"),
    @NamedQuery(name = "Hivpatientsstatus.findBySitecode", query = "SELECT h FROM Hivpatientsstatus h WHERE h.sitecode = :sitecode"),
    @NamedQuery(name = "Hivpatientsstatus.findByExitdate", query = "SELECT h FROM Hivpatientsstatus h WHERE h.exitdate = :exitdate"),
    @NamedQuery(name = "Hivpatientsstatus.findByExitreason", query = "SELECT h FROM Hivpatientsstatus h WHERE h.exitreason = :exitreason")})
public class Hivpatientsstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "patientid")
    private String patientid;
    @Basic(optional = false)
    @Column(name = "sitecode")
    private int sitecode;
    @Column(name = "exitdate")
    @Temporal(TemporalType.DATE)
    private Date exitdate;
    @Column(name = "exitreason")
    private String exitreason;

    public Hivpatientsstatus() {
    }

    public Hivpatientsstatus(Integer id) {
        this.id = id;
    }

    public Hivpatientsstatus(Integer id, String patientid, int sitecode) {
        this.id = id;
        this.patientid = patientid;
        this.sitecode = sitecode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public int getSitecode() {
        return sitecode;
    }

    public void setSitecode(int sitecode) {
        this.sitecode = sitecode;
    }

    public Date getExitdate() {
        return exitdate;
    }

    public void setExitdate(Date exitdate) {
        this.exitdate = exitdate;
    }

    public String getExitreason() {
        return exitreason;
    }

    public void setExitreason(String exitreason) {
        this.exitreason = exitreason;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hivpatientsstatus)) {
            return false;
        }
        Hivpatientsstatus other = (Hivpatientsstatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.Hivpatientsstatus[ id=" + id + " ]";
    }
    
}
