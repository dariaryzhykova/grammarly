# Grammarly


# Overview of automation for Grammarly Website: https://www.grammarly.com/

## Technology stack

Java + JUnit5 + Selenide + Gradle

| Java | Gradle | Junit5 | Selenide |
|:----:|:------:|:------:|:--------:|
| <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> |

The tests are run by Jenkins + Selenoid

| Jenkins | Selenoid | 
|:--------:|:-------------:|
| <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | 

Reporting in Allure + Telegram
| Allure Report | Telegram |
|:---------:|:--------:|
| <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |

Automated with love
| Love |
|:---------:|
| <img src="images/heart.png" width="40" height="40"> |


## Use Jenkins job to run tests https://jenkins.autotests.cloud/job/jenkins-grammarly/

### The job could be run with the following parameters:

* browser (default chrome)
* browserVersion (default 90.0)
* browserSize (default 1920x1080)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)

### Example of choosing parameters in Jenkins
![alt "Job Parameters"](./images/jenkinsParamsExample.png)

### How to run test from command line
Запустить тесты с дефолтными параметрами:
```bash
gradle clean test
```

Run tests with parameters:
```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Test report results in Allure:
```bash
allure serve build/allure-results
```
## Run tests in Selenoid https://selenoid.autotests.cloud/#/
### Example of test run in Selenoid
![alt "Video from Selenoid"](./images/TestExample.gif "Video from Selenoid")


## Test Report in Allure
![alt "Allure report"](./images/AllureNotifications.png)
Find usefull attachments in every test cases(logs, screenshots and video)
![alt "Select parameters"](./images/Attachments.png)

## Test results in AllureTestOps with auttomated and manually addded test cases
![alt "AllureTestOps"](./images/AllureTestOps.png)

## Telegram notification of test results (join to the telegram group: @grammarly_test)
![alt "Выбор параметров"](./images/TelegramNotifications.png)


## Contacts
:world_map: <a target="_blank" href="https://www.linkedin.com/in/daria-ryzhykova-3794b3139/">linkedin</a><br/>
:airplane: Telegram - @darielllla


