package idv.hsiehpinghan.thsr.action;

import java.util.List;

import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.enumeration.TrainCompartmentClassEnum;
import idv.hsiehpinghan.thsr.model.Order;
import idv.hsiehpinghan.thsr.model.Train;
import idv.hsiehpinghan.thsr.model.User;
import idv.hsiehpinghan.thsr.service.OrderService;
import idv.hsiehpinghan.thsr.service.UserService;
import idv.hsiehpinghan.thsr.utility.ServletUtility;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class OrderTicketAction extends ActionSupport {
	private static final long serialVersionUID = -6565136096117920181L;
	private TrainCompartmentClassEnum trainCompartmentClass;
	private Integer adultTicketAmount;
	private Integer childTickenAmount;
	private Integer disabledTicketAmount;
	private Integer seniorTicketAmount;
	private Integer selectedTrainIndex;
	private int selectedOrderIndex;
	
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@Resource(name = "orderServiceImpl")
	private OrderService orderService;

	public String showOrderTicketPage() {
		ServletUtility.setSessionAttribute("selectedTrainIndex", selectedTrainIndex);
		return INPUT;
	}
	
	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		selectedTrainIndex = (Integer)session.getAttribute("selectedTrainIndex");
		@SuppressWarnings("unchecked")
		List<Train> listTrain = (List<Train>) session.getAttribute("listTrain");
		if (selectedTrainIndex < 0 || selectedTrainIndex >= listTrain.size()) {
			return INPUT;
		}

		Train train = listTrain.get(selectedTrainIndex);

		User user = (User)session.getAttribute("user");
		Order order = new Order();
		order.setAdultTicketAmount(adultTicketAmount);
		order.setChildTickenAmount(childTickenAmount);
		order.setDate(train.getDate());
		order.setDestinationStation((StationEnum)session.getAttribute("destinationStation"));
		order.setDisabledTicketAmount(disabledTicketAmount);
		order.setSeniorTicketAmount(seniorTicketAmount);
		order.setStartStation((StationEnum)session.getAttribute("startStation"));
		order.setTrainCompartmentClass(trainCompartmentClass);
		order.setTrainId(train.getTrainId());
		order.setUser(user);
		
		order = orderService.save(order);

		boolean result = orderService.orderTicket(order);
		
		if(result == true) {
			order = orderService.findOne(order.getId());
		}
		
		user.getOrders().add(order);
		user = userService.save(user);
		ServletUtility.setSessionAttribute("user", user);

		return SUCCESS;
	}

	public String deleteOrder() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		User user = (User)session.getAttribute("user");
		user.getOrders().remove(selectedOrderIndex);
		user = userService.save(user);
		ServletUtility.setSessionAttribute("user", user);

		return SUCCESS;
	}

	public String showOrder() {
		return SUCCESS;
	}

	public TrainCompartmentClassEnum getTrainCompartmentClass() {
		return trainCompartmentClass;
	}

	public void setTrainCompartmentClass(TrainCompartmentClassEnum trainCompartmentClass) {
		this.trainCompartmentClass = trainCompartmentClass;
	}

	public Integer getAdultTicketAmount() {
		return adultTicketAmount;
	}

	public void setAdultTicketAmount(Integer adultTicketAmount) {
		this.adultTicketAmount = adultTicketAmount;
	}

	public Integer getChildTickenAmount() {
		return childTickenAmount;
	}

	public void setChildTickenAmount(Integer childTickenAmount) {
		this.childTickenAmount = childTickenAmount;
	}

	public Integer getDisabledTicketAmount() {
		return disabledTicketAmount;
	}

	public void setDisabledTicketAmount(Integer disabledTicketAmount) {
		this.disabledTicketAmount = disabledTicketAmount;
	}

	public Integer getSeniorTicketAmount() {
		return seniorTicketAmount;
	}

	public void setSeniorTicketAmount(Integer seniorTicketAmount) {
		this.seniorTicketAmount = seniorTicketAmount;
	}

	public Integer getSelectedTrainIndex() {
		return selectedTrainIndex;
	}

	public void setSelectedTrainIndex(Integer selectedTrainIndex) {
		this.selectedTrainIndex = selectedTrainIndex;
	}

	public int getSelectedOrderIndex() {
		return selectedOrderIndex;
	}

	public void setSelectedOrderIndex(int selectedOrderIndex) {
		this.selectedOrderIndex = selectedOrderIndex;
	}
}
