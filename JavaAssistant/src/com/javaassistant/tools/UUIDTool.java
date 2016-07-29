package com.javaassistant.tools;

import java.util.UUID;

public class UUIDTool {

	public static String getUUID() {
		String id = UUID.randomUUID().toString();
		id = id.replace("-", "");
		id = "i"+id;
		return id;
	}

}
