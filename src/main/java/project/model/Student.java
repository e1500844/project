package project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String available;

	@Column(name="ave_grade")
	private float aveGrade;

	private int credits;

	private String email;

	private String mobile;

	private String name;

	private String tags;

	//uni-directional many-to-many association to Tag
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="student_has_tag"
		, joinColumns={
			@JoinColumn(name="student_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="tag_id")
			}
		)
	private List<Tag> tagsSet;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvailable() {
		return this.available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public float getAveGrade() {
		return this.aveGrade;
	}

	public void setAveGrade(float aveGrade) {
		this.aveGrade = aveGrade;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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