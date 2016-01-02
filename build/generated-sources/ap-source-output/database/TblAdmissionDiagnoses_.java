package database;

import database.TblAdmissions;
import database.TblPatientDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-31T13:31:58")
@StaticMetamodel(TblAdmissionDiagnoses.class)
public class TblAdmissionDiagnoses_ { 

    public static volatile SingularAttribute<TblAdmissionDiagnoses, String> patientId;
    public static volatile SingularAttribute<TblAdmissionDiagnoses, Integer> admissionDiagnosisId;
    public static volatile SingularAttribute<TblAdmissionDiagnoses, String> dcode;
    public static volatile SingularAttribute<TblAdmissionDiagnoses, String> primaryDiagnosisDescription;
    public static volatile SingularAttribute<TblAdmissionDiagnoses, String> admissionId;
    public static volatile SingularAttribute<TblAdmissionDiagnoses, TblAdmissions> tblAdmissionsadmissionId;
    public static volatile SingularAttribute<TblAdmissionDiagnoses, String> tblICD10dcode;
    public static volatile SingularAttribute<TblAdmissionDiagnoses, TblPatientDetails> tblPatientDetailspatientId;

}