package etron.rest.dosi.models;

public class Error {

	private String message;

	public String getMessage() {
		return message;
	}

	public Error(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
