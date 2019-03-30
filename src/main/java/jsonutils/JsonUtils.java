package jsonutils;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class JsonUtils {
	
	public DataTimeUtils extractDateAndTime(JsonNode node) {
		DataTimeUtils dataTimeUtils = new DataTimeUtils();
		try {
			String dateString = node.get("date").textValue();
			String dateStringSplitted[] = dateString.split("-");
			LocalDate date = LocalDate.of(
					Integer.parseInt(dateStringSplitted[0]), 
					Integer.parseInt(dateStringSplitted[1]), 
					Integer.parseInt(dateStringSplitted[2]));
			dataTimeUtils.setDate(date);
		}catch (NullPointerException e) {
			dataTimeUtils.setDate(null);
		}
		try {
			String timeString = node.get("time").textValue();
			String timeStringSplitted[] = timeString.split(":");
			LocalTime time = LocalTime.of(
					Integer.parseInt(timeStringSplitted[0]),
					Integer.parseInt(timeStringSplitted[1])
					);
			dataTimeUtils.setTime(time);
		}catch (NullPointerException e) {
			dataTimeUtils.setTime(null);
		}
		return dataTimeUtils;
	}
	
	public Double extractDouble(JsonNode node, String key) {
		String value = node.get(key).textValue();
		if(value == null || value.equals("")) {
			return null;
		}
		try {
			return Double.parseDouble(value);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Long extractLong(JsonNode node, String key) {
		String value = node.get(key).textValue();
		if(value == null || value.equals("")) {
			return null;
		}
		try {
			return Long.parseLong(value);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
