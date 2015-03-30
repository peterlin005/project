package idv.hsiehpinghan.thsr.enumeration;

import java.util.EnumMap;

public enum StationEnum {
	TAIPEI,
	BANQIAO,
	TAOYUAN,
	HSINCHU,
	TAICHUNG,
	CHIAYI,
	TAINAN,
	ZUOYING;
	
	public static EnumMap<StationEnum, String> getEnumMap() {
		EnumMap<StationEnum, String> enumMap = new EnumMap<StationEnum, String>(StationEnum.class);
		enumMap.put(StationEnum.TAIPEI, "台北");
		enumMap.put(StationEnum.BANQIAO, "板橋");
		enumMap.put(StationEnum.TAOYUAN, "桃園");
		enumMap.put(StationEnum.HSINCHU, "新竹");
		enumMap.put(StationEnum.TAICHUNG, "台中");
		enumMap.put(StationEnum.CHIAYI, "嘉義");
		enumMap.put(StationEnum.TAINAN, "台南");
		enumMap.put(StationEnum.ZUOYING, "左營");
		return enumMap;
	}
}
