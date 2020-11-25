package tn.div.ncq.factory;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.div.ncq.dto.WorkflowCategoryDTO;
import tn.div.ncq.entity.WorkflowCategory;
import tn.div.ncq.repository.WorkflowCategoryRepository;

@Service
public class WorkflowCategoryFactory {

    @Autowired
    WorkflowCategoryRepository categorieRepository;
    
    @Autowired
    Workflow_CategoryFactory workflow_CategoryFactory;

    public  WorkflowCategoryDTO workflowToWorkflowDTO(WorkflowCategory workflow) {               
            WorkflowCategoryDTO workflowDTO = new WorkflowCategoryDTO();
            if (workflow != null) {
            workflowDTO.setIdWorkflowCategory(workflow.getIdCategory());
            workflowDTO.setName(workflow.getName());
            workflowDTO.setDescription(workflow.getDescription());
            workflowDTO.setEnabled(workflow.isEnabled());

            if (workflow.getWcs() != null) {
                workflowDTO.setWcs(workflow_CategoryFactory.workflow_CategorysTOWorkflow_CategoryDTOs(workflow.getWcs()));
            }
            if (workflow.getCategorie() != null) {
                workflowDTO.setParentName(categorieRepository.findByName(workflow.getCategorie().getName()).getName());
                workflowDTO.setParentId(categorieRepository.findByName(workflow.getCategorie().getName()).getIdCategory());
            }
        } else {
            return null;
        }
        return workflowDTO;
    }

    public WorkflowCategory workflowCategoryDTOToWorkflowCategory(WorkflowCategoryDTO workflowDTO) {
        WorkflowCategory workflow = new WorkflowCategory();
        workflow.setIdCategory(workflowDTO.getIdWorkflowCategory());
        workflow.setName(workflowDTO.getName());
        System.out.println(workflowDTO.getName());
        workflow.setDescription(workflowDTO.getDescription());
        workflow.setEnabled(workflowDTO.isEnabled());
        if (workflowDTO.getParentId() != null) {
            workflow.setCategorie(categorieRepository.findById(workflowDTO.getParentId()).get());
        }
        return workflow;
    }

    public Collection<WorkflowCategoryDTO> workflowsToWorkflowDTOs(Collection<WorkflowCategory> workflows) {
        Collection<WorkflowCategoryDTO> workflowDTOs = new ArrayList<>();
        for (WorkflowCategory workflow : workflows) {
            WorkflowCategoryDTO workflowDTO = workflowToWorkflowDTO(workflow);
            workflowDTOs.add(workflowDTO);
        }
        return workflowDTOs;
    }

    public Collection<WorkflowCategory> workflowDTOsToworkFlows(Collection<WorkflowCategoryDTO> bonCommandeDTOs) {
        Collection<WorkflowCategory> wcs = new ArrayList<>();
        for (WorkflowCategoryDTO bonCommandeDTO : bonCommandeDTOs) {
            WorkflowCategory bonCommande = workflowCategoryDTOToWorkflowCategory(bonCommandeDTO);
            wcs.add(bonCommande);
        }
        return wcs;
    }
}
