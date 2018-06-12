package springtest.exercise6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class OperatorDaoImpl implements OperatorDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private PasswordEncoder passwordEncoder;

	@Autowired
	public OperatorDaoImpl(JdbcTemplate jdbcTemplate,
			PasswordEncoder passwordEncoder) {
		this.jdbcTemplate = jdbcTemplate;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<Operator> findAll() {
		String sql = "select ID, USERNAME, ROLE, DISABLED from OPERATORS";
		return jdbcTemplate.query(sql, new OperatorItemRowMapper());
	}

	@Override
	public Operator findOne(Integer id) {
		String sql = "select ID, USERNAME, PASSWORD, ROLE, DISABLED "
				+ "from OPERATORS "
				+ "where ID = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new OperatorDetailsRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public void create(String username, String password, String role) {
		String sql = "insert into OPERATORS(USERNAME, PASSWORD, ROLE, DISABLED) "
				+ "values(?, ?, ?, false)";
		jdbcTemplate.update(sql, 
				username, 
				passwordEncoder.encode(password), 
				role);
	}

	@Override
	public void updatePassword(Integer id, String newPassword) {
		String sql = "update OPERATORS set PASSWORD = ? where ID = ?";
		jdbcTemplate.update(sql, 
				passwordEncoder.encode(newPassword),
				id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from OPERATORS where ID = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void disable(Integer id) {
		setDisabled(id, true);
	}

	private void setDisabled(Integer id, Boolean disabled) {
		String sql = "update OPERATORS set DISABLED = ? where ID = ?";
		jdbcTemplate.update(sql, disabled, id);
	}

	@Override
	public void enable(Integer id) {
		setDisabled(id, false);
	}

}
