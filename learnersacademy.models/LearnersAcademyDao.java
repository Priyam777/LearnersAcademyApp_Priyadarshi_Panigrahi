package learnersacademy.models;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LearnersAcademyDao {
	
	public static List<Admin> getAdmin() {
		Session session=null;
		Transaction transaction=null;
		List<Admin> adminList =null;
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery("from Admin");
			adminList=query.list();
			System.out.println(adminList);
			
			
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return adminList;
	}
		

}
	public static  int addSubjects(String className,String subjectName){
		Session session=null;
		Transaction transaction=null;
		int count=0;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			Class c1=new Class();
			
			Query query=session.createQuery("from Class c  where c.className=:className");
			query.setParameter("className", className);
			List classList=query.list();
			System.out.println(classList);
			
			if(classList.size()==0){
				c1.setClassName(className);
				session.save(c1);
			}
			else{
				c1=(Class)classList.get(0);
					
				}
			
			
			Subject s=new Subject();
			Query query1=session.createQuery("from Subject s where s.subjectName=:subjectName ");
			query1.setParameter("subjectName", subjectName);
			//query1.setParameter("className", className);
			List subjectList=query1.list();
			System.out.println(subjectList);
			if(subjectList.size()==0){
			s.setSubjectClass(c1);
			s.setSubjectName(subjectName);
			session.merge(s);
			count=1;
			}else{
				count=-1;
			}
			
			
			
			
			
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return count; 
	}
		

}
	public static  int addStudents(String className,String studentName){
		Session session=null;
		Transaction transaction=null;
		int count=0;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			Class c1=new Class();
			
			Query query=session.createQuery("from Class c  where c.className=:className");
			query.setParameter("className", className);
			List classList=query.list();
			System.out.println(classList);
			
			if(classList.size()==0){
				c1.setClassName(className);
				session.save(c1);
			}
			else{
				c1=(Class)classList.get(0);
					
				}
			
			
			Student s=new Student();
			s.setStudentClass(c1);
			s.setStudentName(studentName);
			count=(int)session.save(s);
			
			
			
			
			
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return count; 
	}	
		
	}
	public static  int addClasses(String className){
		Session session=null;
		Transaction transaction=null;
		int count=0;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			Class c1=new Class();
			
			Query query=session.createQuery("from Class c  where c.className=:className");
			query.setParameter("className", className);
			List classList=query.list();
			System.out.println(classList);
			
			if(classList.size()==0){
				c1.setClassName(className);
				session.save(c1);
				count=1;
			}else count= -1;			
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return count;
	}	
		
	}
	/*public static  int addTeachers(String teacherName,String className,String subjectName ){
		Session session=null;
		Transaction transaction=null;
		int count=0;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			Subject s1=new Subject();
			Class c1=new Class();
			
			Query query=session.createQuery("from Class c  where c.className=:className");
			query.setParameter("className", className);
			List classList=query.list();
			System.out.println(classList);
			
			
			if(classList.size()==0){
				c1.setClassName(className);
				session.save(c1);
			}
			else{
				c1=(Class)classList.get(0);
					
				}
			System.out.println(c1);
			System.out.println(subjectName);
			Query query1=session.createQuery("from Subject s  where s.subjectName=:subjectName");
			query1.setParameter("subjectName", subjectName);
			List subjectList=query1.list();
			System.out.println(subjectList);
			if(subjectList.size()==0){
				s1.setSubjectClass(c1);
				s1.setSubjectName(subjectName);
				session.save(s1);
			}
			else{
				s1=(Subject)subjectList.get(0);
			}
			System.out.println(s1);
			
			Teacher t1=new Teacher();
			Query query2=session.createQuery("from Teacher t  where t.teacherName=:teacherName");
			query2.setParameter("teacherName", teacherName);
			List teacherList=query2.list();
            System.out.println(teacherList);
            if(teacherList.size()==0){
			t1.getClassList().add(c1);
			t1.getSubjectList().add(s1);
			t1.setTeacherName(teacherName);
			count=(int)session.save(t1);
            }
            else{
            	t1.getClassList().add(c1);
    			t1.getSubjectList().add(s1);
    			session.saveOrUpdate(t1);
    			count=1;
            	
            }
            	
			
			
			
			
			
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return count; 
	}
	}*/
	
	public static  int addTeachers(String teacherName){
		Session session=null;
		Transaction transaction=null;
		int count=0;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			Teacher t1=new Teacher();
			
			Query query=session.createQuery("from Teacher t  where t.teacherName=:teacherName");
			query.setParameter("teacherName", teacherName);
			List teacherList=query.list();
			System.out.println(teacherList);
			
			if(teacherList.size()==0){
				t1.setTeacherName(teacherName);;
				session.save(t1);
				count=1;
			}else count= -1;			
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return count;
	}	
		
	}	
	public static  int assignTeacherClass(String teacherName,String className){
		Session session=null;
		Transaction transaction=null;
		int count=0;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
            Class c1=new Class();
			
			Query query=session.createQuery("from Class c  where c.className=:className");
			query.setParameter("className", className);
			List classList=query.list();
			System.out.println(classList);
			
			
			if(classList.size()==0){
				c1.setClassName(className);
				session.save(c1);
			}
			else{
				c1=(Class)classList.get(0);
					
				}
			System.out.println(c1);
			Teacher t1=new Teacher();
			
			Query query1=session.createQuery("from Teacher t  where t.teacherName=:teacherName");
			query1.setParameter("teacherName", teacherName);
			List teacherList=query1.list();
			System.out.println(teacherList);
			
			if(teacherList.size()==0){
				//t1.setTeacherName(teacherName);
				//session.save(t1);
				count=-1;
			}else {
			   t1=(Teacher)teacherList.get(0);
			   
			   if(t1.getClassList().contains(c1)){
				   count=0;
			   }
			   else{
				   t1.getClassList().add(c1);
			   session.merge(t1);
			   count=1;
			   }
			}
			
	}catch(Exception e){
		//System.out.println(e.getMessage());
		count=10;
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return count;
	}	
		
	}
	
	public static  int assignTeacherSubject(String teacherName,String subjectName){
		Session session=null;
		Transaction transaction=null;
		int count=0;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
            //Subject s1=new Subject();
			
			/*Query query=session.createQuery("from Subject s  where s.subjectName=:subjectName");
			query.setParameter("subjectName", subjectName);
			List subjectList=query.list();
			System.out.println(subjectList);
			
			Subject s1=new Subject();
			if(subjectList.size()!=0){
				s1=(Subject)subjectList.get(0);
				
				
			}
			else{
				count=-1;
					
				}
			System.out.println(s1);*/
			Teacher t1=new Teacher();
			
			Query query1=session.createQuery("from Teacher t  where t.teacherName=:teacherName");
			query1.setParameter("teacherName", teacherName);
			List teacherList=query1.list();
			System.out.println(teacherList);
			
			if(teacherList.size()==0){
				//t1.setTeacherName(teacherName);
				//session.save(t1);
				count=-2;
			}else {
			   t1=(Teacher)teacherList.get(0);
			   Query query=session.createQuery("from Subject s  where s.subjectName=:subjectName");
				query.setParameter("subjectName", subjectName);
				List subjectList=query.list();
				System.out.println(subjectList);
				
				Subject s1=new Subject();
				if(subjectList.size()!=0){
					s1=(Subject)subjectList.get(0);
					if(t1.getSubjectList().contains(s1)){
						   count=0;
					   }
					   else{
						   t1.getSubjectList().add(s1);
					   session.merge(t1);
					   count=1;
					   }
					
				}
				else{
					
					count=5;
					//session.flush();
					}
			   
			   
			}
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return count;
	}	
		
	}
	
	
	public static List<Student> getStudentsList(){
		Session session=null;
		Transaction transaction=null;
		List studentList=null;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			
			
			Query query=session.createQuery("from Student");
			
			studentList=query.list();
			System.out.println(studentList);
			
			
						
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return studentList;
	}	
		
	}	
	


