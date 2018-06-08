package springtest.exercise2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private DataSource dataSource;
	
	@Autowired
	public StudentDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Student> queryAll() {
		List<Student> result = new ArrayList<>();
		
		Connection cnt = null;
		try { // happy path
			cnt = dataSource.getConnection();
			PreparedStatement ps = cnt.prepareStatement(
					"select S_NUMBER, S_NAME, S_GENDER, S_AGE, S_MAJOR from STUDENT");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer number = rs.getInt(1);
				String name = rs.getString(2);
				Gender gender = Gender.valueOf(rs.getString(3));
				Integer age = rs.getInt(4);
				String major = rs.getString(5);
				Student s = new Student(number, name, gender, age, major);
				result.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (cnt != null) {
				try { 
					cnt.close(); // finally中不提倡抛出新异常，这样会隐藏掉原异常
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return result;
	}

}
