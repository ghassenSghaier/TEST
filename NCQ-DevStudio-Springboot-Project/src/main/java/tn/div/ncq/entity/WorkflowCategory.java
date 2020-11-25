package tn.div.ncq.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "workflowcategory")

public class WorkflowCategory implements Serializable {

    @Id
    @NotNull
    @Column(name = "category_id")
    private Long idCategory;

    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String Description;
    @Column(name = "category_logo")
    private String Logo;
    @Column(name = "category_creation_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createAt;
    @Column(name = "category_update_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updateAt;
    @Column(name = "category_enabled")
    private boolean enabled;
    @JsonBackReference
    @JoinColumn(name = "parent_id", referencedColumnName = "category_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private WorkflowCategory categorie;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "WorkflowCategory", fetch = FetchType.LAZY)
    private Collection<Workflow_Category> wcs;

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
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

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public WorkflowCategory getCategorie() {
        return categorie;
    }

    public void setCategorie(WorkflowCategory categorie) {
        this.categorie = categorie;
    }

    public Collection<Workflow_Category> getWcs() {
        return wcs;
    }

    public void setWcs(Collection<Workflow_Category> WCs) {
        this.wcs = WCs;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idCategory);
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
        final WorkflowCategory other = (WorkflowCategory) obj;
        if (!Objects.equals(this.idCategory, other.idCategory)) {
            return false;
        }
        return true;
    }

}
