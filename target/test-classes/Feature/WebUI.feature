Feature: WebUI Cucumber to do Build own Object repository Dynamically
    Scenario: WebUI Build Object Repo From a Page
        Given open the Browser
        |SiteName| Device |
        | http://www.freecrm.com | Browser |
        Then store all Links
        Then store all staticText
        Then store all image

