package mc.sn.model;

import java.sql.SQLException;

public class BusinessService {
	public String checkWorkingDatabase() {
		String line = null;
		//���ۿ��θ� ���̺��� �� �� ������ ���ڿ��� ����
		JobsDAO dao = new JobsDAO();
		try {
			line = dao.selectJobs();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return line;
	}
}
