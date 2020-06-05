This is sample project with for API Automation framework using Java, restAssured, Gradle and TestNG.

Rest API : http://dummy.restapiexample.com/

**1.Utils**

    JsonHelper -> get Json string from object and vice versa
    RandomHelper -> contains a method which will generate and give a random number
    Categories -> provides categories which can be used as tags to run TestNG tests

**2.Properties** -> provides method to set host when running scripts across different environments

**3.Reporting** -> basic HTML report with TestNG

**4.ScenarioContext** -> provides usage of user defined variable to store data and access anywhere to drive E2E scenarios

**5.Slack** -> basic slack channel integration is done which triggers about No of Pass/Failed tests

**6.SampleTests** -> Following tests are automated

        Get All Employees List : http://dummy.restapiexample.com/api/v1/employees
        Add Employee : http://dummy.restapiexample.com/api/v1/create



**Note:**

        * For running tests via IntellIJ use "-ea -Denv=prod -Dtags=SMOKE"
        * For running tests via commandline use "./gradlew runTests -Denv=prod -Dtags=SMOKE"

