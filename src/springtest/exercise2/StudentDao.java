package springtest.exercise2;

import java.util.List;

public interface StudentDao {

	List<Student> queryAll();
	
	Student findOne(Long id);
	
	void add(Student student);
	
	void delete(Long id);
	
	void update(Student student);
}
