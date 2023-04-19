package com.win11.util;

import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.win11.model.TopicDetails;

/**
 * @author virendra
 * 
 * Utitily class for the application
 *
 */
public final class Utils {
	private static final ObjectMapper mapper;
	private static final Validator validator;
	static {
		mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

		Configuration<?> config = Validation.byDefaultProvider().configure();
		ValidatorFactory factory = config.buildValidatorFactory();
		validator = factory.getValidator();
		factory.close();
	}

	public static boolean validateTopicDetails(TopicDetails topic) throws JsonMappingException, JsonProcessingException {
		Set<ConstraintViolation<TopicDetails>> violations = validator.validate(topic);
		//violations.forEach(v -> printError(v));
		System.out.println(violations);
		return violations.size() == 0;
	}

	public static boolean validateTopicDetailsJson(String json) throws JsonMappingException, JsonProcessingException {
		return validateTopicDetails(Utils.jsonToObject(json, TopicDetails.class));
	}

	public static <T> T jsonToObject(String json, Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		return mapper.readValue(json, clazz);
	}

}
