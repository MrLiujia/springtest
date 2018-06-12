package springtest.exercise2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Student> queryAll() {
		// 当不确定结果集有多少行时，使用jdbcTemplate.query，返回的是List
		String sql = "select S_ID, S_NAME, S_GENDER, S_AGE, S_MAJOR from STUDENT";
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}

	@Override
	public Student findOne(Long id) {
		// 当结果集有且仅有一行时，使用jdbcTemplate.queryForObject，返回的是pojo对象
		String sql = "select S_ID, S_NAME, S_GENDER, S_AGE, S_MAJOR from STUDENT where S_ID = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			// 结果集为空，id不存在
			return null;
		}
	}

	@Override
	public void add(Student student) {
		String sql = "insert into STUDENT(S_NAME, S_GENDER, S_AGE, S_MAJOR) "
				+ "values(?, ?, ?, ?)";
		jdbcTemplate.update(sql, 
				student.getName(), student.getGender().toString(), student.getAge(), student.getMajor());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from STUDENT where S_ID = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Student student) {
		String sql = "update STUDENT "
				+ "set S_NAME = ?, S_GENDER = ?, S_AGE = ?, S_MAJOR = ? "
				+ "where S_ID = ?";
		jdbcTemplate.update(sql, 
				student.getName(), student.getGender().toString(), student.getAge(), student.getMajor(),
				student.getId());
	}

}
