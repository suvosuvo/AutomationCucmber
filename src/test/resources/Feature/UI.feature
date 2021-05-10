Feature: Cucumber to do Build own Object repository Dynamically
    Scenario: WebUI Build Object Repo From a Page
        Given open the Browser
        |SiteName|
        | http://www.freecrm.com |
        Then store all Links
        Then store all staticText

