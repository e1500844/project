package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.model.Project;
import project.repository.ProjectRepository;


@RestController
public class ProjectController {
	@Autowired
	ProjectRepository repository;
	@RequestMapping("/test")
	public String test(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "{\"id\":\"hello\"}";
	}
	
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public Project get(@RequestParam(value = "id", defaultValue = "1") int id) {
		return repository.findOne(id);
	}
	
	
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public @ResponseBody Project addProject(@RequestBody Project jsonProject) {
		repository.save(jsonProject);
		return jsonProject;
	}

	@RequestMapping(value = "/project", method = RequestMethod.DELETE)
	public void deleteProject(@RequestBody Project jsonProject) {
		repository.delete(jsonProject);
		// do business logic
	}

	@RequestMapping(value = "/project", method = RequestMethod.PUT)
	public @ResponseBody Project updateProject(@RequestBody Project jsonProject) {
		repository.save(jsonProject);
		return jsonProject;
	}
	
	@RequestMapping(value = "/project/all", method = RequestMethod.GET)
	public Iterable<Project> get() {
		return repository.findAll();
	}
	
}
