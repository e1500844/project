package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.model.Tag;
import project.repository.TagRepository;

@RestController
public class TagController {
	@Autowired
	TagRepository repository;
	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public Tag get(@RequestParam(value = "id", defaultValue = "1") int id) {
		return repository.findOne(id);
	}
	
	
	@RequestMapping(value = "/tag", method = RequestMethod.POST)
	public @ResponseBody Tag addTag(@RequestBody Tag jsonTag) {
		repository.save(jsonTag);
		return jsonTag;
	}

	@RequestMapping(value = "/tag", method = RequestMethod.DELETE)
	public void deleteTag(@RequestBody Tag jsonTag) {
		repository.delete(jsonTag);
		// do business logic
	}

	@RequestMapping(value = "/tag", method = RequestMethod.PUT)
	public @ResponseBody Tag updateTag(@RequestBody Tag jsonTag) {
		repository.save(jsonTag);
		return jsonTag;
	}
	
	@RequestMapping(value = "/tag/all", method = RequestMethod.GET)
	public Iterable<Tag> get() {
		return repository.findAll();
	}
}
