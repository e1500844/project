package project.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import project.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
	List<Project> findById(int id);
}
