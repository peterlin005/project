package idv.hsiehpinghan.thsr.service.data;

import idv.hsiehpinghan.thsr.enumeration.DirectionEnum;
import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.model.Train;
import idv.hsiehpinghan.thsr.model.ReachableStation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class TrainDataProvider {
	@DataProvider
	public static Iterator<Object[]> trainDataProvider(ITestContext iTestContext) {
		List<Object[]> listObjects = new ArrayList<Object[]>();
		for (int i = 0; i < 1; ++i) {
			Train train = new Train();
			train.setDate(new Date());
			train.setDirection(DirectionEnum.SOUTH);
			train.setReachableStations(getListReachableStation());
			train.setRemark("remark" + i);
			train.setTrainId("trainId" + i);

			Object[] objects = new Object[] { train };
			listObjects.add(objects);
		}

		return listObjects.iterator();
	}

	public static List<ReachableStation> getListReachableStation() {
		List<ReachableStation> listReachableStation = new ArrayList<ReachableStation>();
		for (int i = 0; i < 3; ++i) {
			ReachableStation reachableStation = new ReachableStation();
			reachableStation.setStation(StationEnum.CHIAYI);
			reachableStation.setTime(new Date());
			listReachableStation.add(reachableStation);
		}

		return listReachableStation;
	}
}
