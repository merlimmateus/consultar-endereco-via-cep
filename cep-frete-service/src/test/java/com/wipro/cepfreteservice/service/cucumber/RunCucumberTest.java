package com.wipro.cepfreteservice.service.cucumber;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/java/com/wipro/cepfreteservice/service/cucumber/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.wipro.cepfreteservice.service.cucumber")
public class RunCucumberTest {
}