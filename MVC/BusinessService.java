package mc.sn.model;

import java.sql.SQLException;

public class BusinessService {
	public String checkWorkingDatabase() {
		String line = null;
		//동작여부를 테이블의 한 행 정보를 문자열로 구성
		JobsDAO dao = new JobsDAO();
		try {
			line = dao.selectJobs();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return line;
	}
}
