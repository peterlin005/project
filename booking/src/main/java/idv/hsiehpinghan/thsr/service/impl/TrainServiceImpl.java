package idv.hsiehpinghan.thsr.service.impl;

import java.util.Date;
import java.util.List;

import idv.hsiehpinghan.thsr.enumeration.DirectionEnum;
import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.model.Train;
import idv.hsiehpinghan.thsr.repository.TrainRepository;
import idv.hsiehpinghan.thsr.service.TrainService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {
	@Resource
	private TrainRepository trainRepository;

	@Override
	public <S extends Train> S save(S entity) {
		return trainRepository.save(entity);
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public boolean exists(Long id) {
		return trainRepository.exists(id);
	}

	@Override
	public void deleteAll() {
		trainRepository.deleteAll();
	}

	@Override
	public Date findMaxDate() {
		Date date = trainRepository.findMaxDate();
		if (date == null) {
			return new Date();
		} else {
			return date;
		}
	}

	@Override
	public <S extends Train> List<S> save(Iterable<S> entities) {
		return trainRepository.save(entities);
	}

	@Override
	public <S extends Train> List<S> queryTimetable(Date date, DirectionEnum direction, StationEnum startStation, StationEnum destinationStation) {
		return trainRepository.queryTimetable(date, direction, startStation, destinationStation);
	}
}