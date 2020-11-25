package tn.div.ncq.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import tn.div.ncq.entity.StatutEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkflowDTO implements Serializable {

    private Long idWorkflow;
    private String name;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private StatutEnum status;
    private Collection<Workflow_CategoryDTO> wcs;
    private Collection<WorkflowDTO> workflows;

    public WorkflowDTO(Long IdWorkflow) {
        this.idWorkflow = IdWorkflow;
    }

    public WorkflowDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public StatutEnum getStatus() {
        return status;
    }

    public void setStatus(StatutEnum status) {
        this.status = status;
    }

    public Long getIdWorkflow() {
        return idWorkflow;
    }

    public void setIdWorkflow(Long IdWorkflow) {
        this.idWorkflow = IdWorkflow;
    }

    public Collection<Workflow_CategoryDTO> getWcs() {
        return wcs;
    }

    public void setWcs(Collection<Workflow_CategoryDTO> wcs) {
        this.wcs = wcs;
    }

    public Collection<WorkflowDTO> getWorkflows() {
        return workflows;
    }

    public void setWorkflows(Collection<WorkflowDTO> workflows) {
        this.workflows = workflows;
    }
}
