package idv.hsiehpinghan.thsr.action;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import idv.hsiehpinghan.thsr.model.User;
import idv.hsiehpinghan.thsr.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.annotations.Validations;

@Validations(
		requiredStrings = {
				@RequiredStringValidator(type=ValidatorType.SIMPLE, trim=true, fieldName="personalId", message="請輸入帳號"),
				@RequiredStringValidator(type=ValidatorType.SIMPLE, trim=true, fieldName="password", message="請輸入密碼"),
				@RequiredStringValidator(type=ValidatorType.SIMPLE, trim=true, fieldName="confirmPassword", message="請輸入確認密碼"),
				@RequiredStringValidator(type=ValidatorType.SIMPLE, trim=true, fieldName="mobilePhoneNumber", message="請輸入手機")
		},
		emails = {
				@EmailValidator(type=ValidatorType.SIMPLE, fieldName="email", message="電子信箱格式錯誤")
		}
)
@Controller
@Scope("prototype")
public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = -8004597340467367053L;
	private String personalId;
	private String password;
	private String confirmPassword;
	private String mobilePhoneNumber;
	private String email;
	@Resource(name = "userServiceImpl")
	private UserService userService;

	@SkipValidation
	public String showRegisterPage() {
		return INPUT;
	}

	public String execute() {
//		if (personalId == null) {
//			return INPUT;
//		}
//		if (password == null) {
//			return INPUT;
//		}
//		if (confirmPassword == null) {
//			return INPUT;
//		}
//		if (mobilePhoneNumber == null) {
//			return INPUT;
//		}
//		if (email == null) {
//			return INPUT;
//		}
//		if (!password.equals(confirmPassword)) {
//			return INPUT;
//		}

		User user = new User();
		user.setEmail(email);
		user.setMobilePhoneNumber(mobilePhoneNumber);
		user.setPassword(password);
		user.setPersonalId(personalId);
		userService.save(user);

		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getPersonalId() {
		return personalId;
	}
	
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
}
