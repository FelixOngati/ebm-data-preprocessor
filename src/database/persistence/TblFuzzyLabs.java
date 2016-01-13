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
@Table(name = "tblFuzzyLabs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFuzzyLabs.findAll", query = "SELECT t FROM TblFuzzyLabs t"),
    @NamedQuery(name = "TblFuzzyLabs.findById", query = "SELECT t FROM TblFuzzyLabs t WHERE t.id = :id"),
    @NamedQuery(name = "TblFuzzyLabs.findByGender", query = "SELECT t FROM TblFuzzyLabs t WHERE t.gender = :gender"),
    @NamedQuery(name = "TblFuzzyLabs.findByAge", query = "SELECT t FROM TblFuzzyLabs t WHERE t.age = :age"),
    @NamedQuery(name = "TblFuzzyLabs.findByRace", query = "SELECT t FROM TblFuzzyLabs t WHERE t.race = :race"),
    @NamedQuery(name = "TblFuzzyLabs.findByMaritalStatus", query = "SELECT t FROM TblFuzzyLabs t WHERE t.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "TblFuzzyLabs.findByPovertyindex", query = "SELECT t FROM TblFuzzyLabs t WHERE t.povertyindex = :povertyindex"),
    @NamedQuery(name = "TblFuzzyLabs.findByUrinalysisRbc", query = "SELECT t FROM TblFuzzyLabs t WHERE t.urinalysisRbc = :urinalysisRbc"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicGlucose", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicGlucose = :metabolicGlucose"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicCalcium", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicCalcium = :metabolicCalcium"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcRbcCount", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcRbcCount = :cbcRbcCount"),
    @NamedQuery(name = "TblFuzzyLabs.findByUrinalysisPh", query = "SELECT t FROM TblFuzzyLabs t WHERE t.urinalysisPh = :urinalysisPh"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicTotalProtein", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicTotalProtein = :metabolicTotalProtein"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicChloride", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicChloride = :metabolicChloride"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcLymphocytes", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcLymphocytes = :cbcLymphocytes"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicSodium", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicSodium = :metabolicSodium"),
    @NamedQuery(name = "TblFuzzyLabs.findByUrinalysisSpecificGravity", query = "SELECT t FROM TblFuzzyLabs t WHERE t.urinalysisSpecificGravity = :urinalysisSpecificGravity"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicBiliTotal", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicBiliTotal = :metabolicBiliTotal"),
    @NamedQuery(name = "TblFuzzyLabs.findByUrinalysisWbc", query = "SELECT t FROM TblFuzzyLabs t WHERE t.urinalysisWbc = :urinalysisWbc"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcEosinophils", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcEosinophils = :cbcEosinophils"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicAlkPhos", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicAlkPhos = :metabolicAlkPhos"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcRdw", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcRdw = :cbcRdw"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicAstSgot", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicAstSgot = :metabolicAstSgot"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcNeutrophils", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcNeutrophils = :cbcNeutrophils"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcBasophils", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcBasophils = :cbcBasophils"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcMonocytes", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcMonocytes = :cbcMonocytes"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcMch", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcMch = :cbcMch"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicBun", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicBun = :metabolicBun"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcWbcCount", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcWbcCount = :cbcWbcCount"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcPlateletCount", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcPlateletCount = :cbcPlateletCount"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicPotassium", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicPotassium = :metabolicPotassium"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicAnionGap", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicAnionGap = :metabolicAnionGap"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcHematocrit", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcHematocrit = :cbcHematocrit"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicCreatinine", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicCreatinine = :metabolicCreatinine"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcHemoglobin", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcHemoglobin = :cbcHemoglobin"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcAbsoluteLymphocytes", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcAbsoluteLymphocytes = :cbcAbsoluteLymphocytes"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicCarbonDioxide", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicCarbonDioxide = :metabolicCarbonDioxide"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcAbsoluteNeutrophils", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcAbsoluteNeutrophils = :cbcAbsoluteNeutrophils"),
    @NamedQuery(name = "TblFuzzyLabs.findByMetabolicAlbumin", query = "SELECT t FROM TblFuzzyLabs t WHERE t.metabolicAlbumin = :metabolicAlbumin"),
    @NamedQuery(name = "TblFuzzyLabs.findByCbcMchc", query = "SELECT t FROM TblFuzzyLabs t WHERE t.cbcMchc = :cbcMchc")})
