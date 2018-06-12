package springtest.exercise2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	public void list() {
		List<Student> list = studentService.findAll();
		for (Student student : list) {
			System.out.println(String.format("%s %s %s %s %s", 
					student.getId(), student.getName(), 
					student.getGender(), student.getAge(),
					student.getMajor()));
		}
	}
}
