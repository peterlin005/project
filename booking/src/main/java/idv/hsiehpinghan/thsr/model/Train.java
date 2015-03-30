package idv.hsiehpinghan.thsr.model;

import idv.hsiehpinghan.thsr.enumeration.DirectionEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "date", "trainId" }) })
public class Train implements Serializable {
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
	private DirectionEnum direction;
	private String remark;
	@OneToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@JoinTable
	private List<ReachableStation> reachableStations;

	public Long getId() {
		return id;
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

	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<ReachableStation> getReachableStations() {
		return reachableStations;
	}

	public void setReachableStations(List<ReachableStation> reachableStations) {
		this.reachableStations = reachableStations;
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
		Train other = (Train) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Train [version=" + version + ", id=" + id + ", date=" + date + ", trainId=" + trainId + ", direction=" + direction + ", remark=" + remark + ", reachableStations=" + reachableStations
				+ "]";
	}
}
