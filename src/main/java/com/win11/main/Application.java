package com.win11.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.win11.util.Utils;

/**
 * @author virendra
 * 
 * The main class for the application
 * 
 * Write a validator to check following rules:
 * 1. If topic == A, then name will be “a”and description will be more than 10 and less than 100 chars
 * 2. If topic == B, then name will be “x” and description will be less than 40 chars
 * Note: there will be more topic D, E, F …. In the future and combinations of validation rules on name and description are varying.
 * 
 * 
 *
 */
public class Application {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String json = "{topic: \"A\", name: \"z\", description: \"The quick brown fox jumps over the lazy dog\"}";
		Utils.validateTopicDetailsJson(json);
	}
}