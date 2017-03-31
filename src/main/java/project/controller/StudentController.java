package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.model.Student;
import project.repository.StudentRepository;



@RestController
public class StudentController {
	@Autowired
	StudentRepository repository;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public Student get(@RequestParam(value = "id", defaultValue = "1") int id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public @ResponseBody Student addStudent(@RequestBody Student jsonStudent) {
		repository.save(jsonStudent);
		return jsonStudent;
	}

	@RequestMapping(value = "/student", method = RequestMethod.DELETE)
	public void deleteStudent(@RequestBody Student jsonStudent) {
		repository.delete(jsonStudent);
		// do business logic
	}

	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public @ResponseBody Student updateStudent(@RequestBody Student jsonStudent) {
		repository.save(jsonStudent);
		return jsonStudent;
	}
	
	@RequestMapping(value = "/student/all", method = RequestMethod.GET)
	public Iterable<Student> get() {
		return repository.findAll();
	}
}
