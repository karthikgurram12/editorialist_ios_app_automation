Framework Setup Steps:

1. Apple ID was needed to setup WDA in real iOS device.
2. Find the bundle id for the app 
    * Get id from App Store - id1254234652	
    * https://itunes.apple.com/lookup?id=1254234652 (downloaded file from iTunes)
    * com.ProjectyxLLC.Projectyx.Appstore
3. Launched the application with below capabilities first in appium inspector.
{
  "appium:automationName": "XCUITest",
  "appium:deviceName": "Karthik iPhone",
  "appium:noReset": true,
  "platformName": "iOS",
  "appium:platformVersion": "17.5",
  "appium:maxTypingFrequency": "30",
  "appium:bundleId": "com.ProjectyxLLC.Projectyx.Appstore",
  "appium:udid": "00008030-001A2DEC14D8C02E",
}
Note: for first time WDA installation only we needed xcodeOrgId, xcodeSigningId, from second time it's not required
 4. Configure the Maven and java project in IntelliJ
 5.  Add the dependencies 
	* appium java client 
        * selenium
        * TestNG
        * Appium
6. Get data from properties file using config.properties
7. Added POM Design pattern support for the TestNG Framework
8. Uploaded the code to git
9. Updated desired caps as dynamic values coming from config.properties.
10. Added testNG.xml file to run as a suite.
11. Added Logging statements in BaseTest using slf4j dependency.
12. Identify elements with AppiumBy in Page Object Model (POM) classes
13. Added Jackson dependency to read test_accounts.json containing account details with it’s test data