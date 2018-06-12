package springtest.exercise2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	// 告诉JdbcTemplate如何把结果集的每一行映射成pojo对象
	// 注意：不需要写while(rs.next())，JdbcTemplate代写了
	@Override
	public Student mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Long id = rs.getLong(1);
		String name = rs.getString(2);
		Gender gender = Gender.valueOf(rs.getString(3));
		Integer age = rs.getInt(4);
		String major = rs.getString(5);
		Student s = new Student(id, name, gender, age, major);
		return s;
	}

}
