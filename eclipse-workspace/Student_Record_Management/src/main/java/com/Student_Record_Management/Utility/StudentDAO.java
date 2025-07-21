package com.Student_Record_Management.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.Student_Record_Management.Entity.Student;

import java.util.List;



public class StudentDAO {
	
	 private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	    public void addStudent(Student student) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.persist(student);  // ✅ use persist instead of save
	        tx.commit();
	        session.close();
	    }

	    public List<Student> getAllStudents() {
	        Session session = factory.openSession();
	        List<Student> list = session.createQuery("from Student", Student.class).getResultList(); // ✅ updated for Hibernate 6
	        session.close();
	        return list;
	    }

	    public void updateMarksById(int id, int newMarks) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Student student = session.get(Student.class, id);
	        if (student != null) {
	            student.setMarks(newMarks);
	            session.merge(student);  // ✅ use merge instead of update
	            tx.commit();
	        } else {
	            System.out.println("Student not found!");
	        }
	        session.close();
	    }

	    public void deleteStudent(int id) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Student student = session.get(Student.class, id);
	        if (student != null) {
	            session.remove(student);  // ✅ use remove instead of delete
	            tx.commit();
	        } else {
	            System.out.println("Student not found!");
	        }
	        session.close();
	    }
	
	}
