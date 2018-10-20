package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.RegulationBean;
import doa.DatabaseWrapper;

public class RegulationService {
	
	private DatabaseWrapper db;
	public RegulationService() {
		db = new DatabaseWrapper();
	}
	
	
	public void addRegulation(RegulationBean rb) throws SQLException{
		String query   = "insert into regulation values(null,'%s','%s')";
		query = String.format(query, rb.getRegulationHeading(),rb.getRegulationBody());
		db.executeSqlQueryInsert(query);
	}
	
	public ArrayList<RegulationBean> getAllRegulation() throws SQLException {
		
		String query = "select * from regulation";
		
		ResultSet rs = db.executeSqlQuerySelect(query);
		
		ArrayList<RegulationBean> arr = new ArrayList<>();
		
		while(rs.next()) {
			RegulationBean rb = new RegulationBean();
			rb.setId(rs.getInt(1));
			rb.setRegulationHeading(rs.getString(2));
			rb.setRegulationBody(rs.getString(2));
			arr.add(rb);
		}
		return arr;
	}
	
	public RegulationBean getRegulationDetail(String id) throws SQLException {
		String query = "select * from regulation where id = "+id;
		
		ResultSet rs = db.executeSqlQuerySelect(query);
		RegulationBean rb = new RegulationBean();
		while(rs.next()) {
			
			rb.setId(rs.getInt(1));
			rb.setRegulationHeading(rs.getString(2));
			rb.setRegulationBody(rs.getString(3));
			
		}
		if(rb==null)
			throw new SQLException();
		else
			return rb;
	}
}
