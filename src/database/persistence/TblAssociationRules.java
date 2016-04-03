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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author the_fegati
 */
@Entity
@Table(name = "tbl_association_rules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAssociationRules.findAll", query = "SELECT t FROM TblAssociationRules t"),
    @NamedQuery(name = "TblAssociationRules.findByRuleId", query = "SELECT t FROM TblAssociationRules t WHERE t.ruleId = :ruleId"),
    @NamedQuery(name = "TblAssociationRules.findByConfidence", query = "SELECT t FROM TblAssociationRules t WHERE t.confidence = :confidence"),
    @NamedQuery(name = "TblAssociationRules.findByRating", query = "SELECT t FROM TblAssociationRules t WHERE t.rating = :rating"),
    @NamedQuery(name = "TblAssociationRules.findBySupport", query = "SELECT t FROM TblAssociationRules t WHERE t.support = :support")})
public class TblAssociationRules implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rule_id")
    private Integer ruleId;
    @Basic(optional = false)
    @Column(name = "confidence")
    private float confidence;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private Float rating;
    @Basic(optional = false)
    @Lob
    @Column(name = "rule")
    private String rule;
    @Basic(optional = false)
    @Column(name = "support")
    private float support;

    public TblAssociationRules() {
    }

    public TblAssociationRules(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public TblAssociationRules(Integer ruleId, float confidence, String rule, float support) {
        this.ruleId = ruleId;
        this.confidence = confidence;
        this.rule = rule;
        this.support = support;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public float getSupport() {
        return support;
    }

    public void setSupport(float support) {
        this.support = support;
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
        if (!(object instanceof TblAssociationRules)) {
            return false;
        }
        TblAssociationRules other = (TblAssociationRules) object;
        if ((this.ruleId == null && other.ruleId != null) || (this.ruleId != null && !this.ruleId.equals(other.ruleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.TblAssociationRules[ ruleId=" + ruleId + " ]";
    }
    
}