public static List<Subject> getSubjectsList(){
	Session session=null;
	Transaction transaction=null;
	List subjectList=null;
	
	try{
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
		configuration.addAnnotatedClass(learnersacademy.models.Student.class);
		configuration.addAnnotatedClass(learnersacademy.models.Class.class);
		configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
		configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
		
		StandardServiceRegistryBuilder builder=new 
				StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		session=factory.openSession();
		transaction=session.beginTransaction();
		
		
		Query query=session.createQuery("from Subject");
		
		subjectList=query.list();
		System.out.println(subjectList);
		
		
					
		
}catch(Exception e){
	System.out.println(e.getMessage());
}finally{
	transaction.commit();
	
	if(session!=null){
		session.close();
	}
	return subjectList;
}	
	
}	


public static List<Class> getClassesList(){
	Session session=null;
	Transaction transaction=null;
	List classesList=null;
	
	try{
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
		configuration.addAnnotatedClass(learnersacademy.models.Student.class);
		configuration.addAnnotatedClass(learnersacademy.models.Class.class);
		configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
		configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
		
		StandardServiceRegistryBuilder builder=new 
				StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		session=factory.openSession();
		transaction=session.beginTransaction();
		
		
		Query query=session.createQuery("from Class");
		
		classesList=query.list();
		System.out.println(classesList);
		
		
					
		
}catch(Exception e){
	System.out.println(e.getMessage());
}finally{
	transaction.commit();
	
	if(session!=null){
		session.close();
	}
	return classesList;
}	
	
}	

