package hooks;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key=PLUGIN_PROPERTY_NAME, value="pretty")
@ConfigurationParameter(key=GLUE_PROPERTY_NAME, value="Steps")
@ConfigurationParameter(key= Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value="false")


public class CucumberTest
{
}
