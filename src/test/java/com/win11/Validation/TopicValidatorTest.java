package com.win11.Validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.win11.util.Utils;

/**
 * @author virendra
 *
 */
public class TopicValidatorTest {
	@ParameterizedTest
	@CsvSource(delimiter = '\t', value = { "{topic: \"A\", name: \"a\", description: \"The quick brown fox jumps over the lazy dog\"}",
			"{topic: \"B\", name: \"x\", description: \"The quick brown fox jumps over\"}" })
	void testTopicValidationSuccess(String json) throws JsonMappingException, JsonProcessingException {
		assertTrue(Utils.validateTopicDetailsJson(json));
	}

	@ParameterizedTest
	@CsvSource(delimiter = '\t', value = { "{topic: \"A\", name: \"b\", description: \"The quick brown fox jumps over the lazy dog\"}",
			"{topic: \"B\", name: \"c\", description: \"The quick brown fox jumps over the lazy dog\"}",
			"{topic: \"A\", name: \"a\", description: \"The quick\"}",
			"{topic: \"B\", name: \"x\", description: \"The quick brown fox jumps over the lazy dog\"}",
			"{topic: \"Z\", name: \"a\", description: \"The quick brown fox jumps over\"}"})
	void testTopicValidationFailure(String json) throws JsonMappingException, JsonProcessingException {
		assertFalse(Utils.validateTopicDetailsJson(json));
	}
}
