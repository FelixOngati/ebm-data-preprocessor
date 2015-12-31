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
@Table(name = "tblPatientDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPatientDetails.findAll", query = "SELECT t FROM TblPatientDetails t"),
    @NamedQuery(name = "TblPatientDetails.findByPatientId", query = "SELECT t FROM TblPatientDetails t WHERE t.patientId = :patientId"),
    @NamedQuery(name = "TblPatientDetails.findByPatientGender", query = "SELECT t FROM TblPatientDetails t WHERE t.patientGender = :patientGender"),
    @NamedQuery(name = "TblPatientDetails.findByPatientDOB", query = "SELECT t FROM TblPatientDetails t WHERE t.patientDOB = :patientDOB"),
    @NamedQuery(name = "TblPatientDetails.findByPatientRace", query = "SELECT t FROM TblPatientDetails t WHERE t.patientRace = :patientRace"),
    @NamedQuery(name = "TblPatientDetails.findByPatientMaritalStatus", query = "SELECT t FROM TblPatientDetails t WHERE t.patientMaritalStatus = :patientMaritalStatus"),
    @NamedQuery(name = "TblPatientDetails.findByPatientLanguage", query = "SELECT t FROM TblPatientDetails t WHERE t.patientLanguage = :patientLanguage"),
    @NamedQuery(name = "TblPatientDetails.findByPatientPopulationPercentageBelowPoverty", query = "SELECT t FROM TblPatientDetails t WHERE t.patientPopulationPercentageBelowPoverty = :patientPopulationPercentageBelowPoverty")})
public class TblPatientDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "patientId")
    private String patientId;
    @Basic(optional = false)
    @Column(name = "patientGender")
    private String patientGender;
    @Basic(optional = false)
    @Column(name = "patientDOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patientDOB;
    @Column(name = "patientRace")
    private String patientRace;
    @Column(name = "patientMaritalStatus")
    private String patientMaritalStatus;
    @Column(name = "patientLanguage")
    private String patientLanguage;
    @Column(name = "patientPopulationPercentageBelowPoverty")
    private String patientPopulationPercentageBelowPoverty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblPatientDetailspatientId")
    private Collection<TblAdmissionDiagnoses> tblAdmissionDiagnosesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblPatientDetailspatientId")
    private Collection<TblAdmissions> tblAdmissionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblPatientDetailspatientId")
    private Collection<TblLabs> tblLabsCollection;

    public TblPatientDetails() {
    }

    public TblPatientDetails(String patientId) {
        this.patientId = patientId;
    }

    public TblPatientDetails(String patientId, String patientGender, Date patientDOB) {
        this.patientId = patientId;
        this.patientGender = patientGender;
        this.patientDOB = patientDOB;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Date getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(Date patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientRace() {
        return patientRace;
    }

    public void setPatientRace(String patientRace) {
        this.patientRace = patientRace;
    }

    public String getPatientMaritalStatus() {
        return patientMaritalStatus;
    }

    public void setPatientMaritalStatus(String patientMaritalStatus) {
        this.patientMaritalStatus = patientMaritalStatus;
    }

    public String getPatientLanguage() {
        return patientLanguage;
    }

    public void setPatientLanguage(String patientLanguage) {
        this.patientLanguage = patientLanguage;
    }

    public String getPatientPopulationPercentageBelowPoverty() {
        return patientPopulationPercentageBelowPoverty;
    }

    public void setPatientPopulationPercentageBelowPoverty(String patientPopulationPercentageBelowPoverty) {
        this.patientPopulationPercentageBelowPoverty = patientPopulationPercentageBelowPoverty;
    }

    @XmlTransient
    public Collection<TblAdmissionDiagnoses> getTblAdmissionDiagnosesCollection() {
        return tblAdmissionDiagnosesCollection;
    }

    public void setTblAdmissionDiagnosesCollection(Collection<TblAdmissionDiagnoses> tblAdmissionDiagnosesCollection) {
        this.tblAdmissionDiagnosesCollection = tblAdmissionDiagnosesCollection;
    }

    @XmlTransient
    public Collection<TblAdmissions> getTblAdmissionsCollection() {
        return tblAdmissionsCollection;
    }

    public void setTblAdmissionsCollection(Collection<TblAdmissions> tblAdmissionsCollection) {
        this.tblAdmissionsCollection = tblAdmissionsCollection;
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
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPatientDetails)) {
            return false;
        }
        TblPatientDetails other = (TblPatientDetails) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TblPatientDetails[ patientId=" + patientId + " ]";
    }
    
}