public class TblFuzzyLabs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @Column(name = "race")
    private String race;
    @Basic(optional = false)
    @Column(name = "marital_status")
    private String maritalStatus;
    @Basic(optional = false)
    @Column(name = "povertyindex")
    private double povertyindex;
    @Basic(optional = false)
    @Column(name = "urinalysis_rbc")
    private String urinalysisRbc;
    @Basic(optional = false)
    @Column(name = "metabolic_glucose")
    private String metabolicGlucose;
    @Basic(optional = false)
    @Column(name = "metabolic_calcium")
    private String metabolicCalcium;
    @Basic(optional = false)
    @Column(name = "cbc_rbc_count")
    private String cbcRbcCount;
    @Basic(optional = false)
    @Column(name = "urinalysis_ph")
    private String urinalysisPh;
    @Basic(optional = false)
    @Column(name = "metabolic_total_protein")
    private String metabolicTotalProtein;
    @Basic(optional = false)
    @Column(name = "metabolic_chloride")
    private String metabolicChloride;
    @Basic(optional = false)
    @Column(name = "cbc_lymphocytes")
    private String cbcLymphocytes;
    @Basic(optional = false)
    @Column(name = "metabolic_sodium")
    private String metabolicSodium;
    @Basic(optional = false)
    @Column(name = "urinalysis_specific_gravity")
    private String urinalysisSpecificGravity;
    @Basic(optional = false)
    @Column(name = "metabolic_bili_total")
    private String metabolicBiliTotal;
    @Basic(optional = false)
    @Column(name = "urinalysis_wbc")
    private String urinalysisWbc;
    @Basic(optional = false)
    @Column(name = "cbc_eosinophils")
    private String cbcEosinophils;
    @Basic(optional = false)
    @Column(name = "metabolic_alk_phos")
    private String metabolicAlkPhos;
    @Basic(optional = false)
    @Column(name = "cbc_rdw")
    private String cbcRdw;
    @Basic(optional = false)
    @Column(name = "metabolic_ast_sgot")
    private String metabolicAstSgot;
    @Basic(optional = false)
    @Column(name = "cbc_neutrophils")
    private String cbcNeutrophils;
    @Basic(optional = false)
    @Column(name = "cbc_basophils")
    private String cbcBasophils;
    @Basic(optional = false)
    @Column(name = "cbc_monocytes")
    private String cbcMonocytes;
    @Basic(optional = false)
    @Column(name = "cbc_mch")
    private String cbcMch;
    @Basic(optional = false)
    @Column(name = "metabolic_bun")
    private String metabolicBun;
    @Basic(optional = false)
    @Column(name = "cbc_wbc_count")
    private String cbcWbcCount;
    @Basic(optional = false)
    @Column(name = "cbc_platelet_count")
    private String cbcPlateletCount;
    @Basic(optional = false)
    @Column(name = "metabolic_potassium")
    private String metabolicPotassium;
    @Basic(optional = false)
    @Column(name = "metabolic_anion_gap")
    private String metabolicAnionGap;
    @Basic(optional = false)
    @Column(name = "cbc_hematocrit")
    private String cbcHematocrit;
    @Basic(optional = false)
    @Column(name = "metabolic_creatinine")
    private String metabolicCreatinine;
    @Basic(optional = false)
    @Column(name = "cbc_hemoglobin")
    private String cbcHemoglobin;
    @Basic(optional = false)
    @Column(name = "cbc_absolute_lymphocytes")
    private String cbcAbsoluteLymphocytes;
    @Basic(optional = false)
    @Column(name = "metabolic_carbon_dioxide")
    private String metabolicCarbonDioxide;
    @Basic(optional = false)
    @Column(name = "cbc_absolute_neutrophils")
    private String cbcAbsoluteNeutrophils;
    @Basic(optional = false)
    @Column(name = "metabolic_albumin")
    private String metabolicAlbumin;
    @Basic(optional = false)
    @Column(name = "cbc_mchc")
    private String cbcMchc;

    public TblFuzzyLabs() {
    }

    public TblFuzzyLabs(Integer id) {
        this.id = id;
    }

    public TblFuzzyLabs(Integer id, String gender, int age, String race, String maritalStatus, double povertyindex, String urinalysisRbc, String metabolicGlucose, String metabolicCalcium, String cbcRbcCount, String urinalysisPh, String metabolicTotalProtein, String metabolicChloride, String cbcLymphocytes, String metabolicSodium, String urinalysisSpecificGravity, String metabolicBiliTotal, String urinalysisWbc, String cbcEosinophils, String metabolicAlkPhos, String cbcRdw, String metabolicAstSgot, String cbcNeutrophils, String cbcBasophils, String cbcMonocytes, String cbcMch, String metabolicBun, String cbcWbcCount, String cbcPlateletCount, String metabolicPotassium, String metabolicAnionGap, String cbcHematocrit, String metabolicCreatinine, String cbcHemoglobin, String cbcAbsoluteLymphocytes, String metabolicCarbonDioxide, String cbcAbsoluteNeutrophils, String metabolicAlbumin, String cbcMchc) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.race = race;
        this.maritalStatus = maritalStatus;
        this.povertyindex = povertyindex;
        this.urinalysisRbc = urinalysisRbc;
        this.metabolicGlucose = metabolicGlucose;
        this.metabolicCalcium = metabolicCalcium;
        this.cbcRbcCount = cbcRbcCount;
        this.urinalysisPh = urinalysisPh;
        this.metabolicTotalProtein = metabolicTotalProtein;
        this.metabolicChloride = metabolicChloride;
        this.cbcLymphocytes = cbcLymphocytes;
        this.metabolicSodium = metabolicSodium;
        this.urinalysisSpecificGravity = urinalysisSpecificGravity;
        this.metabolicBiliTotal = metabolicBiliTotal;
        this.urinalysisWbc = urinalysisWbc;
        this.cbcEosinophils = cbcEosinophils;
        this.metabolicAlkPhos = metabolicAlkPhos;
        this.cbcRdw = cbcRdw;
        this.metabolicAstSgot = metabolicAstSgot;
        this.cbcNeutrophils = cbcNeutrophils;
        this.cbcBasophils = cbcBasophils;
        this.cbcMonocytes = cbcMonocytes;
        this.cbcMch = cbcMch;
        this.metabolicBun = metabolicBun;
        this.cbcWbcCount = cbcWbcCount;
        this.cbcPlateletCount = cbcPlateletCount;
        this.metabolicPotassium = metabolicPotassium;
        this.metabolicAnionGap = metabolicAnionGap;
        this.cbcHematocrit = cbcHematocrit;
        this.metabolicCreatinine = metabolicCreatinine;
        this.cbcHemoglobin = cbcHemoglobin;
        this.cbcAbsoluteLymphocytes = cbcAbsoluteLymphocytes;
        this.metabolicCarbonDioxide = metabolicCarbonDioxide;
        this.cbcAbsoluteNeutrophils = cbcAbsoluteNeutrophils;
        this.metabolicAlbumin = metabolicAlbumin;
        this.cbcMchc = cbcMchc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public double getPovertyindex() {
        return povertyindex;
    }

    public void setPovertyindex(double povertyindex) {
        this.povertyindex = povertyindex;
    }

    public String getUrinalysisRbc() {
        return urinalysisRbc;
    }

    public void setUrinalysisRbc(String urinalysisRbc) {
        this.urinalysisRbc = urinalysisRbc;
    }

    public String getMetabolicGlucose() {
        return metabolicGlucose;
    }

    public void setMetabolicGlucose(String metabolicGlucose) {
        this.metabolicGlucose = metabolicGlucose;
    }

    public String getMetabolicCalcium() {
        return metabolicCalcium;
    }

    public void setMetabolicCalcium(String metabolicCalcium) {
        this.metabolicCalcium = metabolicCalcium;
    }

    public String getCbcRbcCount() {
        return cbcRbcCount;
    }

    public void setCbcRbcCount(String cbcRbcCount) {
        this.cbcRbcCount = cbcRbcCount;
    }

    public String getUrinalysisPh() {
        return urinalysisPh;
    }

    public void setUrinalysisPh(String urinalysisPh) {
        this.urinalysisPh = urinalysisPh;
    }

    public String getMetabolicTotalProtein() {
        return metabolicTotalProtein;
    }

    public void setMetabolicTotalProtein(String metabolicTotalProtein) {
        this.metabolicTotalProtein = metabolicTotalProtein;
    }

    public String getMetabolicChloride() {
        return metabolicChloride;
    }

    public void setMetabolicChloride(String metabolicChloride) {
        this.metabolicChloride = metabolicChloride;
    }

    public String getCbcLymphocytes() {
        return cbcLymphocytes;
    }

    public void setCbcLymphocytes(String cbcLymphocytes) {
        this.cbcLymphocytes = cbcLymphocytes;
    }

    public String getMetabolicSodium() {
        return metabolicSodium;
    }

    public void setMetabolicSodium(String metabolicSodium) {
        this.metabolicSodium = metabolicSodium;
    }

    public String getUrinalysisSpecificGravity() {
        return urinalysisSpecificGravity;
    }

    public void setUrinalysisSpecificGravity(String urinalysisSpecificGravity) {
        this.urinalysisSpecificGravity = urinalysisSpecificGravity;
    }

    public String getMetabolicBiliTotal() {
        return metabolicBiliTotal;
    }

    public void setMetabolicBiliTotal(String metabolicBiliTotal) {
        this.metabolicBiliTotal = metabolicBiliTotal;
    }

    public String getUrinalysisWbc() {
        return urinalysisWbc;
    }

    public void setUrinalysisWbc(String urinalysisWbc) {
        this.urinalysisWbc = urinalysisWbc;
    }

    public String getCbcEosinophils() {
        return cbcEosinophils;
    }

    public void setCbcEosinophils(String cbcEosinophils) {
        this.cbcEosinophils = cbcEosinophils;
    }

    public String getMetabolicAlkPhos() {
        return metabolicAlkPhos;
    }

    public void setMetabolicAlkPhos(String metabolicAlkPhos) {
        this.metabolicAlkPhos = metabolicAlkPhos;
    }

    public String getCbcRdw() {
        return cbcRdw;
    }

    public void setCbcRdw(String cbcRdw) {
        this.cbcRdw = cbcRdw;
    }

    public String getMetabolicAstSgot() {
        return metabolicAstSgot;
    }

    public void setMetabolicAstSgot(String metabolicAstSgot) {
        this.metabolicAstSgot = metabolicAstSgot;
    }

    public String getCbcNeutrophils() {
        return cbcNeutrophils;
    }

    public void setCbcNeutrophils(String cbcNeutrophils) {
        this.cbcNeutrophils = cbcNeutrophils;
    }

    public String getCbcBasophils() {
        return cbcBasophils;
    }

    public void setCbcBasophils(String cbcBasophils) {
        this.cbcBasophils = cbcBasophils;
    }

    public String getCbcMonocytes() {
        return cbcMonocytes;
    }

    public void setCbcMonocytes(String cbcMonocytes) {
        this.cbcMonocytes = cbcMonocytes;
    }

    public String getCbcMch() {
        return cbcMch;
    }

    public void setCbcMch(String cbcMch) {
        this.cbcMch = cbcMch;
    }

    public String getMetabolicBun() {
        return metabolicBun;
    }

    public void setMetabolicBun(String metabolicBun) {
        this.metabolicBun = metabolicBun;
    }

    public String getCbcWbcCount() {
        return cbcWbcCount;
    }

    public void setCbcWbcCount(String cbcWbcCount) {
        this.cbcWbcCount = cbcWbcCount;
    }

    public String getCbcPlateletCount() {
        return cbcPlateletCount;
    }

    public void setCbcPlateletCount(String cbcPlateletCount) {
        this.cbcPlateletCount = cbcPlateletCount;
    }

    public String getMetabolicPotassium() {
        return metabolicPotassium;
    }

    public void setMetabolicPotassium(String metabolicPotassium) {
        this.metabolicPotassium = metabolicPotassium;
    }

    public String getMetabolicAnionGap() {
        return metabolicAnionGap;
    }

    public void setMetabolicAnionGap(String metabolicAnionGap) {
        this.metabolicAnionGap = metabolicAnionGap;
    }

    public String getCbcHematocrit() {
        return cbcHematocrit;
    }

    public void setCbcHematocrit(String cbcHematocrit) {
        this.cbcHematocrit = cbcHematocrit;
    }

    public String getMetabolicCreatinine() {
        return metabolicCreatinine;
    }

    public void setMetabolicCreatinine(String metabolicCreatinine) {
        this.metabolicCreatinine = metabolicCreatinine;
    }

    public String getCbcHemoglobin() {
        return cbcHemoglobin;
    }

    public void setCbcHemoglobin(String cbcHemoglobin) {
        this.cbcHemoglobin = cbcHemoglobin;
    }

    public String getCbcAbsoluteLymphocytes() {
        return cbcAbsoluteLymphocytes;
    }

    public void setCbcAbsoluteLymphocytes(String cbcAbsoluteLymphocytes) {
        this.cbcAbsoluteLymphocytes = cbcAbsoluteLymphocytes;
    }

    public String getMetabolicCarbonDioxide() {
        return metabolicCarbonDioxide;
    }

    public void setMetabolicCarbonDioxide(String metabolicCarbonDioxide) {
        this.metabolicCarbonDioxide = metabolicCarbonDioxide;
    }

    public String getCbcAbsoluteNeutrophils() {
        return cbcAbsoluteNeutrophils;
    }

    public void setCbcAbsoluteNeutrophils(String cbcAbsoluteNeutrophils) {
        this.cbcAbsoluteNeutrophils = cbcAbsoluteNeutrophils;
    }

    public String getMetabolicAlbumin() {
        return metabolicAlbumin;
    }

    public void setMetabolicAlbumin(String metabolicAlbumin) {
        this.metabolicAlbumin = metabolicAlbumin;
    }

    public String getCbcMchc() {
        return cbcMchc;
    }

    public void setCbcMchc(String cbcMchc) {
        this.cbcMchc = cbcMchc;
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
        if (!(object instanceof TblFuzzyLabs)) {
            return false;
        }
        TblFuzzyLabs other = (TblFuzzyLabs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.TblFuzzyLabs[ id=" + id + " ]";
    }
    
}
