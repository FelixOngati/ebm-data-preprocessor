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
@Table(name = "hivartpatients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hivartpatients.findAll", query = "SELECT h FROM Hivartpatients h"),
    @NamedQuery(name = "Hivartpatients.findByPatientid", query = "SELECT h FROM Hivartpatients h WHERE h.patientid = :patientid"),
    @NamedQuery(name = "Hivartpatients.findByPatientpk", query = "SELECT h FROM Hivartpatients h WHERE h.patientpk = :patientpk"),
    @NamedQuery(name = "Hivartpatients.findByAgeenrollment", query = "SELECT h FROM Hivartpatients h WHERE h.ageenrollment = :ageenrollment"),
    @NamedQuery(name = "Hivartpatients.findByAgeartstart", query = "SELECT h FROM Hivartpatients h WHERE h.ageartstart = :ageartstart"),
    @NamedQuery(name = "Hivartpatients.findById", query = "SELECT h FROM Hivartpatients h WHERE h.id = :id"),
    @NamedQuery(name = "Hivartpatients.findByAgelastvisit", query = "SELECT h FROM Hivartpatients h WHERE h.agelastvisit = :agelastvisit"),
    @NamedQuery(name = "Hivartpatients.findBySitecode", query = "SELECT h FROM Hivartpatients h WHERE h.sitecode = :sitecode"),
    @NamedQuery(name = "Hivartpatients.findByStartartdate", query = "SELECT h FROM Hivartpatients h WHERE h.startartdate = :startartdate"),
    @NamedQuery(name = "Hivartpatients.findByStartartatthisfacility", query = "SELECT h FROM Hivartpatients h WHERE h.startartatthisfacility = :startartatthisfacility"),
    @NamedQuery(name = "Hivartpatients.findByStartregimen", query = "SELECT h FROM Hivartpatients h WHERE h.startregimen = :startregimen"),
    @NamedQuery(name = "Hivartpatients.findByStartregimenline", query = "SELECT h FROM Hivartpatients h WHERE h.startregimenline = :startregimenline"),
    @NamedQuery(name = "Hivartpatients.findByLastartdate", query = "SELECT h FROM Hivartpatients h WHERE h.lastartdate = :lastartdate"),
    @NamedQuery(name = "Hivartpatients.findByLastregimen", query = "SELECT h FROM Hivartpatients h WHERE h.lastregimen = :lastregimen"),
    @NamedQuery(name = "Hivartpatients.findByLastregimenline", query = "SELECT h FROM Hivartpatients h WHERE h.lastregimenline = :lastregimenline"),
    @NamedQuery(name = "Hivartpatients.findByDuration", query = "SELECT h FROM Hivartpatients h WHERE h.duration = :duration"),
    @NamedQuery(name = "Hivartpatients.findByExpectedreturn", query = "SELECT h FROM Hivartpatients h WHERE h.expectedreturn = :expectedreturn"),
    @NamedQuery(name = "Hivartpatients.findByLastvisit", query = "SELECT h FROM Hivartpatients h WHERE h.lastvisit = :lastvisit"),
    @NamedQuery(name = "Hivartpatients.findByExitreason", query = "SELECT h FROM Hivartpatients h WHERE h.exitreason = :exitreason"),
    @NamedQuery(name = "Hivartpatients.findByExitdate", query = "SELECT h FROM Hivartpatients h WHERE h.exitdate = :exitdate")})
