package spring.java.service;

import spring.java.Student;
import spring.java.dao.StudentDao;

public class StudentRegisterService {

	private StudentDao studentDao;

	public StudentRegisterService(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}
	
	public void register (Student student) {
		String sNum = student.getsNum();
		if(verify(student.getsNum())) {
			studentDao.insert(student);
		}
		else {
			System.out.println("The student has already registered.");
		}
		
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student == null ? true : false;
	}
	
}
