package com.win11.model;

import com.win11.validation.Topic;

/**
 * @author virendra
 *
 */
@Topic
public class TopicDetails {
	private String topic;
	private String name;
	private String description;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "JsonPayload [topic=" + topic + ", name=" + name + ", description=" + description + "]";
	}
	// record JsonPayload(String topic, String name, String description) {}
}
