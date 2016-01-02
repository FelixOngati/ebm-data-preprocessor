package database;

import database.TblAdmissions;
import database.TblPatientDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-31T13:31:58")
@StaticMetamodel(TblLabs.class)
public class TblLabs_ { 

    public static volatile SingularAttribute<TblLabs, String> patientId;
    public static volatile SingularAttribute<TblLabs, Double> labValue;
    public static volatile SingularAttribute<TblLabs, String> admissionId;
    public static volatile SingularAttribute<TblLabs, String> labName;
    public static volatile SingularAttribute<TblLabs, Date> labDateTime;
    public static volatile SingularAttribute<TblLabs, Integer> labId;
    public static volatile SingularAttribute<TblLabs, TblAdmissions> tblAdmissionsadmissionId;
    public static volatile SingularAttribute<TblLabs, TblPatientDetails> tblPatientDetailspatientId;
    public static volatile SingularAttribute<TblLabs, String> labUnits;

}