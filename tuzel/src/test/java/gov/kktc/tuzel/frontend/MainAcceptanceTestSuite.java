package gov.kktc.tuzel.frontend;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles ("test")
@RunWith (JUnitPlatform.class)
@SuiteDisplayName ("Frontend Acceptance Tests")
@SelectPackages ("gov.kktc.tuzel.frontend.acceptance")
public class MainAcceptanceTestSuite {

}
