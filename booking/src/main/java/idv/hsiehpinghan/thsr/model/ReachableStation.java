package idv.hsiehpinghan.thsr.model;

import idv.hsiehpinghan.thsr.enumeration.StationEnum;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Reachable_Station")
public class ReachableStation implements Serializable {
	private static final long serialVersionUID = 20130214L;
	@Version
	private Long version;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private StationEnum station;
	@Temporal(TemporalType.TIME)
	private Date time;

	public StationEnum getStation() {
		return station;
	}

	public void setStation(StationEnum station) {
		this.station = station;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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
		ReachableStation other = (ReachableStation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReachableStation [version=" + version + ", id=" + id + ", station=" + station + ", time=" + time + "]";
	}
}
