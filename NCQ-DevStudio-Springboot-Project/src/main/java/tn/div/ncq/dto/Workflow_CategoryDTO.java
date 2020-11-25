package tn.div.ncq.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Workflow_CategoryDTO implements Serializable {

    private Long idCategory;
    private Long idWorkflow;
    private WorkflowDTO workflow;
    private WorkflowCategoryDTO category;

    public Workflow_CategoryDTO() {
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdWorkflow() {
        return idWorkflow;
    }

    public void setIdWorkflow(Long idWorkflow) {
        this.idWorkflow = idWorkflow;
    }

    public WorkflowDTO getWorkflow() {
        return workflow;
    }

    public void setWorkflow(WorkflowDTO workflow) {
        this.workflow = workflow;
    }

    public WorkflowCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(WorkflowCategoryDTO category) {
        this.category = category;
    }

}
