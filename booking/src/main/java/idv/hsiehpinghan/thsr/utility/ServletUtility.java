package idv.hsiehpinghan.thsr.utility;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class ServletUtility {
	public static void setSessionAttribute(String string, Object object) {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.removeAttribute(string);
		session.setAttribute(string, object);
	}
}
