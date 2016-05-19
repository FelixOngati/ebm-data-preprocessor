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
@Table(name = "hivlabs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hivlabs.findAll", query = "SELECT h FROM Hivlabs h"),
    @NamedQuery(name = "Hivlabs.findById", query = "SELECT h FROM Hivlabs h WHERE h.id = :id"),
    @NamedQuery(name = "Hivlabs.findByPatientid", query = "SELECT h FROM Hivlabs h WHERE h.patientid = :patientid"),
    @NamedQuery(name = "Hivlabs.findByPatientpk", query = "SELECT h FROM Hivlabs h WHERE h.patientpk = :patientpk"),
    @NamedQuery(name = "Hivlabs.findBySitecode", query = "SELECT h FROM Hivlabs h WHERE h.sitecode = :sitecode"),
    @NamedQuery(name = "Hivlabs.findByOrderedbydate", query = "SELECT h FROM Hivlabs h WHERE h.orderedbydate = :orderedbydate"),
    @NamedQuery(name = "Hivlabs.findByTestname", query = "SELECT h FROM Hivlabs h WHERE h.testname = :testname"),
    @NamedQuery(name = "Hivlabs.findByTestresult", query = "SELECT h FROM Hivlabs h WHERE h.testresult = :testresult")})
public class Hivlabs implements Serializable {
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
    @Column(name = "orderedbydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderedbydate;
    @Basic(optional = false)
    @Column(name = "testname")
    private String testname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "testresult")
    private Float testresult;

    public Hivlabs() {
    }

    public Hivlabs(Integer id) {
        this.id = id;
    }

    public Hivlabs(Integer id, String patientid, String patientpk, int sitecode, Date orderedbydate, String testname) {
        this.id = id;
        this.patientid = patientid;
        this.patientpk = patientpk;
        this.sitecode = sitecode;
        this.orderedbydate = orderedbydate;
        this.testname = testname;
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

    public Date getOrderedbydate() {
        return orderedbydate;
    }

    public void setOrderedbydate(Date orderedbydate) {
        this.orderedbydate = orderedbydate;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public Float getTestresult() {
        return testresult;
    }

    public void setTestresult(Float testresult) {
        this.testresult = testresult;
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
        if (!(object instanceof Hivlabs)) {
            return false;
        }
        Hivlabs other = (Hivlabs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.Hivlabs[ id=" + id + " ]";
    }
    
}
