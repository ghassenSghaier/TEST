package tn.div.ncq.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workflow_category")
public class Workflow_Category implements Serializable {

    @EmbeddedId
    protected Workflow_CategoryPK workflow_CategoryPK;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_id", referencedColumnName = "workflow_id", insertable = false, updatable = false)
    private Workflow workflow;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private WorkflowCategory WorkflowCategory;

    public Workflow_CategoryPK getWorkflow_CategoryPK() {
        return workflow_CategoryPK;
    }

    public void setWorkflow_CategoryPK(Workflow_CategoryPK workflow_CategoryPK) {
        this.workflow_CategoryPK = workflow_CategoryPK;
    }

    public WorkflowCategory getWorkflowCategory() {
        return WorkflowCategory;
    }

    public void setWorkflowCategory(WorkflowCategory WorkflowCategory) {
        this.WorkflowCategory = WorkflowCategory;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.workflow_CategoryPK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Workflow_Category other = (Workflow_Category) obj;
        if (!Objects.equals(this.workflow_CategoryPK, other.workflow_CategoryPK)) {
            return false;
        }
        return true;
    }
    
    
    

}
