package tn.div.ncq.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tn.div.ncq.entity.StatutEnum;
import tn.div.ncq.entity.Workflow;
import tn.div.ncq.entity.Workflow_Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-23T02:41:54")
@StaticMetamodel(Workflow.class)
public class Workflow_ { 

    public static volatile SingularAttribute<Workflow, String> Description;
    public static volatile CollectionAttribute<Workflow, Workflow_Category> wcs;
    public static volatile SingularAttribute<Workflow, Long> IdWorkflow;
    public static volatile SingularAttribute<Workflow, String> name;
    public static volatile CollectionAttribute<Workflow, Workflow> workflows;
    public static volatile SingularAttribute<Workflow, StatutEnum> status;

}