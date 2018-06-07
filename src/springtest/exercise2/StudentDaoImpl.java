package springtest.exercise2;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> queryAll() {
		List<Student> result = new ArrayList<>();
		result.add(new Student(1, "张三", Gender.Male, 20, "Java"));
		result.add(new Student(2, "李四", Gender.Female, 21, "UI"));
		result.add(new Student(3, "王五", Gender.Male, 23, "土木工程"));
		return result;
	}

}
