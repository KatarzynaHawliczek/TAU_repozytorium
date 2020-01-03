*** Settings ***

Documentation     Test suite to validate the login action

Resource          keywords.robot

Suite Setup       Open navigator in desktop resolution                       
Suite Teardown    Close navigator


***Variables***

${email}       kaha123@vp.pl
${passwd}      123456


*** Test Cases ***

Scenario 01: Successful Login
    Login with valid credentials    ${email}
    ...                             ${passwd}

Scenario 02: Unsuccessful Login
    [Template]                      Login with invalid credentials
    invalid                         ${passwd}                       Invalid email address.
    ${email}                        invalid                         Authentication failed.
    ${empty}                        ${empty}                        An email address required.
    ${email}                        ${empty}                        Password is required.
    ${empty}                        ${passwd}                       An email address required.