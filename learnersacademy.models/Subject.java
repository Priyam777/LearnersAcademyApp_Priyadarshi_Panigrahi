package learnersacademy.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subjectId;
	private String subjectName;
	@ManyToOne(cascade={CascadeType.PERSIST})
	private Class subjectClass;
	
	public Subject(){
		
	}
    
	
	public Subject(String subjectName, Class subjectClass) {
		super();
		this.subjectName = subjectName;
		this.subjectClass = subjectClass;
	}


	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Class getSubjectClass() {
		return subjectClass;
	}

	public void setSubjectClass(Class subjectClass) {
		this.subjectClass = subjectClass;
	}

	@Override
	public String toString() {
		return subjectName;
	}
	
	

}
