package learnersacademy.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table
public class Class {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int classId;
	private String className;
	
	public Class(){
		
	}
	

	public Class(String className) {
		super();
		this.className = className;
	}


	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return className;
	}
	
	 
	

}
