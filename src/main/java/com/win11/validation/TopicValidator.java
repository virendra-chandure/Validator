package com.win11.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.win11.model.TopicDetails;

/**
 * @author virendra
 * 
 * This class validates the topic details based on topic, name and description length
 *
 */
public class TopicValidator implements ConstraintValidator<Topic, TopicDetails> {

	@Override
	public void initialize(Topic topic) {
	}

	@Override
	public boolean isValid(TopicDetails payload, ConstraintValidatorContext ctx) {
		String topic = payload.getTopic();
		String name = payload.getName();
		int descLength = null == payload.getDescription() ? 0 : payload.getDescription().length();

		boolean isValid = switch (topic) {
		case "A" -> "a".equals(name) && descLength > 10 && descLength < 100;
		case "B" -> "x".equals(name) && descLength < 40;
		// default -> throw new IllegalArgumentException("Invalid Topic: " + payload.getTopic());
		default -> false;
		};
		if(!isValid)
			ctx.buildConstraintViolationWithTemplate("Topic: "+topic+", Name: "+name+", Desc Lenght: "+descLength).addConstraintViolation();
		return isValid;
	}

}