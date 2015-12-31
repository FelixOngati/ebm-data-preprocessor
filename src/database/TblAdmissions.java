/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
 * @author the_fegati
 */
@Entity
@Table(name = "tblAdmissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdmissions.findAll", query = "SELECT t FROM TblAdmissions t"),
    @NamedQuery(name = "TblAdmissions.findByAdmissionId", query = "SELECT t FROM TblAdmissions t WHERE t.admissionId = :admissionId"),
    @NamedQuery(name = "TblAdmissions.findByPatientId", query = "SELECT t FROM TblAdmissions t WHERE t.patientId = :patientId"),
    @NamedQuery(name = "TblAdmissions.findByAdmissionStartDate", query = "SELECT t FROM TblAdmissions t WHERE t.admissionStartDate = :admissionStartDate"),
    @NamedQuery(name = "TblAdmissions.findByAdmissionEndDate", query = "SELECT t FROM TblAdmissions t WHERE t.admissionEndDate = :admissionEndDate")})
public class TblAdmissions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "admissionId")
    private String admissionId;
    @Basic(optional = false)
    @Column(name = "patientId")
    private String patientId;
    @Basic(optional = false)
    @Column(name = "admissionStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissionStartDate;
    @Basic(optional = false)
    @Column(name = "admissionEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissionEndDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAdmissionsadmissionId")
    private Collection<TblAdmissionDiagnoses> tblAdmissionDiagnosesCollection;
    @JoinColumn(name = "tblPatientDetails_patientId", referencedColumnName = "patientId")
    @ManyToOne(optional = false)
    private TblPatientDetails tblPatientDetailspatientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAdmissionsadmissionId")
    private Collection<TblLabs> tblLabsCollection;

    public TblAdmissions() {
    }

    public TblAdmissions(String admissionId) {
        this.admissionId = admissionId;
    }

    public TblAdmissions(String admissionId, String patientId, Date admissionStartDate, Date admissionEndDate) {
        this.admissionId = admissionId;
        this.patientId = patientId;
        this.admissionStartDate = admissionStartDate;
        this.admissionEndDate = admissionEndDate;
    }

    public String getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(String admissionId) {
        this.admissionId = admissionId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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

    @XmlTransient
    public Collection<TblAdmissionDiagnoses> getTblAdmissionDiagnosesCollection() {
        return tblAdmissionDiagnosesCollection;
    }

    public void setTblAdmissionDiagnosesCollection(Collection<TblAdmissionDiagnoses> tblAdmissionDiagnosesCollection) {
        this.tblAdmissionDiagnosesCollection = tblAdmissionDiagnosesCollection;
    }

    public TblPatientDetails getTblPatientDetailspatientId() {
        return tblPatientDetailspatientId;
    }

    public void setTblPatientDetailspatientId(TblPatientDetails tblPatientDetailspatientId) {
        this.tblPatientDetailspatientId = tblPatientDetailspatientId;
    }

    @XmlTransient
    public Collection<TblLabs> getTblLabsCollection() {
        return tblLabsCollection;
    }

    public void setTblLabsCollection(Collection<TblLabs> tblLabsCollection) {
        this.tblLabsCollection = tblLabsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admissionId != null ? admissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmissions)) {
            return false;
        }
        TblAdmissions other = (TblAdmissions) object;
        if ((this.admissionId == null && other.admissionId != null) || (this.admissionId != null && !this.admissionId.equals(other.admissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TblAdmissions[ admissionId=" + admissionId + " ]";
    }
    
}
