package springtest.exercise2;

import java.util.List;

public class StudentController {
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	public void list() {
		List<Student> list = studentService.findAll();
		for (Student student : list) {
			System.out.println(String.format("%s %s %s %s %s", 
					student.getNumber(), student.getName(), 
					student.getGender(), student.getAge(),
					student.getMajor()));
		}
	}
}
