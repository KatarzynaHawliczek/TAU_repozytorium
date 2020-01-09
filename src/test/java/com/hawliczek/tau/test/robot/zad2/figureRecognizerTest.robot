*** Settings ***
Documentation   Test of FigureRecognizer application
Library         OperatingSystem


*** Variables ***
${SRC_PATH}    /D:/Notatki/Semestr7/TAU/TAU_repozytorium/target/test-classes/com/hawliczek/tau/test/robot/zad2/


*** Keywords ***
Compile Class
    [Arguments]  ${class_name}  ${path}=${SRC_PATH}
    Run    javac ${path}${class_name}.java

    
Run Java Class
    [Arguments]    ${class_name}    ${path}=${SRC_PATH}
    Compile Class  ${path}  ${class_name}
    ${output}=    Run    java -cp ${path}${class_name}
    Log    ${output}
    [return]    ${output}

Run Java Class With Args
    [Arguments]    ${class_name}    ${args}    ${path}=${SRC_PATH}   
    Compile Class  ${path}  ${class_name} 
    ${output}=    Run    java -cp ${path}${class_name} ${args}
    Log    ${output}
    [return]    ${output}

    
*** Test Cases ***
Check if can build a triangle when 3 equal sides are given
    ${result} =    Run Java Class With Args    FigureRecognizer    5 5 5 2
    Should be equal as strings    ${result.replace("\n", " ")}    Figura jest trójkątem Trójkąt o bokach a=5 b=5 c=5 jest równoboczny
    
Check if can build a triangle when 2 equal sides and 1 different side are given
    ${result} =    Run Java Class With Args    FigureRecognizer    10 10 5 2
    Should be equal as strings    ${result.replace("\n", " ")}    Figura jest trójkątem Trójkąt o bokach a=10 b=10 c=5 jest równoramienny

Check if can build a triangle when 3 different sides are given
    ${result} =    Run Java Class With Args    FigureRecognizer    3 4 5 2
    Should be equal as strings    ${result.replace("\n", " ")}    Figura jest trójkątem Trójkąt o bokach a=3 b=4 c=5 jest różnoboczny
    
Check if can't build a triangle when 3 different sides are given
    ${result} =    Run Java Class With Args    FigureRecognizer    4 6 10 2
    Should be equal as strings    ${result.replace("\n", " ")}    To nie jest trójkąt
    
Check if can build a quadrangle when 4 equal sides are given
    ${result} =    Run Java Class With Args    FigureRecognizer    5 5 5 1 5
    Should be equal as strings    ${result.replace("\n", " ")}    Figura jest czworobokiem Czworokąt o bokach a=4 b=4 c=4 d=4 jest kwadratem lub rombem
    
Check if can build a quadrangle when 2 pairs of equal sides are given
    ${result} =    Run Java Class With Args    FigureRecognizer    6 3 6 1 3
    Should be equal as strings    ${result.replace("\n", " ")}    Figura jest czworobokiem Czworokąt o bokach a=6 b=3 c=6 d=3 jest prostokątem lub równoległobokiem
    
Check if can build a quadrangle when 4 different sides are given
    ${result} =    Run Java Class With Args    FigureRecognizer    10 5 8 1 4
    Should be equal as strings    ${result.replace("\n", " ")}    Figura jest czworobokiem Czworokąt o bokach a=10 b=5 c=8 d=4 nie jest ani kwadratem, ani rombem, ani prostokątem, ani równoległobokiem
    
Check if can't build a quadrangle when 4 different sides are given
    ${result} =    Run Java Class With Args    FigureRecognizer    20 1 5 1 8
    Should be equal as strings    ${result.replace("\n", " ")}    To nie jest czworobok