public class Hivartpatients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "patientid")
    private String patientid;
    @Basic(optional = false)
    @Column(name = "patientpk")
    private String patientpk;
    @Basic(optional = false)
    @Column(name = "ageenrollment")
    private float ageenrollment;
    @Basic(optional = false)
    @Column(name = "ageartstart")
    private float ageartstart;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "agelastvisit")
    private float agelastvisit;
    @Basic(optional = false)
    @Column(name = "sitecode")
    private int sitecode;
    @Basic(optional = false)
    @Column(name = "startartdate")
    @Temporal(TemporalType.DATE)
    private Date startartdate;
    @Basic(optional = false)
    @Column(name = "startartatthisfacility")
    @Temporal(TemporalType.DATE)
    private Date startartatthisfacility;
    @Basic(optional = false)
    @Column(name = "startregimen")
    private String startregimen;
    @Basic(optional = false)
    @Column(name = "startregimenline")
    private String startregimenline;
    @Basic(optional = false)
    @Column(name = "lastartdate")
    @Temporal(TemporalType.DATE)
    private Date lastartdate;
    @Basic(optional = false)
    @Column(name = "lastregimen")
    private String lastregimen;
    @Basic(optional = false)
    @Column(name = "lastregimenline")
    private String lastregimenline;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "expectedreturn")
    @Temporal(TemporalType.DATE)
    private Date expectedreturn;
    @Basic(optional = false)
    @Column(name = "lastvisit")
    @Temporal(TemporalType.DATE)
    private Date lastvisit;
    @Column(name = "exitreason")
    private String exitreason;
    @Column(name = "exitdate")
    @Temporal(TemporalType.DATE)
    private Date exitdate;

    public Hivartpatients() {
    }

    public Hivartpatients(Integer id) {
        this.id = id;
    }

    public Hivartpatients(Integer id, String patientid, String patientpk, float ageenrollment, float ageartstart, float agelastvisit, int sitecode, Date startartdate, Date startartatthisfacility, String startregimen, String startregimenline, Date lastartdate, String lastregimen, String lastregimenline, int duration, Date expectedreturn, Date lastvisit) {
        this.id = id;
        this.patientid = patientid;
        this.patientpk = patientpk;
        this.ageenrollment = ageenrollment;
        this.ageartstart = ageartstart;
        this.agelastvisit = agelastvisit;
        this.sitecode = sitecode;
        this.startartdate = startartdate;
        this.startartatthisfacility = startartatthisfacility;
        this.startregimen = startregimen;
        this.startregimenline = startregimenline;
        this.lastartdate = lastartdate;
        this.lastregimen = lastregimen;
        this.lastregimenline = lastregimenline;
        this.duration = duration;
        this.expectedreturn = expectedreturn;
        this.lastvisit = lastvisit;
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

    public float getAgeenrollment() {
        return ageenrollment;
    }

    public void setAgeenrollment(float ageenrollment) {
        this.ageenrollment = ageenrollment;
    }

    public float getAgeartstart() {
        return ageartstart;
    }

    public void setAgeartstart(float ageartstart) {
        this.ageartstart = ageartstart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getAgelastvisit() {
        return agelastvisit;
    }

    public void setAgelastvisit(float agelastvisit) {
        this.agelastvisit = agelastvisit;
    }

    public int getSitecode() {
        return sitecode;
    }

    public void setSitecode(int sitecode) {
        this.sitecode = sitecode;
    }

    public Date getStartartdate() {
        return startartdate;
    }

    public void setStartartdate(Date startartdate) {
        this.startartdate = startartdate;
    }

    public Date getStartartatthisfacility() {
        return startartatthisfacility;
    }

    public void setStartartatthisfacility(Date startartatthisfacility) {
        this.startartatthisfacility = startartatthisfacility;
    }

    public String getStartregimen() {
        return startregimen;
    }

    public void setStartregimen(String startregimen) {
        this.startregimen = startregimen;
    }

    public String getStartregimenline() {
        return startregimenline;
    }

    public void setStartregimenline(String startregimenline) {
        this.startregimenline = startregimenline;
    }

    public Date getLastartdate() {
        return lastartdate;
    }

    public void setLastartdate(Date lastartdate) {
        this.lastartdate = lastartdate;
    }

    public String getLastregimen() {
        return lastregimen;
    }

    public void setLastregimen(String lastregimen) {
        this.lastregimen = lastregimen;
    }

    public String getLastregimenline() {
        return lastregimenline;
    }

    public void setLastregimenline(String lastregimenline) {
        this.lastregimenline = lastregimenline;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getExpectedreturn() {
        return expectedreturn;
    }

    public void setExpectedreturn(Date expectedreturn) {
        this.expectedreturn = expectedreturn;
    }

    public Date getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(Date lastvisit) {
        this.lastvisit = lastvisit;
    }

    public String getExitreason() {
        return exitreason;
    }

    public void setExitreason(String exitreason) {
        this.exitreason = exitreason;
    }

    public Date getExitdate() {
        return exitdate;
    }

    public void setExitdate(Date exitdate) {
        this.exitdate = exitdate;
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
        if (!(object instanceof Hivartpatients)) {
            return false;
        }
        Hivartpatients other = (Hivartpatients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.Hivartpatients[ id=" + id + " ]";
    }
    
}