public static List<Teacher> getTeachersList(){
	Session session=null;
	Transaction transaction=null;
	List teacherList=null;
	
	try{
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
		configuration.addAnnotatedClass(learnersacademy.models.Student.class);
		configuration.addAnnotatedClass(learnersacademy.models.Class.class);
		configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
		configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
		
		StandardServiceRegistryBuilder builder=new 
				StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		session=factory.openSession();
		transaction=session.beginTransaction();
		
		
		Query query=session.createQuery("from Teacher");
		
		teacherList=query.list();
		System.out.println(teacherList);
		
		
					
		
}catch(Exception e){
	System.out.println(e.getMessage());
}finally{
	transaction.commit();
	
	if(session!=null){
		session.close();
	}
	return teacherList;
}	
	
}	


public static List<Teacher> getMasterReportTeacher(String className){
	Session session=null;
	Transaction transaction=null;
	List teacherNames=null;
	
	try{
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
		configuration.addAnnotatedClass(learnersacademy.models.Student.class);
		configuration.addAnnotatedClass(learnersacademy.models.Class.class);
		configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
		configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
		
		StandardServiceRegistryBuilder builder=new 
				StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		session=factory.openSession();
		transaction=session.beginTransaction();
		
		String sqlQuery="select t.teacherName from teacher t,teacher_class tc"+
                        "where t.teacherId=tc.Teacher_teacherId"+
                        " and tc.classList_classId =:className";
		String hqlQuery="select t.teacherName from Teacher t inner join t.classList tc "+
                        "where tc.className=:className";
				
		
		/*Query query=session.createSQLQuery(sqlQuery)
				.addEntity("t",Teacher.class)
				;
		
		query.setInteger("className",className);*/
		Query query=session.createQuery(hqlQuery);
		query.setParameter("className", className);
		teacherNames=query.list();
		
		
		System.out.println(teacherNames);
		
		
					
		
}catch(Exception e){
	System.out.println(e.getMessage());
}finally{
	transaction.commit();
	
	if(session!=null){
		session.close();
	}
	return teacherNames;
}	
	
}
public static List<Subject> getMasterReportSubject(String className){
	Session session=null;
	Transaction transaction=null;
	List subjectNames=null;
	
	try{
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
		configuration.addAnnotatedClass(learnersacademy.models.Student.class);
		configuration.addAnnotatedClass(learnersacademy.models.Class.class);
		configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
		configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
		
		StandardServiceRegistryBuilder builder=new 
				StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		session=factory.openSession();
		transaction=session.beginTransaction();
		
		
		Query query=session.createQuery("select s.subjectName from Subject s where s.subjectClass.className=:className");
		query.setParameter("className", className);
		subjectNames=query.list();
		System.out.println(subjectNames);
		
		
					
		
}catch(Exception e){
	System.out.println(e.getMessage());
}finally{
	transaction.commit();
	
	if(session!=null){
		session.close();
	}
	return subjectNames;
}	
	
}
public static List<Subject> getMasterReportStudent(String className){
	Session session=null;
	Transaction transaction=null;
	List studentNames=null;
	
	try{
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
		configuration.addAnnotatedClass(learnersacademy.models.Student.class);
		configuration.addAnnotatedClass(learnersacademy.models.Class.class);
		configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
		configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
		
		StandardServiceRegistryBuilder builder=new 
				StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		session=factory.openSession();
		transaction=session.beginTransaction();
		
		
		Query query=session.createQuery("select st.studentName from Student st where st.studentClass.className=:className");
		query.setParameter("className", className);
		studentNames=query.list();
		System.out.println(studentNames);
		
		
					
		
}catch(Exception e){
	System.out.println(e.getMessage());
}finally{
	transaction.commit();
	
	if(session!=null){
		session.close();
	}
	return studentNames;
}	
	
}	
}
/*public static  int addSubjects(String className,String subjectName){
		Session session=null;
		Transaction transaction=null;
		int count=0;
		
		try{
			Configuration configuration=new Configuration().configure();
			configuration.addAnnotatedClass(learnersacademy.models.Admin.class);
			configuration.addAnnotatedClass(learnersacademy.models.Student.class);
			configuration.addAnnotatedClass(learnersacademy.models.Class.class);
			configuration.addAnnotatedClass(learnersacademy.models.Subject.class);
			configuration.addAnnotatedClass(learnersacademy.models.Teacher.class);
			
			StandardServiceRegistryBuilder builder=new 
					StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			session=factory.openSession();
			transaction=session.beginTransaction();
			Class c1=new Class();
			
			Query query=session.createQuery("from Class c  where c.className=:className");
			query.setParameter("className", className);
			List classList=query.list();
			System.out.println(classList);
			
			if(classList.size()==0){
				c1.setClassName(className);
				session.save(c1);
			}
			else{
				c1=(Class)classList.get(0);
					
				}
			
			
			Subject s=new Subject();
			s.setSubjectClass(c1);
			s.setSubjectName(subjectName);
			count=(int)session.save(s);
			
			
			
			
			
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		transaction.commit();
		
		if(session!=null){
			session.close();
		}
		return count; 
	}*/
