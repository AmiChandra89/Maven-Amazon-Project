package com.cucumber.bdd.helper.generic;

public class InitializeTestCase {
	InitializeWebDrive drive;

	public void initiateBroweser(String bType) {
		try {
			drive = new InitializeWebDrive();
			drive.setUpDriver(bType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void terminateDrivers() throws Exception {
		drive.tearDownDriver();
	}
}
