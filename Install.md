

## Tools/Lib Details

Maven,TestNg, Selenium,gson, apache.commons-lang(for FileUtil)

slf4j-log4j12(logging)


## run

navigate to project directory ./automation.qa.mercedes.benz

​
#### Prerequisites

java1.8 is used for compilation
chrome.app should be present in mac
or chromne.exe in windows check paths in configurableData.json
"MacChromeBinaryPath":"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome",
"LinuxChromeBinaryPath":"/bin/google-chrome",
"WindowsChromeBinaryPath":"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",

#### Steps to run

run with mvn commands

mvn clean install

mvn test

## Reports

after run verify emailable-report.html  target/surefire-reports to check which tests 

## screenShots

for failed test check screenShot folder

## Package Info
#### com.mercedes.benz.selenium.base
contains base classes from which test classes would inherit

for all test classes in package(com.mercedes.benz.selenium.tests) base class is BaseSeleniumSetup.java

for all pages class in package (com.mercedes.benz.selenium.pages) base class is BaseSeleniumWebPageAction.java

BaseSeleniumSetup: purpose is to Initialize driver, navigation to pages, close driver

​
BaseSeleniumWebPageAction: It has all selenium webpage action which is useful in pages class to interact with selenium elements.

#### com.mercedes.benz.selenium.driverbase 

contains all driver manager code and called in BaseSeleniumSetup.java setup().

It initializes driver based on browser and underlying os.



#### com.mercedes.benz.selenium.tests
contains test classes. 
test class has corresponding page in pages package where all interaction logic is kept.

test is supplied with testdatafile for ex: src/test/resources/E2ETestData.json in setup to read testdata input or expected


#### com.mercedes.benz.selenium.pages
Depending upon the web pages interaction here page classes are created
each page class represents a web page or a widget on web page
It has locators to find element and extend to BaseWebPageAction.java to interact with elements

#### com.mercedes.benz.dataReader: 
TestDataGson.java to process testdatafile so that data is read from file
common.java has readTestData  that could be used beyond selenium tests also

BaseSeleniumSetup.java->DriverManagerFactory->common

#### appModules: 

It has reusable actions(need to add more for modular design)


#### listners: 

A custom listener is created to execute takescreenshot on failed test cases.



