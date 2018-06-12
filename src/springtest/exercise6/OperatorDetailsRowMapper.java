package springtest.exercise6;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OperatorDetailsRowMapper implements RowMapper<Operator> {

	@Override
	public Operator mapRow(ResultSet rs, int rowNumber) throws SQLException {
		return new Operator(
				rs.getInt(1), 
				rs.getString(2), 
				rs.getString(3), // 需要密码
				rs.getString(4), 
				rs.getBoolean(5));
	}

}
