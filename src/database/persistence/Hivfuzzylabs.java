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
@Table(name = "hivfuzzylabs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hivfuzzylabs.findAll", query = "SELECT h FROM Hivfuzzylabs h"),
    @NamedQuery(name = "Hivfuzzylabs.findById", query = "SELECT h FROM Hivfuzzylabs h WHERE h.id = :id"),
    @NamedQuery(name = "Hivfuzzylabs.findByPatientid", query = "SELECT h FROM Hivfuzzylabs h WHERE h.patientid = :patientid"),
    @NamedQuery(name = "Hivfuzzylabs.findByLabdate", query = "SELECT h FROM Hivfuzzylabs h WHERE h.labdate = :labdate"),
    @NamedQuery(name = "Hivfuzzylabs.findBySitecode", query = "SELECT h FROM Hivfuzzylabs h WHERE h.sitecode = :sitecode"),
    @NamedQuery(name = "Hivfuzzylabs.findByTestname", query = "SELECT h FROM Hivfuzzylabs h WHERE h.testname = :testname"),
    @NamedQuery(name = "Hivfuzzylabs.findByFuzzyclass", query = "SELECT h FROM Hivfuzzylabs h WHERE h.fuzzyclass = :fuzzyclass")})
public class Hivfuzzylabs implements Serializable {
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
    @Column(name = "labdate")
    @Temporal(TemporalType.DATE)
    private Date labdate;
    @Basic(optional = false)
    @Column(name = "sitecode")
    private int sitecode;
    @Basic(optional = false)
    @Column(name = "testname")
    private String testname;
    @Basic(optional = false)
    @Column(name = "fuzzyclass")
    private String fuzzyclass;

    public Hivfuzzylabs() {
    }

    public Hivfuzzylabs(Integer id) {
        this.id = id;
    }

    public Hivfuzzylabs(Integer id, String patientid, Date labdate, int sitecode, String testname, String fuzzyclass) {
        this.id = id;
        this.patientid = patientid;
        this.labdate = labdate;
        this.sitecode = sitecode;
        this.testname = testname;
        this.fuzzyclass = fuzzyclass;
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

    public Date getLabdate() {
        return labdate;
    }

    public void setLabdate(Date labdate) {
        this.labdate = labdate;
    }

    public int getSitecode() {
        return sitecode;
    }

    public void setSitecode(int sitecode) {
        this.sitecode = sitecode;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getFuzzyclass() {
        return fuzzyclass;
    }

    public void setFuzzyclass(String fuzzyclass) {
        this.fuzzyclass = fuzzyclass;
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
        if (!(object instanceof Hivfuzzylabs)) {
            return false;
        }
        Hivfuzzylabs other = (Hivfuzzylabs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.Hivfuzzylabs[ id=" + id + " ]";
    }
    
}
