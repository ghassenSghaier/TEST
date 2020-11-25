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
import tn.div.ncq.dto.WorkflowCategoryDTO;
import tn.div.ncq.service.WorkflowCategoryService;
/**
 *
 * @author lenovo
 */
@RestController
@RequestMapping(value = "/api/workflowcategory")
public class WorkflowCategoryController {
    
    @Autowired
    WorkflowCategoryService workflowService;
    
    @PostMapping
    public void addCategory(@RequestBody WorkflowCategoryDTO produitDTO) {
        workflowService.addWorkflow(produitDTO);
    }
    
    @GetMapping
    public Collection<WorkflowCategoryDTO> getWorkflows() {
        return workflowService.FindWorkflows();
    }

//    @GetMapping(value = "/name/{name}")
//    public Collection<WorkflowDTO> getProductByName(@PathVariable("name") String name) {
//        return workflowService.getWorkflow(name);
//    }
//    
    @GetMapping(value = "/name/{name}")
    public WorkflowCategoryDTO getWorkflowCategoryByName(@PathVariable("name") String name) {
        return workflowService.getWorkflow(name);
    }

//    @GetMapping(value = "/keyword/{key}")
//    public Collection<Workflow> getProductByKeyWord(@PathVariable("key") String keyWord) {
//        return workflowService.getProductsBykeyWord(keyWord);
//    }
    @GetMapping(value = "/reference/{id}")
    public WorkflowCategoryDTO getWorkflowCategory(@PathVariable("id") Long id) {
        return workflowService.getWorkflow(id);
    }
    
    @PutMapping
    public void updateWorkflowCategory(@RequestBody WorkflowCategoryDTO workflow) {
        workflowService.updateWorkflowCategory(workflow);
    }
    
    @DeleteMapping("/{reference}")
    public void deleteWorkflowCategory(@PathVariable Long reference) {
        workflowService.deleteWorkflowCategory(reference);
    }
    
}
