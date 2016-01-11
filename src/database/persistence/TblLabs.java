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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tblLabs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblLabs.findAll", query = "SELECT t FROM TblLabs t"),
    @NamedQuery(name = "TblLabs.findByAdmissionId", query = "SELECT t FROM TblLabs t WHERE t.admissionId = :admissionId"),
    @NamedQuery(name = "TblLabs.findByLabName", query = "SELECT t FROM TblLabs t WHERE t.labName = :labName"),
    @NamedQuery(name = "TblLabs.findByLabId", query = "SELECT t FROM TblLabs t WHERE t.labId = :labId"),
    @NamedQuery(name = "TblLabs.findByLabValue", query = "SELECT t FROM TblLabs t WHERE t.labValue = :labValue"),
    @NamedQuery(name = "TblLabs.findByLabUnits", query = "SELECT t FROM TblLabs t WHERE t.labUnits = :labUnits"),
    @NamedQuery(name = "TblLabs.findByLabDateTime", query = "SELECT t FROM TblLabs t WHERE t.labDateTime = :labDateTime")})
public class TblLabs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "admissionId")
    private String admissionId;
    @Basic(optional = false)
    @Column(name = "labName")
    private String labName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "labId")
    private Integer labId;
    @Basic(optional = false)
    @Column(name = "labValue")
    private double labValue;
    @Basic(optional = false)
    @Column(name = "labUnits")
    private String labUnits;
    @Column(name = "labDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date labDateTime;
    @JoinColumn(name = "patientId", referencedColumnName = "patientId")
    @ManyToOne(optional = false)
    private TblPatientDetails patientId;

    public TblLabs() {
    }

    public TblLabs(Integer labId) {
        this.labId = labId;
    }

    public TblLabs(Integer labId, String admissionId, String labName, double labValue, String labUnits) {
        this.labId = labId;
        this.admissionId = admissionId;
        this.labName = labName;
        this.labValue = labValue;
        this.labUnits = labUnits;
    }

    public String getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(String admissionId) {
        this.admissionId = admissionId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public double getLabValue() {
        return labValue;
    }

    public void setLabValue(double labValue) {
        this.labValue = labValue;
    }

    public String getLabUnits() {
        return labUnits;
    }

    public void setLabUnits(String labUnits) {
        this.labUnits = labUnits;
    }

    public Date getLabDateTime() {
        return labDateTime;
    }

    public void setLabDateTime(Date labDateTime) {
        this.labDateTime = labDateTime;
    }

    public TblPatientDetails getPatientId() {
        return patientId;
    }

    public void setPatientId(TblPatientDetails patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labId != null ? labId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLabs)) {
            return false;
        }
        TblLabs other = (TblLabs) object;
        if ((this.labId == null && other.labId != null) || (this.labId != null && !this.labId.equals(other.labId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TblLabs[ labId=" + labId + " ]";
    }
    
}
