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
@Table(name = "tblAdmissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdmissions.findAll", query = "SELECT t FROM TblAdmissions t"),
    @NamedQuery(name = "TblAdmissions.findById", query = "SELECT t FROM TblAdmissions t WHERE t.id = :id"),
    @NamedQuery(name = "TblAdmissions.findByAdmissionId", query = "SELECT t FROM TblAdmissions t WHERE t.admissionId = :admissionId"),
    @NamedQuery(name = "TblAdmissions.findByAdmissionStartDate", query = "SELECT t FROM TblAdmissions t WHERE t.admissionStartDate = :admissionStartDate"),
    @NamedQuery(name = "TblAdmissions.findByAdmissionEndDate", query = "SELECT t FROM TblAdmissions t WHERE t.admissionEndDate = :admissionEndDate")})
public class TblAdmissions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "admissionId")
    private String admissionId;
    @Basic(optional = false)
    @Column(name = "admissionStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissionStartDate;
    @Basic(optional = false)
    @Column(name = "admissionEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissionEndDate;
    @JoinColumn(name = "patientId", referencedColumnName = "patientId")
    @ManyToOne(optional = false)
    private TblPatientDetails patientId;

    public TblAdmissions() {
    }

    public TblAdmissions(Integer id) {
        this.id = id;
    }

    public TblAdmissions(Integer id, String admissionId, Date admissionStartDate, Date admissionEndDate) {
        this.id = id;
        this.admissionId = admissionId;
        this.admissionStartDate = admissionStartDate;
        this.admissionEndDate = admissionEndDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(String admissionId) {
        this.admissionId = admissionId;
    }

    public Date getAdmissionStartDate() {
        return admissionStartDate;
    }

    public void setAdmissionStartDate(Date admissionStartDate) {
        this.admissionStartDate = admissionStartDate;
    }

    public Date getAdmissionEndDate() {
        return admissionEndDate;
    }

    public void setAdmissionEndDate(Date admissionEndDate) {
        this.admissionEndDate = admissionEndDate;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmissions)) {
            return false;
        }
        TblAdmissions other = (TblAdmissions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TblAdmissions[ id=" + id + " ]";
    }
    
}
