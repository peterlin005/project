package idv.hsiehpinghan.thsr.service;

import java.util.Date;
import java.util.List;

import idv.hsiehpinghan.thsr.enumeration.DirectionEnum;
import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.model.Train;

public interface TrainService {
	<S extends Train> S save(S entity);
	void deleteAll();
	boolean exists(Long id);
    Date findMaxDate();
	<S extends Train> List<S> save(Iterable<S> entities);
	<S extends Train> List<S> queryTimetable(Date date, DirectionEnum direction, StationEnum startStation, StationEnum destinationStation);
}
