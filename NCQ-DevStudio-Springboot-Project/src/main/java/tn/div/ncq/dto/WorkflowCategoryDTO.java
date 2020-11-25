package tn.div.ncq.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkflowCategoryDTO implements Serializable {

    private Long idWorkflowCategory;
    private String name;
    private String description;
    private String logo;
    private Date createdAt;
    private Date updatedAt;
    private boolean enabled;
    private Long parentId;
    private String parentName;
    private Collection<Workflow_CategoryDTO> wcs;

    public WorkflowCategoryDTO(Long IdWorkflowCategory) {
        this.idWorkflowCategory = IdWorkflowCategory;
    }

    public WorkflowCategoryDTO() {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getIdWorkflowCategory() {
        return idWorkflowCategory;
    }

    public void setIdWorkflowCategory(Long IdWorkflowCategory) {
        this.idWorkflowCategory = IdWorkflowCategory;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String Logo) {
        this.logo = Logo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Collection<Workflow_CategoryDTO> getWcs() {
        return wcs;
    }

    public void setWcs(Collection<Workflow_CategoryDTO> wcs) {
        this.wcs = wcs;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

}
