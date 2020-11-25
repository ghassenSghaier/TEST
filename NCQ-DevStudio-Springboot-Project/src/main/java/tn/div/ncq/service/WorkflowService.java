package tn.div.ncq.service;
import java.util.ArrayList;
import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.div.ncq.dto.WorkflowDTO;
import tn.div.ncq.dto.Workflow_CategoryDTO;
import tn.div.ncq.entity.Workflow;
import tn.div.ncq.entity.WorkflowCategory;
import tn.div.ncq.entity.Workflow_Category;
import tn.div.ncq.factory.WorkflowFactory;
import tn.div.ncq.factory.Workflow_CategoryFactory;
import tn.div.ncq.repository.WorkflowRepository;

@Service
@Transactional
public class WorkflowService {

    @Autowired
    WorkflowRepository workflowRepository;
    
    @Autowired
    Workflow_CategoryService wcService;

    public void addWorkflow(WorkflowDTO workflowDTO) {
        Workflow workflow = WorkflowFactory.workflowDTOToWorkflow(workflowDTO);
        workflowRepository.save(workflow);
    }

    public void addWorkflows(Collection<WorkflowDTO> WorkflowDTOs) {
        Collection<Workflow> Workflows = WorkflowFactory.workflowsDTOsToWorkflowDTO(WorkflowDTOs);
        workflowRepository.saveAll(Workflows);
    }

    public Collection<WorkflowDTO> FindWorkflows() {
        Collection<Workflow> Workflows = workflowRepository.findAll();
        return WorkflowFactory.workflowsToWorkflowDTOs(Workflows);
    }

    public WorkflowDTO getWorkflow(String name) {
        Workflow workflow = workflowRepository.findByName(name);
        return WorkflowFactory.workflowToWorkflowDTO(workflow);
    }
    public Collection<WorkflowDTO> getWorkflowByCategory(Long idCategory) {
        Collection<Workflow_CategoryDTO> wcDTOs= wcService.getWorkflow(idCategory); 
        Collection<Workflow_Category> w_cs = Workflow_CategoryFactory.workflow_CategoryDTOsTOWorkflow_Categories(wcDTOs);
        Collection<Workflow> wcs = new ArrayList<>();
        for(Workflow_Category wc : w_cs){
            wcs.add(wc.getWorkflow());
        }
        return WorkflowFactory.workflowsToWorkflowDTOs(wcs);
    }

    public WorkflowDTO getWorkflow(Long id) {
        Workflow workflow = workflowRepository.findById(id).get();
        return WorkflowFactory.workflowToWorkflowDTO(workflow);
    }
    
    public Collection<WorkflowDTO> getWorkflow(int status) {
        Collection<Workflow> workflows = workflowRepository.findByStatus(status);
        return WorkflowFactory.workflowsToWorkflowDTOs(workflows);
    }

    public void updateWorkflow(WorkflowDTO workflowDTO) {
        //vérification de l'existence de bonCommande
        Workflow workflow = WorkflowFactory.workflowDTOToWorkflow(workflowDTO);
        workflowRepository.save(workflow);
    }

    public void deleteWorkflow(Long numero) {
        workflowRepository.deleteById(numero);
    }
}
