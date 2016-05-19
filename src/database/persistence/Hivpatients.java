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
@Table(name = "hivpatients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hivpatients.findAll", query = "SELECT h FROM Hivpatients h"),
    @NamedQuery(name = "Hivpatients.findById", query = "SELECT h FROM Hivpatients h WHERE h.id = :id"),
    @NamedQuery(name = "Hivpatients.findByPatientid", query = "SELECT h FROM Hivpatients h WHERE h.patientid = :patientid"),
    @NamedQuery(name = "Hivpatients.findByPatientpk", query = "SELECT h FROM Hivpatients h WHERE h.patientpk = :patientpk"),
    @NamedQuery(name = "Hivpatients.findBySitecode", query = "SELECT h FROM Hivpatients h WHERE h.sitecode = :sitecode"),
    @NamedQuery(name = "Hivpatients.findByGender", query = "SELECT h FROM Hivpatients h WHERE h.gender = :gender"),
    @NamedQuery(name = "Hivpatients.findByDob", query = "SELECT h FROM Hivpatients h WHERE h.dob = :dob"),
    @NamedQuery(name = "Hivpatients.findByRegistrationdate", query = "SELECT h FROM Hivpatients h WHERE h.registrationdate = :registrationdate"),
    @NamedQuery(name = "Hivpatients.findByRegistrationatccc", query = "SELECT h FROM Hivpatients h WHERE h.registrationatccc = :registrationatccc"),
    @NamedQuery(name = "Hivpatients.findByRegistrationatpmtct", query = "SELECT h FROM Hivpatients h WHERE h.registrationatpmtct = :registrationatpmtct"),
    @NamedQuery(name = "Hivpatients.findByRegistrationattbclinic", query = "SELECT h FROM Hivpatients h WHERE h.registrationattbclinic = :registrationattbclinic"),
    @NamedQuery(name = "Hivpatients.findByPatientsource", query = "SELECT h FROM Hivpatients h WHERE h.patientsource = :patientsource"),
    @NamedQuery(name = "Hivpatients.findByRegion", query = "SELECT h FROM Hivpatients h WHERE h.region = :region"),
    @NamedQuery(name = "Hivpatients.findByDistrict", query = "SELECT h FROM Hivpatients h WHERE h.district = :district"),
    @NamedQuery(name = "Hivpatients.findByLastvisit", query = "SELECT h FROM Hivpatients h WHERE h.lastvisit = :lastvisit"),
    @NamedQuery(name = "Hivpatients.findByMaritalstatus", query = "SELECT h FROM Hivpatients h WHERE h.maritalstatus = :maritalstatus"),
    @NamedQuery(name = "Hivpatients.findByEducationlevel", query = "SELECT h FROM Hivpatients h WHERE h.educationlevel = :educationlevel"),
    @NamedQuery(name = "Hivpatients.findByDateconfirmedhivpositive", query = "SELECT h FROM Hivpatients h WHERE h.dateconfirmedhivpositive = :dateconfirmedhivpositive")})
public class Hivpatients implements Serializable {
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
    @Column(name = "patientpk")
    private String patientpk;
    @Basic(optional = false)
    @Column(name = "sitecode")
    private int sitecode;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "registrationdate")
    @Temporal(TemporalType.DATE)
    private Date registrationdate;
    @Basic(optional = false)
    @Column(name = "registrationatccc")
    @Temporal(TemporalType.DATE)
    private Date registrationatccc;
    @Column(name = "registrationatpmtct")
    @Temporal(TemporalType.DATE)
    private Date registrationatpmtct;
    @Column(name = "registrationattbclinic")
    @Temporal(TemporalType.DATE)
    private Date registrationattbclinic;
    @Basic(optional = false)
    @Column(name = "patientsource")
    private String patientsource;
    @Column(name = "region")
    private String region;
    @Column(name = "district")
    private String district;
    @Basic(optional = false)
    @Column(name = "lastvisit")
    @Temporal(TemporalType.DATE)
    private Date lastvisit;
    @Column(name = "maritalstatus")
    private String maritalstatus;
    @Basic(optional = false)
    @Column(name = "educationlevel")
    private String educationlevel;
    @Basic(optional = false)
    @Column(name = "dateconfirmedhivpositive")
    @Temporal(TemporalType.DATE)
    private Date dateconfirmedhivpositive;

    public Hivpatients() {
    }

    public Hivpatients(Integer id) {
        this.id = id;
    }

    public Hivpatients(Integer id, String patientid, String patientpk, int sitecode, String gender, Date dob, Date registrationdate, Date registrationatccc, String patientsource, Date lastvisit, String educationlevel, Date dateconfirmedhivpositive) {
        this.id = id;
        this.patientid = patientid;
        this.patientpk = patientpk;
        this.sitecode = sitecode;
        this.gender = gender;
        this.dob = dob;
        this.registrationdate = registrationdate;
        this.registrationatccc = registrationatccc;
        this.patientsource = patientsource;
        this.lastvisit = lastvisit;
        this.educationlevel = educationlevel;
        this.dateconfirmedhivpositive = dateconfirmedhivpositive;
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

    public String getPatientpk() {
        return patientpk;
    }

    public void setPatientpk(String patientpk) {
        this.patientpk = patientpk;
    }

    public int getSitecode() {
        return sitecode;
    }

    public void setSitecode(int sitecode) {
        this.sitecode = sitecode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Date getRegistrationatccc() {
        return registrationatccc;
    }

    public void setRegistrationatccc(Date registrationatccc) {
        this.registrationatccc = registrationatccc;
    }

    public Date getRegistrationatpmtct() {
        return registrationatpmtct;
    }

    public void setRegistrationatpmtct(Date registrationatpmtct) {
        this.registrationatpmtct = registrationatpmtct;
    }

    public Date getRegistrationattbclinic() {
        return registrationattbclinic;
    }

    public void setRegistrationattbclinic(Date registrationattbclinic) {
        this.registrationattbclinic = registrationattbclinic;
    }

    public String getPatientsource() {
        return patientsource;
    }

    public void setPatientsource(String patientsource) {
        this.patientsource = patientsource;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Date getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(Date lastvisit) {
        this.lastvisit = lastvisit;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }

    public Date getDateconfirmedhivpositive() {
        return dateconfirmedhivpositive;
    }

    public void setDateconfirmedhivpositive(Date dateconfirmedhivpositive) {
        this.dateconfirmedhivpositive = dateconfirmedhivpositive;
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
        if (!(object instanceof Hivpatients)) {
            return false;
        }
        Hivpatients other = (Hivpatients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.Hivpatients[ id=" + id + " ]";
    }
    
}
