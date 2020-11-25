/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.div.ncq.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.div.ncq.entity.Workflow;

/**
 *
 * @author lenovo
 */
public interface WorkflowRepository extends JpaRepository<Workflow, Long> {

    public Workflow findByName(String name);

    public Collection<Workflow> findByStatus(int status);
}
