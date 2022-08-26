package ctrl;

public class ActionForward {
	private String path;
	private boolean redirect;
	
	public ActionForward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}
