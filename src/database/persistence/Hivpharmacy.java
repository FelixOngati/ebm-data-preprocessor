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
@Table(name = "hivpharmacy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hivpharmacy.findAll", query = "SELECT h FROM Hivpharmacy h"),
    @NamedQuery(name = "Hivpharmacy.findById", query = "SELECT h FROM Hivpharmacy h WHERE h.id = :id"),
    @NamedQuery(name = "Hivpharmacy.findByPatientid", query = "SELECT h FROM Hivpharmacy h WHERE h.patientid = :patientid"),
    @NamedQuery(name = "Hivpharmacy.findBySitecode", query = "SELECT h FROM Hivpharmacy h WHERE h.sitecode = :sitecode"),
    @NamedQuery(name = "Hivpharmacy.findByDrug", query = "SELECT h FROM Hivpharmacy h WHERE h.drug = :drug"),
    @NamedQuery(name = "Hivpharmacy.findByDispensedate", query = "SELECT h FROM Hivpharmacy h WHERE h.dispensedate = :dispensedate"),
    @NamedQuery(name = "Hivpharmacy.findByTreatmenttype", query = "SELECT h FROM Hivpharmacy h WHERE h.treatmenttype = :treatmenttype")})
public class Hivpharmacy implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "drug")
    private String drug;
    @Basic(optional = false)
    @Column(name = "dispensedate")
    @Temporal(TemporalType.DATE)
    private Date dispensedate;
    @Basic(optional = false)
    @Column(name = "treatmenttype")
    private String treatmenttype;

    public Hivpharmacy() {
    }

    public Hivpharmacy(Integer id) {
        this.id = id;
    }

    public Hivpharmacy(Integer id, String patientid, int sitecode, String drug, Date dispensedate, String treatmenttype) {
        this.id = id;
        this.patientid = patientid;
        this.sitecode = sitecode;
        this.drug = drug;
        this.dispensedate = dispensedate;
        this.treatmenttype = treatmenttype;
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

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public Date getDispensedate() {
        return dispensedate;
    }

    public void setDispensedate(Date dispensedate) {
        this.dispensedate = dispensedate;
    }

    public String getTreatmenttype() {
        return treatmenttype;
    }

    public void setTreatmenttype(String treatmenttype) {
        this.treatmenttype = treatmenttype;
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
        if (!(object instanceof Hivpharmacy)) {
            return false;
        }
        Hivpharmacy other = (Hivpharmacy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.Hivpharmacy[ id=" + id + " ]";
    }
    
}
