package project.repository;

import org.springframework.data.repository.CrudRepository;

import project.model.Project;
import project.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	Student

	findOne(int id);


	void delete(Student jsonProject);


	void save(Project jsonStudent);

}
