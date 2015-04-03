package com.soft.bDD;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"com.soft.bDD"}
		)
public class TestRunner {

	public static void main(String[] args) {

	}

}
