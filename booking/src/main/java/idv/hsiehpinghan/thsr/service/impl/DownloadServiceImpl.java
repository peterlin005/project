package idv.hsiehpinghan.thsr.service.impl;

import idv.hsiehpinghan.thsr.enumeration.DirectionEnum;
import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.model.ReachableStation;
import idv.hsiehpinghan.thsr.model.Train;
import idv.hsiehpinghan.thsr.repository.TrainRepository;
import idv.hsiehpinghan.thsr.service.DownloadService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableBody;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
@Transactional
public class DownloadServiceImpl implements DownloadService {
	@Resource
	private TrainRepository trainRepository;
	
//	@Scheduled(cron="0 * * * * ?")
	@Override
	public void timetableDownload() {
		DateTime nextDateTime = new DateTime(trainRepository.findMaxDate()).plusDays(1);
		DateTime targetDateTime = new DateTime().plusDays(30);
		
		// 超過特定日數才停止
		if(nextDateTime.isAfter(targetDateTime)) {
			return;
		}

		final WebClient webClient = new WebClient();
	    HtmlPage page = null;
		try {
			String date = nextDateTime.toString("yyyy/MM/dd");
			page = webClient.getPage("http://www.thsrc.com.tw/tc/ticket/tic_time_pop_summary.asp?sdate=" + date);
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		String northDirectionXPath = "/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]";
		String northTimetableXPath = "/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]";
		List<Train> northListTrain = getTrains(page, nextDateTime, northDirectionXPath, northTimetableXPath);
		
		String southDirectionXPath = "/html[1]/body[1]/table[1]/tbody[1]/tr[4]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]";
		String southTimetableXPath = "/html[1]/body[1]/table[1]/tbody[1]/tr[4]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]";
		List<Train> southListTrain = getTrains(page, nextDateTime, southDirectionXPath, southTimetableXPath);
		
		List<Train> listTrain = new ArrayList<Train>();
		listTrain.addAll(northListTrain);
		listTrain.addAll(southListTrain);
		trainRepository.save(listTrain);

	    webClient.closeAllWindows();
	}
	
	private List<Train> getTrains(HtmlPage page, DateTime nextDateTime, String directionXPath, String timetableXPath) {
		// Train fields
		Date date = nextDateTime.toDate();
		String trainId;
		DirectionEnum direction;
		String remark;
		List<ReachableStation> reachableStations;
		
		// ReachableStation fields
		StationEnum station;
		Date time;
		
		HtmlDivision htmlDivision = (HtmlDivision)page.getByXPath(directionXPath).get(0);
		String directionString = htmlDivision.asText();
		if(directionString.equals("南下列車")) {
			direction = DirectionEnum.SOUTH;
		} else if(directionString.equals("北上列車")) {
			direction = DirectionEnum.NORTH;
		} else {
			throw new IllegalArgumentException("未定義的directionString");
		}
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy/MM/ddHH:mm");
		String stringNextDateTime = nextDateTime.toString("yyyy/MM/dd");
		List<Train> listTrain = new ArrayList<Train>();
		HtmlTableBody htmlTableBody = (HtmlTableBody)page.getByXPath(timetableXPath).get(0);
		for(int i = 1, rowAmount = htmlTableBody.getRows().size(); i < rowAmount; ++i) {
			HtmlTableRow htmlTableRow = htmlTableBody.getRows().get(i);
			trainId = htmlTableRow.getCell(0).asText();
			remark = htmlTableRow.getCell(1).asText();
			reachableStations= new ArrayList<ReachableStation>();
			for(int j = 2, columnAmount = htmlTableRow.getCells().size(); j < columnAmount; ++j) {
				HtmlTableCell htmlTableCell = htmlTableRow.getCells().get(j);
				if(htmlTableCell.getTextContent().equals("")) {
					continue;
				}

				String stringTime = htmlTableCell.getTextContent();
				DateTime dateAndTime = dateTimeFormatter.parseDateTime(stringNextDateTime +stringTime);
				time = dateAndTime.toDate();
				
				String title = htmlTableCell.getAttribute("title");
				station =getStationEnum(title);
				
				ReachableStation reachableStation = new ReachableStation();
				reachableStation.setStation(station);
				reachableStation.setTime(time);
				
				reachableStations.add(reachableStation);
			}
			
			Train train = new Train();
			train.setDate(date);
			train.setDirection(direction);
			train.setReachableStations(reachableStations);
			train.setRemark(remark);
			train.setTrainId(trainId);
			
			listTrain.add(train);
		}
		
		return listTrain;
	}
	
	private StationEnum getStationEnum(String stringStation) {
		StationEnum station = null;
		
		switch (stringStation) {
		case "台北":
			station = StationEnum.TAIPEI;
			break;
		case "板橋":
			station = StationEnum.BANQIAO;
			break;
		case "桃園":
			station = StationEnum.TAOYUAN;
			break;
		case "新竹":
			station = StationEnum.HSINCHU;
			break;
		case "台中":
			station = StationEnum.TAICHUNG;
			break;
		case "嘉義":
			station = StationEnum.CHIAYI;
			break;
		case "台南":
			station = StationEnum.TAINAN;
			break;
		case "左營":
			station = StationEnum.ZUOYING;
			break;
		default:
			throw new IllegalArgumentException("未定義的stringStation");
		}
		
		return station;
	}
}
