# Limestone
Testing some Google calendar features


# Test environment

OS: Windows 7 Professional

Selenium-api: 3.9.1

Appium version: 1.7.2 

Appium java-client: 5.0.0-BETA6

Android Studio: 3.1.1

Virtual Device: Pixel XL API27, Resolution 1440 x 2560: 560dpi, OS Android 8.1 (Google APIs)

Application under test: native Google calendar provided by the emulator


# How to run tests

launch Appium server

launch virtual device in Android Studio

login in Google account

start Google calendar

walk through the guidance screens manually

close the calendar

pull the project from the repository

launch cmd in project root directory

execute the command: mvn test clean


the other approach is to open the project in Inteliji IDE

go to src\test\java package

run the class CalendarTests


 


