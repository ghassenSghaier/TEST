/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.div.ncq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.div.ncq.entity.Workflow_Category;
import tn.div.ncq.entity.Workflow_CategoryPK;

/**
 *
 * @author lenovo
 */
public interface Workflow_CategoryRepository extends JpaRepository<Workflow_Category, Workflow_CategoryPK> {

}


