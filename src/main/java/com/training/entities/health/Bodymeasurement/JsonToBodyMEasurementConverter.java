package com.training.entities.health.Bodymeasurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.training.entities.common.EntityConverter;
import com.training.entities.health.Health;
import com.training.repo.health.IHealthRepository;

import jsonutils.DataTimeUtils;
import jsonutils.JsonUtils;

/*
 * {
 * 	"date":"2019-03-08 15:12",
 * 	"weight":"1",
 * 	"upperArm":"2",
 * 	"chest":"3",
 * 	"waist":"",
 * 	"hips":"6",
 * 	"thigh":"3"}
 * */

@Component
public class JsonToBodyMEasurementConverter implements EntityConverter<JsonNode, BodyMeasurement> {

	@Autowired
	private IHealthRepository healthRepository;

	private JsonUtils jsonUtils = new JsonUtils();
	
	@Override
	public BodyMeasurement convert(JsonNode node) {
		
		DataTimeUtils dataTimeUtils = this.jsonUtils.extractDateAndTime(node);
		Double weight   = this.jsonUtils.extractDouble(node, "weight");
		Double upperArm = this.jsonUtils.extractDouble(node, "upperArm");
		Double chest    = this.jsonUtils.extractDouble(node, "chest");
		Double waist    = this.jsonUtils.extractDouble(node, "waist");
		Double hips     = this.jsonUtils.extractDouble(node, "hips");
		Double thigh    = this.jsonUtils.extractDouble(node, "thigh");
		Long healthId   = this.jsonUtils.extractLong(node, "healthId");
		
		Health health = this.healthRepository.findById(healthId).get();
		
		BodyMeasurement bodyMeasurement = BodyMeasurement.builder()
				.date(dataTimeUtils.getDate())
				.weight(weight)
				.upperArm(upperArm)
				.chest(chest)
				.waist(waist)
				.hips(hips)
				.thigh(thigh)
				.health(health)
				.build();
		
		return bodyMeasurement;
	}

	
}
