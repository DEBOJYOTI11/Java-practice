package beans;

public class RegulationBean {
	private int id;
	private String regulationHeading, regulationBody; 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegulationHeading() {
		return regulationHeading;
	}
	public void setRegulationHeading(String regulationHeading) {
		this.regulationHeading = regulationHeading;
	}
	public String getRegulationBody() {
		return regulationBody;
	}
	public void setRegulationBody(String regulationBody) {
		this.regulationBody = regulationBody;
	}

}
