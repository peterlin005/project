package idv.hsiehpinghan.thsr.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import idv.hsiehpinghan.thsr.enumeration.DirectionEnum;
import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.model.Train;
import idv.hsiehpinghan.thsr.service.TrainService;
import idv.hsiehpinghan.thsr.utility.ServletUtility;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Validations(
		requiredFields = {
				@RequiredFieldValidator(type=ValidatorType.SIMPLE, fieldName="date", message="請選擇日期"),
				@RequiredFieldValidator(type=ValidatorType.SIMPLE, fieldName="startStation", message="請選擇起程站"),
				@RequiredFieldValidator(type=ValidatorType.SIMPLE, fieldName="destinationStation", message="請選擇到達站")
		}
)
@Controller
@Scope("prototype")
public class QueryTimetableAction extends ActionSupport {
	private static final long serialVersionUID = -8004597340467367053L;
	private Date date;
	private StationEnum startStation;
	private StationEnum destinationStation;

	@Resource(name = "trainServiceImpl")
	private TrainService trainService;

	@SkipValidation
	public String showQueryTimetablePage() {
		return INPUT;
	}
	
	public String execute() {
		DirectionEnum direction;
		int compareResult = startStation.compareTo(destinationStation);
		if (compareResult < 0) {
			direction = DirectionEnum.SOUTH;
		} else if (compareResult > 0) {
			direction = DirectionEnum.NORTH;
		} else {
			return INPUT;
		}

		ServletUtility.setSessionAttribute("startStation", startStation);
		ServletUtility.setSessionAttribute("destinationStation", destinationStation);
		
		List<Train> listTrain = trainService.queryTimetable(date, direction, startStation, destinationStation);
		ServletUtility.setSessionAttribute("listTrain", listTrain);

		return SUCCESS;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StationEnum getStartStation() {
		return startStation;
	}

	public void setStartStation(StationEnum startStation) {
		this.startStation = startStation;
	}
	
	public StationEnum getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(StationEnum destinationStation) {
		this.destinationStation = destinationStation;
	}

	public TrainService getTrainService() {
		return trainService;
	}

	public void setTrainService(TrainService trainService) {
		this.trainService = trainService;
	}
}
