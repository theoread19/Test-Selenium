package com.ltk.selenuim;

import com.ltk.selenuim.test.TestScenario1;

public class Application {
	public static void main(String[] args) {
		TestScenario1 scenario1 = new TestScenario1();
		scenario1.testCase01();
		scenario1.quitDriver();
	}
}
