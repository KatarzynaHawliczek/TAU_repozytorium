*** Settings ***

Resource      libraries.robot


*** Variables ***

${URL}        http://automationpractice.com/index.php?controller=authentication&back=my-account
${BROWSER}    chrome


*** Keywords ***

Open navigator in desktop resolution
    selenium.Open Browser                ${URL}    ${BROWSER}
    selenium.Set Window Size             1920      1080
    
Open navigator in mobile resolution
    selenium.Open Browser                ${URL}    ${BROWSER}
    selenium.Set Window Size             480       800
    
Close navigator
    selenium.Close Browser   
    
Login with valid credentials
    [Arguments]    ${email}    ${passwd}

    selenium.Input Text                       id=email    ${email}

    selenium.Input Password                   id=passwd    ${passwd}

    selenium.Click Element                    css=#SubmitLogin > span
    
    selenium.Page Should Contain Element      link=Sign out

    selenium.Capture Page Screenshot          filename=login_succesful.png

    selenium.Click Link                       link=Sign out

Login with invalid credentials
    [Arguments]    ${email}    ${passwd}    ${error_msg}

    selenium.Input Text                       id=email     ${email}

    selenium.Input Password                   id=passwd    ${passwd}

    selenium.Click Element                    css=#SubmitLogin > span

    selenium.Page Should Contain Element	  css=div.alert.alert-danger > p:nth-child(1)

    selenium.Element Should Contain           css=div.alert.alert-danger > ol > li   ${error_msg}

    selenium.Page Should Not Contain Element  link=Sign out
    
    selenium.Capture Page Screenshot          filename=login_unsuccesful-{index}.png
    
Register with valid credentials
    [Arguments]    ${email_create}   ${customer_firstname}   ${customer_lastname}       
    ...            ${passwd}         ${address1}             ${city}                   
    ...            ${postcode}       ${phone_mobile}   

    selenium.Input Text                        id=email_create          ${email_create}

    selenium.Click Element                     css=#SubmitCreate > span
    
    selenium.Page Should Not Contain Element   css=create_account_error
    
    selenium.Wait Until Page Contains Element  submitAccount

    selenium.Page Should Contain Element       css=#submitAccount
    
    selenium.Click Element                     id=id_gender2
    
    selenium.Input Text                        id=customer_firstname    ${customer_firstname}
    
    selenium.Input Text                        id=customer_lastname     ${customer_lastname}
    
    selenium.Input Text                        id=passwd                ${passwd}
    
    selenium.Click Element                     css=#days > option:nth-child(19)
    
    selenium.Click Element                     css=#months > option:nth-child(7)
    
    selenium.Click Element                     css=#years > option:nth-child(37)
    
    selenium.Input Text                        id=address1              ${address1}
    
    selenium.Input Text                        id=city                  ${city}
    
    selenium.Click Element                     css=#id_state > option:nth-child(7)    
    
    selenium.Input Text                        id=postcode              ${postcode}
    
    selenium.Click Element                     css=#id_country > option:nth-child(2)
    
    selenium.Input Text                        id=phone_mobile          ${phone_mobile}   
    
    selenium.Click Element                     css=#submitAccount > span      
    
    selenium.Page Should Contain Element       link=Sign out     

    selenium.Capture Page Screenshot           filename=register_succesful.png

    selenium.Click Link                        link=Sign out
    
Register with invalid email
    [Arguments]    ${email_create}    ${error_msg}

    selenium.Input Text                        id=email_create     ${email_create}

    selenium.Click Element                     css=#SubmitCreate > span
    
    selenium.Page Should Contain Element       css=#create_account_error

    selenium.Page Should Contain Element	   css=div.alert.alert-danger
    
    selenium.Wait Until Page Contains Element  css=div.alert.alert-danger > ol > li

    selenium.Element Should Contain            css=div.alert.alert-danger > ol > li   ${error_msg}

    selenium.Page Should Not Contain Element   link=Sign out
    
    selenium.Capture Page Screenshot           filename=register_unsuccesful_email-{index}.png
    
Register with invalid credentials
    [Arguments]    ${customer_firstname}   ${customer_lastname}       
    ...            ${passwd}         ${address1}             ${city}                   
    ...            ${postcode}       ${phone_mobile}    ${error_msg}

    selenium.Input Text                        id=email_create     kaha555@vp.pl

    selenium.Click Element                     css=#SubmitCreate > span

    selenium.Page Should Not Contain Element   css=create_account_error
    
    selenium.Wait Until Page Contains Element  submitAccount

    selenium.Page Should Contain Element       css=#submitAccount
    
    selenium.Click Element                     id=id_gender2
    
    selenium.Input Text                        id=customer_firstname    ${customer_firstname}
    
    selenium.Input Text                        id=customer_lastname     ${customer_lastname}
    
    selenium.Input Text                        id=passwd                ${passwd}
    
    selenium.Click Element                     css=#days > option:nth-child(19)
    
    selenium.Click Element                     css=#months > option:nth-child(7)
    
    selenium.Click Element                     css=#years > option:nth-child(37)
    
    selenium.Input Text                        id=address1              ${address1}
    
    selenium.Input Text                        id=city                  ${city}
    
    selenium.Click Element                     css=#id_state > option:nth-child(7)    
    
    selenium.Input Text                        id=postcode              ${postcode}
    
    selenium.Click Element                     css=#id_country > option:nth-child(2)
    
    selenium.Input Text                        id=phone_mobile          ${phone_mobile}   
    
    selenium.Click Element                     css=#submitAccount > span 

    selenium.Page Should Contain Element	   css=div.alert.alert-danger > p:nth-child(1)

    selenium.Element Should Contain            css=div.alert.alert-danger > p  ${error_msg}

    selenium.Page Should Not Contain Element   link=Sign out
    
    selenium.Capture Page Screenshot           filename=register_unsuccesful_form_valid.png