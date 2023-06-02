package common;

public enum Endpoint {

	STUDENT("students"),
	HELP("helper");
	
	String name;
	
	Endpoint(String name) {
		this.name = name;
	}
	
	public String getEndpoint() {
		return name;
	}
}
