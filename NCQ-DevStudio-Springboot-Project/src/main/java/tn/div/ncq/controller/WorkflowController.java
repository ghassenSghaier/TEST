package tn.div.ncq.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.div.ncq.dto.WorkflowDTO;
import tn.div.ncq.service.WorkflowService;

/**
 *
 * @author lenovo
 */
@RestController
@RequestMapping(value = "/api/workflow")
public class WorkflowController {

    @Autowired
    WorkflowService workflowService;

    @PostMapping
    public void addProduct(@RequestBody WorkflowDTO produitDTO) {
        workflowService.addWorkflow(produitDTO);
    }

    @GetMapping
    public Collection<WorkflowDTO> getWorkflows() {
        return workflowService.FindWorkflows();
    }

    @GetMapping(value = "/cat/{id}")
    public Collection<WorkflowDTO> getWorkflowByCategory(@PathVariable("id") Long idCat) {
        return workflowService.getWorkflowByCategory(idCat);
    }
    
    @GetMapping(value = "/name/{name}")
    public WorkflowDTO getWorkflowByName(@PathVariable("name") String name) {
        return workflowService.getWorkflow(name);
    }

//    @GetMapping(value = "/keyword/{key}")
//    public Collection<Workflow> getProductByKeyWord(@PathVariable("key") String keyWord) {
//        return workflowService.getProductsBykeyWord(keyWord);
//    }
    @GetMapping(value = "/reference/{id}")
    public WorkflowDTO getProduct(@PathVariable("id") Long reference) {
        return workflowService.getWorkflow(reference);
    }

    @PutMapping
    public void updateProduct(@RequestBody WorkflowDTO workflow) {
        workflowService.updateWorkflow(workflow);
    }

    @DeleteMapping("/{reference}")
    public void deleteProduct(@PathVariable Long reference) {
        workflowService.deleteWorkflow(reference);
    }

}
