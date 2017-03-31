package project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String company;

	@Column(name="cont_email")
	private String contEmail;

	private String description;

	private String openforstudents;

	private String tags;

	//uni-directional many-to-many association to Tag
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="project_has_tag"
		, joinColumns={
			@JoinColumn(name="project_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="tag_id")
			}
		)
	private List<Tag> tagsSet;

	public Project() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContEmail() {
		return this.contEmail;
	}

	public void setContEmail(String contEmail) {
		this.contEmail = contEmail;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpenforstudents() {
		return this.openforstudents;
	}

	public void setOpenforstudents(String openforstudents) {
		this.openforstudents = openforstudents;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public List<Tag> getTagsSet() {
		return this.tagsSet;
	}

	public void setTagsSet(List<Tag> tagsSet) {
		this.tagsSet = tagsSet;
	}

}