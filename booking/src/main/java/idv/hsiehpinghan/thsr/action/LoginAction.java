package idv.hsiehpinghan.thsr.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
//import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.stereotype.Controller;

import idv.hsiehpinghan.thsr.model.User;
import idv.hsiehpinghan.thsr.service.UserService;
import idv.hsiehpinghan.thsr.utility.ServletUtility;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Validations(
		requiredStrings = {
				@RequiredStringValidator(type=ValidatorType.SIMPLE, trim=true, fieldName="personalId", message="請輸入帳號"),
				@RequiredStringValidator(type=ValidatorType.SIMPLE, trim=true, fieldName="password", message="請輸入密碼")
		}
)
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -8004597340467367053L;
	private String personalId;
	private String password;
	
	@Resource(name = "userServiceImpl")
	private UserService userService;

	@SkipValidation
	public String showLoginPage() {
		return INPUT;
	}
	
	public String execute() {
		User user = userService.findOne(personalId);
		if (user == null) {
			return INPUT;
		}
		if (!user.getPassword().equals(password)) {
			return INPUT;
		}

		ServletUtility.setSessionAttribute("user", user);

		return SUCCESS;
	}

	public String getPersonalId() {
		return personalId;
	}


	@SkipValidation
	public String logout() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.removeAttribute("user");

		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
}
