package tn.div.ncq.service;

import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.div.ncq.dto.WorkflowCategoryDTO;
import tn.div.ncq.entity.WorkflowCategory;
import tn.div.ncq.factory.WorkflowCategoryFactory;
import tn.div.ncq.repository.WorkflowCategoryRepository;

@Service
@Transactional
public class WorkflowCategoryService {

    @Autowired
    WorkflowCategoryRepository workflowRepository;
    
    @Autowired
    WorkflowCategoryFactory WorkflowCategoryFactory;

    public void addWorkflow(WorkflowCategoryDTO workflowDTO) {
        WorkflowCategory workflow = WorkflowCategoryFactory.workflowCategoryDTOToWorkflowCategory(workflowDTO);
        workflowRepository.save(workflow);
    }

    public void addWorkflows(Collection<WorkflowCategoryDTO> WorkflowDTOs) {
        Collection<WorkflowCategory> Workflows = WorkflowCategoryFactory.workflowDTOsToworkFlows(WorkflowDTOs);
        workflowRepository.saveAll(Workflows);
    }

    public Collection<WorkflowCategoryDTO> FindWorkflows() {
        Collection<WorkflowCategory> Workflows = workflowRepository.findAll();
        return WorkflowCategoryFactory.workflowsToWorkflowDTOs(Workflows);
    }

    public WorkflowCategoryDTO getWorkflow(String name) {
        WorkflowCategory workflow = workflowRepository.findByName(name);
        return WorkflowCategoryFactory.workflowToWorkflowDTO(workflow);
    }

    public WorkflowCategoryDTO getWorkflow(long id) {
        WorkflowCategory workflow = workflowRepository.findById(id).get();
        return WorkflowCategoryFactory.workflowToWorkflowDTO(workflow);
    }

    public void updateWorkflowCategory(WorkflowCategoryDTO workflowDTO) {
        //vérification de l'existence de bonCommande
        WorkflowCategory workflowCategory = WorkflowCategoryFactory.workflowCategoryDTOToWorkflowCategory(workflowDTO);
        workflowRepository.save(workflowCategory);
    }

    public void deleteWorkflowCategory(Long numero) {
        workflowRepository.deleteById(numero);
    }
}
