#VTA-RestAssuredProject

To automate API with Rest-Assured Java TestNG with Allure reports

### Installation/SetUp

Pre-requisites : JAVA, IDE and Allure command line
 
Allure commandline latest version can be downloaded through download link from the below url.

https://github.com/allure-framework/allure2/releases

## Run Tests

Run the tests as TestNG tests. Right click on RetailGetNAVPriceList.java file -> Run As -> TestNG Test

allure-results folder will be created in the project directory.

## Reports
- Navigate to Allure command line bin folder in command line prompt
	eg: ...\allure-2.13.2\bin
	
- Run the below command on the prompt
	allure serve "allure-results project directory" 
	eg: ...\eclipse-ws\VTA-RestAssuredProject\allure-results
	
- Allure report will be opened in the default browser.
