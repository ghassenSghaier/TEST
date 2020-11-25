
package tn.div.ncq.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Workflow_CategoryPK implements Serializable {

    @Column(name = "workflow_id")
    private Long idWorkflow;

    @Column(name = "category_id")
    private Long idWorkflowCategory;

    public Workflow_CategoryPK() {
    }

    public Workflow_CategoryPK(Long idWorkflow, Long idWorkflowCategory) {
        this.idWorkflow = idWorkflow;
        this.idWorkflowCategory = idWorkflowCategory;
    }

    public Long getIdWorkflow() {
        return idWorkflow;
    }

    public void setIdWorkflow(Long idWorkflow) {
        this.idWorkflow = idWorkflow;
    }

    public Long getIdWorkflowCategory() {
        return idWorkflowCategory;
    }

    public void setIdWorkflowCategory(Long idWorkflowCategory) {
        this.idWorkflowCategory = idWorkflowCategory;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idWorkflow);
        hash = 71 * hash + Objects.hashCode(this.idWorkflowCategory);
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
        final Workflow_CategoryPK other = (Workflow_CategoryPK) obj;
        if (!Objects.equals(this.idWorkflow, other.idWorkflow)) {
            return false;
        }
        if (!Objects.equals(this.idWorkflowCategory, other.idWorkflowCategory)) {
            return false;
        }
        return true;
    }

}
