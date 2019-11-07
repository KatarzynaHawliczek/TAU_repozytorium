package com.hawliczek.tau.test.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(monochrome=true, plugin = "pretty", features = "src/test/resources/scenarios")
public class RunCucumberTest
{

}
