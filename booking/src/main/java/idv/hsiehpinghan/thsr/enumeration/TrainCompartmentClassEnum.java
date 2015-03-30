package idv.hsiehpinghan.thsr.enumeration;

import java.util.EnumMap;

public enum TrainCompartmentClassEnum {
	STANDARD,
	BUSINESS;
	
	public static EnumMap<TrainCompartmentClassEnum, String> getEnumMap() {
		EnumMap<TrainCompartmentClassEnum, String> enumMap = new EnumMap<TrainCompartmentClassEnum, String>(TrainCompartmentClassEnum.class);
		enumMap.put(TrainCompartmentClassEnum.STANDARD, "標準");
		enumMap.put(TrainCompartmentClassEnum.BUSINESS, "商務");
		
		return enumMap;
	}
}
