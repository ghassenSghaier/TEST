package tn.div.ncq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "workflow")
public class Workflow implements Serializable {

    @Id
    @NotNull
    @Column(name = "workflow_id")
    private Long IdWorkflow;
    @Column(name = "workflow_name", unique = true)
    private String name;
    @Column(name = "workflow_description")
    private String Description;
    @Column(name = "workflow_status")
    @Enumerated(EnumType.ORDINAL)
    private StatutEnum status;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workflow", fetch = FetchType.LAZY)
    private Collection<Workflow_Category> wcs;
    @ManyToMany
    @JoinTable(name = "T_Workflow_Workflow_Associations",
            joinColumns = @JoinColumn(name = "workflow_id"),
            inverseJoinColumns = @JoinColumn(name = "wc_id"))
    private Collection<Workflow> workflows;

    public Long getIdWorkflow() {
        return IdWorkflow;
    }

    public void setIdWorkflow(Long idWorkflow) {
        IdWorkflow = idWorkflow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public StatutEnum getStatus() {
        return status;
    }

    public void setStatus(StatutEnum status) {
        this.status = status;
    }

    public Collection<Workflow_Category> getWcs() {
        return wcs;
    }

    public void setWcs(Collection<Workflow_Category> wcs) {
        this.wcs = wcs;
    }

    public Collection<Workflow> getWorkflows() {
        return workflows;
    }

    public void setWorkflows(Collection<Workflow> workflows) {
        this.workflows = workflows;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.IdWorkflow);
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
        final Workflow other = (Workflow) obj;
        if (!Objects.equals(this.IdWorkflow, other.IdWorkflow)) {
            return false;
        }
        return true;
    }

}
