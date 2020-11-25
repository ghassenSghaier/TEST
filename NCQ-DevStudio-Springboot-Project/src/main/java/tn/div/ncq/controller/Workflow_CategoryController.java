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
import tn.div.ncq.dto.Workflow_CategoryDTO;
import tn.div.ncq.service.Workflow_CategoryService;

@RestController
@RequestMapping(value = "/api/workflow_category")
public class Workflow_CategoryController {

    @Autowired
    Workflow_CategoryService workflowService;

    @PostMapping
    public void addCategory(@RequestBody Workflow_CategoryDTO produitDTO) {
        workflowService.addWorkflow_Category(produitDTO);
    }

    @GetMapping
    public Collection<Workflow_CategoryDTO> getWorkflows() {
        return workflowService.FindWorkflows();
    }

    @GetMapping(value = "/name/{name}")
    public Collection<Workflow_CategoryDTO> getWorkflowCategoryByName(@PathVariable("name") String name) {
        return workflowService.getWorkflow(name);
    }

    @GetMapping(value = "/reference/{id}")
    public Collection<Workflow_CategoryDTO> getWorkflowCategory(@PathVariable("id") Long id) {
        return workflowService.getWorkflow(id);
    }

    @PutMapping
    public void updateWorkflowCategory(@RequestBody Workflow_CategoryDTO workflow) {
        workflowService.updateWorkflow_Category(workflow);
    }

    @DeleteMapping("delete/{idWorkflow}/{idCategory}")
    public void deleteWorkflowCategory(@PathVariable Long idWorkflow, @PathVariable Long idCategory) {
        workflowService.deleteWorkflow_Category(idWorkflow, idCategory);
    }

}
