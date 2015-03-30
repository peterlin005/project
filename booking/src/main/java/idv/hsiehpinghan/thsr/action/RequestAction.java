package idv.hsiehpinghan.thsr.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class RequestAction extends ActionSupport {
	private static final long serialVersionUID = -8004597340467367053L;

	public String execute() {
		return SUCCESS;
	}
}
