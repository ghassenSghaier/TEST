package tn.div.ncq.service;

import java.util.ArrayList;
import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.div.ncq.dto.Workflow_CategoryDTO;
import tn.div.ncq.entity.WorkflowCategory;
import tn.div.ncq.entity.Workflow_Category;
import tn.div.ncq.entity.Workflow_CategoryPK;
import tn.div.ncq.factory.Workflow_CategoryFactory;
import tn.div.ncq.repository.WorkflowCategoryRepository;
import tn.div.ncq.repository.WorkflowRepository;
import tn.div.ncq.repository.Workflow_CategoryRepository;

@Service
@Transactional
public class Workflow_CategoryService {

    @Autowired
    Workflow_CategoryRepository workflowRepository;

    @Autowired
    WorkflowRepository wRepository;

    @Autowired
    WorkflowCategoryRepository cRepository;
    
    @Autowired
    Workflow_CategoryFactory Workflow_CategoryFactory;

    public void addWorkflow_Category(Workflow_CategoryDTO workflowDTO) {
        Workflow_Category workflow = Workflow_CategoryFactory.workflow_CategoryDTOTOWorkflow_Category(workflowDTO);
        workflowRepository.save(workflow);
    }

    public void addWorkflows(Collection<Workflow_CategoryDTO> WorkflowDTOs) {
        Collection<Workflow_Category> Workflows = Workflow_CategoryFactory.workflow_CategoryDTOsTOWorkflow_Categories(WorkflowDTOs);
        workflowRepository.saveAll(Workflows);
    }

    public Collection<Workflow_CategoryDTO> FindWorkflows() {
        Collection<Workflow_Category> Workflows = workflowRepository.findAll();
        return Workflow_CategoryFactory.workflow_CategorysTOWorkflow_CategoryDTOs(Workflows);
    }

    public Collection<Workflow_CategoryDTO> getWorkflow(Long idCategory) {
        WorkflowCategory category = cRepository.findById(idCategory).get();
        Collection<Workflow_Category> wcs = workflowRepository.findAll();
        Collection<Workflow_Category> result = new ArrayList<>();
        for (Workflow_Category w : wcs) {
            if (w.getWorkflowCategory() != null && w.getWorkflowCategory().equals(category)) {
                result.add(w);
            }
        }
        return Workflow_CategoryFactory.workflow_CategorysTOWorkflow_CategoryDTOs(result);
    }

    public Collection<Workflow_CategoryDTO> getWorkflow(String categoryName) {
        WorkflowCategory category = cRepository.findByName(categoryName);
        Collection<Workflow_Category> wcs = workflowRepository.findAll();
        Collection<Workflow_Category> result = new ArrayList<>();
        for (Workflow_Category w : wcs) {
            if (w.getWorkflowCategory() != null && w.getWorkflowCategory().equals(category)) {
                result.add(w);
            }
        }
        return Workflow_CategoryFactory.workflow_CategorysTOWorkflow_CategoryDTOs(result);
    }

    /**
     * ****************************************************
     */
    public Workflow_CategoryDTO getWorkflow(long idWorkflow, Long idCategory) {
        Workflow_CategoryPK wc = new Workflow_CategoryPK(idCategory, idWorkflow);
        Workflow_Category workflow = workflowRepository.findById(wc).get();
        return Workflow_CategoryFactory.workflow_CategoryTOWorkflow_CategoryDTO(workflow);
    }

    public void updateWorkflow_Category(Workflow_CategoryDTO workflowDTO) {
        //vérification de l'existence de bonCommande
        Workflow_Category workflowCategory = Workflow_CategoryFactory.workflow_CategoryDTOTOWorkflow_Category(workflowDTO);
        workflowRepository.save(workflowCategory);
    }

    public void deleteWorkflow_Category(Long idCategory, Long idWorkflow) {
        Workflow_CategoryPK pk = new Workflow_CategoryPK(idCategory, idWorkflow);
        workflowRepository.deleteById(pk);
    }

}
