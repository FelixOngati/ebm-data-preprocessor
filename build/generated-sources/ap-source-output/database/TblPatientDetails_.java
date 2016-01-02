package database;

import database.TblAdmissionDiagnoses;
import database.TblAdmissions;
import database.TblLabs;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-31T13:31:58")
@StaticMetamodel(TblPatientDetails.class)
public class TblPatientDetails_ { 

    public static volatile SingularAttribute<TblPatientDetails, String> patientId;
    public static volatile SingularAttribute<TblPatientDetails, Date> patientDOB;
    public static volatile CollectionAttribute<TblPatientDetails, TblLabs> tblLabsCollection;
    public static volatile CollectionAttribute<TblPatientDetails, TblAdmissionDiagnoses> tblAdmissionDiagnosesCollection;
    public static volatile SingularAttribute<TblPatientDetails, String> patientGender;
    public static volatile SingularAttribute<TblPatientDetails, String> patientRace;
    public static volatile CollectionAttribute<TblPatientDetails, TblAdmissions> tblAdmissionsCollection;
    public static volatile SingularAttribute<TblPatientDetails, String> patientMaritalStatus;
    public static volatile SingularAttribute<TblPatientDetails, String> patientLanguage;
    public static volatile SingularAttribute<TblPatientDetails, String> patientPopulationPercentageBelowPoverty;

}