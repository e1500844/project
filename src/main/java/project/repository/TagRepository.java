package project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import project.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer>{
	List<Tag> findById(int id);
}
