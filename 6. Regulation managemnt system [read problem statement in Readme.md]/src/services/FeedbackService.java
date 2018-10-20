package services;

import java.sql.SQLException;

import beans.FeedbackBean;
import doa.DatabaseWrapper;

public class FeedbackService {

	private DatabaseWrapper db;
	public FeedbackService() {
		db = new DatabaseWrapper();
	}
	
	public void saveFeedback(FeedbackBean fb) throws SQLException {
		
		
		String query = "insert into feedback values(null, '%s',%s)";
		query = String.format(query, fb.getFeedback(),fb.getUserId());
		db.executeSqlQueryInsert(query);
		
	}

}
