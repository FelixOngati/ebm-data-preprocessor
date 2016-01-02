package database;

import database.TblAdmissionDiagnoses;
import database.TblLabs;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-31T13:31:58")
@StaticMetamodel(TblAdmissions.class)
public class TblAdmissions_ { 

    public static volatile SingularAttribute<TblAdmissions, String> patientId;
    public static volatile CollectionAttribute<TblAdmissions, TblLabs> tblLabsCollection;
    public static volatile SingularAttribute<TblAdmissions, Date> admissionStartDate;
    public static volatile CollectionAttribute<TblAdmissions, TblAdmissionDiagnoses> tblAdmissionDiagnosesCollection;
    public static volatile SingularAttribute<TblAdmissions, String> admissionId;
    public static volatile SingularAttribute<TblAdmissions, Date> admissionEndDate;

}