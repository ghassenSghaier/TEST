package tn.div.ncq.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tn.div.ncq.entity.WorkflowCategory;
import tn.div.ncq.entity.Workflow_Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-23T02:41:54")
@StaticMetamodel(WorkflowCategory.class)
public class WorkflowCategory_ { 

    public static volatile SingularAttribute<WorkflowCategory, String> Description;
    public static volatile SingularAttribute<WorkflowCategory, WorkflowCategory> categorie;
    public static volatile CollectionAttribute<WorkflowCategory, Workflow_Category> wcs;
    public static volatile SingularAttribute<WorkflowCategory, String> name;
    public static volatile SingularAttribute<WorkflowCategory, Date> updateAt;
    public static volatile SingularAttribute<WorkflowCategory, Long> idCategory;
    public static volatile SingularAttribute<WorkflowCategory, Date> createAt;
    public static volatile SingularAttribute<WorkflowCategory, Boolean> enabled;
    public static volatile SingularAttribute<WorkflowCategory, String> Logo;

}