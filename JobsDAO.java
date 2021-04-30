package mc.sn.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JobsDAO {
	//데이터베이스에 대하여 CRUD작업
	public String selectJobs() throws SQLException {
		String info = null;
		String sql = "select * from jobs";
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			info = rs.getString(1)+","+rs.getString(2)+","+rs.getString(3);
			break;
		}
		
		ConnectionManager.closeConnection(con, stmt, rs);
		
		return info;
	}
}
