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
 * @author the_fegati
 */
@Entity
@Table(name = "tblAdmissionDiagnoses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdmissionDiagnoses.findAll", query = "SELECT t FROM TblAdmissionDiagnoses t"),
    @NamedQuery(name = "TblAdmissionDiagnoses.findByAdmissionId", query = "SELECT t FROM TblAdmissionDiagnoses t WHERE t.admissionId = :admissionId"),
    @NamedQuery(name = "TblAdmissionDiagnoses.findByAdmissionDiagnosisId", query = "SELECT t FROM TblAdmissionDiagnoses t WHERE t.admissionDiagnosisId = :admissionDiagnosisId"),
    @NamedQuery(name = "TblAdmissionDiagnoses.findByDcode", query = "SELECT t FROM TblAdmissionDiagnoses t WHERE t.dcode = :dcode"),
    @NamedQuery(name = "TblAdmissionDiagnoses.findByPrimaryDiagnosisDescription", query = "SELECT t FROM TblAdmissionDiagnoses t WHERE t.primaryDiagnosisDescription = :primaryDiagnosisDescription")})
public class TblAdmissionDiagnoses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "admissionId")
    private String admissionId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admissionDiagnosisId")
    private Integer admissionDiagnosisId;
    @Basic(optional = false)
    @Column(name = "dcode")
    private String dcode;
    @Column(name = "primaryDiagnosisDescription")
    private String primaryDiagnosisDescription;
    @JoinColumn(name = "patientId", referencedColumnName = "patientId")
    @ManyToOne(optional = false)
    private TblPatientDetails patientId;

    public TblAdmissionDiagnoses() {
    }

    public TblAdmissionDiagnoses(Integer admissionDiagnosisId) {
        this.admissionDiagnosisId = admissionDiagnosisId;
    }

    public TblAdmissionDiagnoses(Integer admissionDiagnosisId, String admissionId, String dcode) {
        this.admissionDiagnosisId = admissionDiagnosisId;
        this.admissionId = admissionId;
        this.dcode = dcode;
    }

    public String getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(String admissionId) {
        this.admissionId = admissionId;
    }

    public Integer getAdmissionDiagnosisId() {
        return admissionDiagnosisId;
    }

    public void setAdmissionDiagnosisId(Integer admissionDiagnosisId) {
        this.admissionDiagnosisId = admissionDiagnosisId;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public String getPrimaryDiagnosisDescription() {
        return primaryDiagnosisDescription;
    }

    public void setPrimaryDiagnosisDescription(String primaryDiagnosisDescription) {
        this.primaryDiagnosisDescription = primaryDiagnosisDescription;
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
        hash += (admissionDiagnosisId != null ? admissionDiagnosisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmissionDiagnoses)) {
            return false;
        }
        TblAdmissionDiagnoses other = (TblAdmissionDiagnoses) object;
        if ((this.admissionDiagnosisId == null && other.admissionDiagnosisId != null) || (this.admissionDiagnosisId != null && !this.admissionDiagnosisId.equals(other.admissionDiagnosisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TblAdmissionDiagnoses[ admissionDiagnosisId=" + admissionDiagnosisId + " ]";
    }
    
}
