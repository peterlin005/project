package idv.hsiehpinghan.thsr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.enumeration.TrainCompartmentClassEnum;

@Entity
@Table(name = "Ticket_Order")
public class Order implements Serializable {
	private static final long serialVersionUID = 20130214L;
	@Version
	private Long version;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String trainId;
	@Enumerated(EnumType.STRING)
	private TrainCompartmentClassEnum trainCompartmentClass;
	@Enumerated(EnumType.STRING)
	private StationEnum startStation;
	@Enumerated(EnumType.STRING)
	private StationEnum destinationStation;
	private Integer adultTicketAmount;
	private Integer childTickenAmount;
	private Integer disabledTicketAmount;
	private Integer seniorTicketAmount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTimestamp;
	@Temporal(TemporalType.TIMESTAMP)
	private Date gotTimestamp;
	
    @ManyToOne
    private User user;

	@PrePersist
	public void prePersist() {
		creationTimestamp = new Date();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public TrainCompartmentClassEnum getTrainCompartmentClass() {
		return trainCompartmentClass;
	}

	public void setTrainCompartmentClass(TrainCompartmentClassEnum trainCompartmentClass) {
		this.trainCompartmentClass = trainCompartmentClass;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getGotTimestamp() {
		return gotTimestamp;
	}

	public void setGotTimestamp(Date gotTimestamp) {
		this.gotTimestamp = gotTimestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [version=" + version + ", id=" + id + ", date=" + date + ", trainId=" + trainId + ", trainCompartmentClass=" + trainCompartmentClass + ", startStation=" + startStation
				+ ", destinationStation=" + destinationStation + ", adultTicketAmount=" + adultTicketAmount + ", childTickenAmount=" + childTickenAmount + ", disabledTicketAmount="
				+ disabledTicketAmount + ", seniorTicketAmount=" + seniorTicketAmount + ", creationTimestamp=" + creationTimestamp + ", gotTimestamp=" + gotTimestamp + ", user.PersonalId=" + user.getPersonalId() + "]";
	}
}
