/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.div.ncq.factory;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.div.ncq.dto.Workflow_CategoryDTO;
import tn.div.ncq.entity.Workflow_Category;
import tn.div.ncq.entity.Workflow_CategoryPK;

/**
 *
 * @author lenovo
 */
@Service
public class Workflow_CategoryFactory {
    
    @Autowired
    WorkflowCategoryFactory workflowCategoryFactory;

    public static Workflow_Category workflow_CategoryDTOTOWorkflow_Category(Workflow_CategoryDTO workflow_CategoryDTO) {
        Workflow_Category workflow_Category = new Workflow_Category();
        workflow_Category.setWorkflow_CategoryPK(new Workflow_CategoryPK(workflow_CategoryDTO.getIdWorkflow(), workflow_CategoryDTO.getIdCategory()));
        return workflow_Category;
    }

    public  Workflow_CategoryDTO workflow_CategoryTOWorkflow_CategoryDTO(Workflow_Category workflow_Category) {
        Workflow_CategoryDTO workflow_CategoryDTO = new Workflow_CategoryDTO();
        if (workflow_Category != null) {
            workflow_CategoryDTO.setIdCategory(workflow_Category.getWorkflow_CategoryPK().getIdWorkflowCategory());
            workflow_CategoryDTO.setIdWorkflow(workflow_Category.getWorkflow_CategoryPK().getIdWorkflow());
            if (workflow_Category.getWorkflow() != null && workflow_Category.getWorkflowCategory() != null) {
                workflow_CategoryDTO.setWorkflow(WorkflowFactory.workflowToWorkflowDTO(workflow_Category.getWorkflow()));
                workflow_CategoryDTO.setCategory(workflowCategoryFactory.workflowToWorkflowDTO(workflow_Category.getWorkflowCategory()));
            }
            return workflow_CategoryDTO;
        } else {
            return null;
        }
    }

    public  Collection<Workflow_CategoryDTO> workflow_CategorysTOWorkflow_CategoryDTOs(Collection<Workflow_Category> workflowCategories) {
        Collection<Workflow_CategoryDTO> ligneCommandeDTOs = new ArrayList<>();
        for (Workflow_Category workflow_category : workflowCategories) {            
            Workflow_CategoryDTO ligneCommandeDTO = workflow_CategoryTOWorkflow_CategoryDTO(workflow_category);
            ligneCommandeDTOs.add(ligneCommandeDTO);
        }
        return ligneCommandeDTOs;
    }

    public static Collection<Workflow_Category> workflow_CategoryDTOsTOWorkflow_Categories(Collection<Workflow_CategoryDTO> lignesCommandeDTOs) {
        Collection<Workflow_Category> lignesCommande = new ArrayList<>();
        for (Workflow_CategoryDTO ligneCommandeDTO : lignesCommandeDTOs) {
            Workflow_Category ligneCommande = workflow_CategoryDTOTOWorkflow_Category(ligneCommandeDTO);
            lignesCommande.add(ligneCommande);
        }
        return lignesCommande;
    }
}
