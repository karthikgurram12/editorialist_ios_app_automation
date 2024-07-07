Framework Setup Steps:

Apple ID was needed to setup WDA in real iOS device.
Find the bundle id for the app 
    * Get id from App Store - id1254234652	
    * https://itunes.apple.com/lookup?id=1254234652 (downloaded file from iTunes)
    * com.ProjectyxLLC.Projectyx.Appstore
Launched the application with below capabilities first in appium inspector.
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
Configured the Maven and java project in IntelliJ
Add the dependencies 
	* appium java client 
        * selenium
        * TestNG
        * Appium
Get data from properties file using config.properties
Added POM Design pattern support for the TestNG Framework
Uploaded the code to git
