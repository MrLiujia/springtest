package springtest.exercise2;

import java.util.List;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> findAll() {
		return studentDao.queryAll();
	}

}
