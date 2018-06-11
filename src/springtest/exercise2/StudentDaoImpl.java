package springtest.exercise2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		String sql = "select S_NUMBER, S_NAME, S_GENDER, S_AGE, S_MAJOR from STUDENT";
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}

}
