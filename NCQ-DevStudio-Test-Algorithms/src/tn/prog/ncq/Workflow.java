package tn.prog.ncq;

import java.util.ArrayList;
import java.util.List;

public class Workflow {
	Long IdWorkflow;
	String Name;
	String Description;
	boolean enabled;
	List<Workflow> wcs = new ArrayList<>();

	public Long getIdWorkflow() {
		return IdWorkflow;
	}

	public void setIdWorkflow(Long idWorkflow) {
		IdWorkflow = idWorkflow;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Workflow> getWcs() {
		return wcs;
	}

	public void setWcs(List<Workflow> wcs) {
		this.wcs = wcs;
	}

}
