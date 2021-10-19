package com.bpb.publications.authors;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
                 plugin = { "pretty",
                            "json:target/cucumber-report.json"
                 },
                 glue = "com.bpb.publications.authors.stepdef")
public class CucumberTest {
}  
