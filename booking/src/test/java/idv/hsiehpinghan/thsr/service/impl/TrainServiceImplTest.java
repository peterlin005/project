package idv.hsiehpinghan.thsr.service.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import idv.hsiehpinghan.thsr.enumeration.DirectionEnum;
import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.model.Train;
import idv.hsiehpinghan.thsr.service.TrainService;

import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TrainServiceImplTest {
	private GenericXmlApplicationContext genericXmlApplicationContext = null;
	private TrainService trainService = null;
	private Train train = null;

	@Factory(dataProviderClass = idv.hsiehpinghan.thsr.service.data.TrainDataProvider.class, dataProvider = "trainDataProvider")
	public TrainServiceImplTest(Train train) {
		this.train = train;
	}

	@BeforeClass
	public void beforeClass() {
		genericXmlApplicationContext = new GenericXmlApplicationContext();
		genericXmlApplicationContext.load("classpath:applicationContext.xml");
		genericXmlApplicationContext.refresh();

		trainService = genericXmlApplicationContext.getBean("trainServiceImpl", TrainService.class);
		
		// 清除所有資料
//		trainService.deleteAll();
	}

	@AfterClass
	public void afterClass() {
		genericXmlApplicationContext.close();
	}

	@Test(enabled=false)
	public void save() {
		train = trainService.save(train);
		boolean condition = trainService.exists(train.getId());
		Assert.assertTrue(condition);
	}
	
//	@Test
//	public void queryTimetable() {
//		DateTime dateTime = new DateTime();
//		Date date = dateTime.plusDays(1).toDate();
//
//		List<Train> listTrain = trainService.queryTimetable(date, DirectionEnum.SOUTH, StationEnum.BANQIAO, StationEnum.TAINAN);
//		for(Train train : listTrain) {
//			System.out.println(train);
//		}
//	}
}
