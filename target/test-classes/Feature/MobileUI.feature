Feature: Cucumber to do Test Mobile UI
    Scenario: MobileUI Build Object Repo From a Page
        Given open the Browser
        |SiteName| Device |
        | http://www.freecrm.com | Mobile |
        Then store all Links
        Then store all staticText
        Then store all image

