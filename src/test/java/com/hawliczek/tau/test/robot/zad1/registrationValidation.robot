*** Settings ***

Documentation     Test suite to validate the registration action

Resource          keywords.robot

Suite Setup       Open navigator in mobile resolution 
Suite Teardown    Close navigator


***Variables***

${email_create}            kaha666@vp.pl
${customer_firstname}      Kasia
${customer_lastname}       Hawel 
${passwd}                  abcdef
${address1}                Kasztanowa 6c
${city}                    Malbork
${postcode}                12345
${phone_mobile}            123456789


*** Test Cases ***

Scenario 01: Successful Registration
    Register with valid credentials    ${email_create}
    ...                                ${customer_firstname}     
    ...                                ${customer_lastname}       
    ...                                ${passwd}                  
    ...                                ${address1}               
    ...                                ${city}                   
    ...                                ${postcode}               
    ...                                ${phone_mobile}    

Scenario 02: Unsuccessful Registration ( email validation )
    [Template]                 Register with invalid email
    ${email_create}            An account using this email address has already been registered. Please enter a valid password or request a new one.
    ${empty}                   Invalid email address.
    invalid                    Invalid email address.  
    
Scenario 03: Unsuccessful Registration ( registration form validation )
    Register with invalid credentials    123
    ...                                  456   
    ...                                  xyz   
    ...                                  ${empty}   
    ...                                  ^&^   
    ...                                  666   
    ...                                  0000 
    ...                                  There are 5 errors   
                                         