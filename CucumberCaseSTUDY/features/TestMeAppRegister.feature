Feature: TestMeApp Registration
  TestMEApp Registration Process

  Scenario Outline: New User Registration with valid values
    Given TestMeaApp home page is open
    When Click on SignUP button
    And Enter "<username>" "<firstname>" "<lastname>" "<password>" "<gender>" "<email>" "<mobile>" "<dob>" "<address>" "<que>" "<ans>"
    Then I verify the <status> in step

    Examples: 
      | username | firstname | lastname | password | gender | email        | mobile     | dob        | address           | que                    | ans    |
      | bgs      | bhagyshri | surose   | bgs@1234 | Female | bgs@mail.com | 8945561223 | 01/01/1998 | surat surat surat | What is your Pet Name? | bugudu |

   