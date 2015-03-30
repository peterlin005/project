package idv.hsiehpinghan.thsr.repository;

import java.util.Date;
import java.util.List;

import idv.hsiehpinghan.thsr.enumeration.DirectionEnum;
import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.model.Train;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TrainRepository extends JpaRepository<Train, Long> {
	@Query("SELECT MAX(t.date) FROM Train t")
	Date findMaxDate();
	@Query("SELECT t FROM Train t inner join t.reachableStations rs WHERE t.date = :date and t.direction = :direction and rs.station IN (:startStation, :destinationStation) GROUP BY t HAVING COUNT(t.id) = 2")
	<S extends Train> List<S> queryTimetable(@Param("date") Date date, @Param("direction") DirectionEnum direction, @Param("startStation") StationEnum startStation, @Param("destinationStation") StationEnum destinationStation);
}
