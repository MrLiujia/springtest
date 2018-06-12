package springtest.exercise6;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OperatorItemRowMapper implements RowMapper<Operator> {

	@Override
	public Operator mapRow(ResultSet rs, int rowNumber) throws SQLException {
		return new Operator(
				rs.getInt(1), 
				rs.getString(2), 
				null, // 不需要密码
				rs.getString(3), 
				rs.getBoolean(4));
	}

}
