package idv.hsiehpinghan.thsr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 20130214L;
	@Version
	private Long version;
	@Id
	private String personalId;
	private String password;
	private String mobilePhoneNumber;
	private String email;
//	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, orphanRemoval = true)
//	@JoinTable
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL}, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Order> orders = new ArrayList<Order>();

	
	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personalId == null) ? 0 : personalId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (personalId == null) {
			if (other.personalId != null)
				return false;
		} else if (!personalId.equals(other.personalId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [version=" + version + ", personalId=" + personalId + ", password=" + password + ", mobilePhoneNumber=" + mobilePhoneNumber + ", email=" + email + ", orders=" + orders + "]";
	}
}
