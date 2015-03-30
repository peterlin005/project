package idv.hsiehpinghan.thsr.enumeration;

import java.util.EnumMap;

public enum DirectionEnum {
	NORTH,
	SOUTH;
	
	public static EnumMap<DirectionEnum, String> getEnumMap() {
		EnumMap<DirectionEnum, String> enumMap = new EnumMap<DirectionEnum, String>(DirectionEnum.class);
		enumMap.put(DirectionEnum.NORTH, "北上");
		enumMap.put(DirectionEnum.SOUTH, "南下");
		
		return enumMap;
	}
}
