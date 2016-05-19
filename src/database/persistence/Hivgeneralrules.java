/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author the_fegati
 */
@Entity
@Table(name = "hivgeneralrules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hivgeneralrules.findAll", query = "SELECT h FROM Hivgeneralrules h"),
    @NamedQuery(name = "Hivgeneralrules.findByRuleId", query = "SELECT h FROM Hivgeneralrules h WHERE h.ruleId = :ruleId"),
    @NamedQuery(name = "Hivgeneralrules.findByRule", query = "SELECT h FROM Hivgeneralrules h WHERE h.rule = :rule"),
    @NamedQuery(name = "Hivgeneralrules.findByConfidence", query = "SELECT h FROM Hivgeneralrules h WHERE h.confidence = :confidence"),
    @NamedQuery(name = "Hivgeneralrules.findBySupport", query = "SELECT h FROM Hivgeneralrules h WHERE h.support = :support"),
    @NamedQuery(name = "Hivgeneralrules.findByRating", query = "SELECT h FROM Hivgeneralrules h WHERE h.rating = :rating")})
public class Hivgeneralrules implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rule_id")
    private Integer ruleId;
    @Basic(optional = false)
    @Column(name = "rule")
    private String rule;
    @Basic(optional = false)
    @Column(name = "confidence")
    private double confidence;
    @Basic(optional = false)
    @Column(name = "support")
    private double support;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private Float rating;

    public Hivgeneralrules() {
    }

    public Hivgeneralrules(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Hivgeneralrules(Integer ruleId, String rule, double confidence, double support) {
        this.ruleId = ruleId;
        this.rule = rule;
        this.confidence = confidence;
        this.support = support;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public double getSupport() {
        return support;
    }

    public void setSupport(double support) {
        this.support = support;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruleId != null ? ruleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hivgeneralrules)) {
            return false;
        }
        Hivgeneralrules other = (Hivgeneralrules) object;
        if ((this.ruleId == null && other.ruleId != null) || (this.ruleId != null && !this.ruleId.equals(other.ruleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.Hivgeneralrules[ ruleId=" + ruleId + " ]";
    }
    
}
