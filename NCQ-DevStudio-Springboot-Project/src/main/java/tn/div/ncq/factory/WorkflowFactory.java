package tn.div.ncq.factory;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.div.ncq.dto.WorkflowDTO;
import tn.div.ncq.entity.Workflow;
import tn.div.ncq.repository.WorkflowRepository;

@Service
public class WorkflowFactory {

    @Autowired
    WorkflowRepository categorieRepository;

    public static WorkflowDTO workflowToWorkflowDTO(Workflow workflow) {
        WorkflowDTO workflowDTO = new WorkflowDTO();
        workflowDTO.setIdWorkflow(workflow.getIdWorkflow());
        workflowDTO.setName(workflow.getName());
        workflowDTO.setDescription(workflow.getDescription());
        workflowDTO.setStatus(workflow.getStatus());
        return workflowDTO;

    }

    public static Workflow workflowDTOToWorkflow(WorkflowDTO workflowDTO) {
        Workflow workflow = new Workflow();
        workflow.setIdWorkflow(workflowDTO.getIdWorkflow());
        workflow.setName(workflowDTO.getName());
        workflow.setDescription(workflowDTO.getDescription());
        workflowDTO.setStatus(workflow.getStatus());
        return workflow;
    }

    public static Collection<WorkflowDTO> workflowsToWorkflowDTOs(Collection<Workflow> workflows) {
        Collection<WorkflowDTO> workflowDTOs = new ArrayList<>();
        for (Workflow workflow : workflows) {
            WorkflowDTO workflowDTO = workflowToWorkflowDTO(workflow);
            workflowDTOs.add(workflowDTO);
        }
        return workflowDTOs;
    }

    public static Collection<Workflow> workflowsDTOsToWorkflowDTO(Collection<WorkflowDTO> workflowDTOs) {
        Collection<Workflow> workflows = new ArrayList<>();
        for (WorkflowDTO workflowDTO : workflowDTOs) {
            Workflow workflow = workflowDTOToWorkflow(workflowDTO);
            workflows.add(workflow);
        }
        return workflows;
    }
}
