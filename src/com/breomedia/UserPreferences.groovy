package com.breomedia

class UserPreferences {
	
	String owner
	String keywords
	boolean alertViaEmail
	int runInterval
	
	String toString() {
		"owner: $owner, keywords: $keywords, alertViaEmail: $alertViaEmail, runInterval: $runInterval"
	}
}