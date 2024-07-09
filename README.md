# Console ATM

**Description**

The user must enter a valid card number matching the template and the correct PIN to access the account. After successful authorization, the user can:
- check the card balance;
- withdraw funds from the account, not exceeding the amount on the current account or the limit of funds in the ATM;
- replenish the balance (the replenishment amount must not exceed 1,000,000).

**Additional functionality**

- console menu for the application;
- data storage in a text file with a space separator (" ");
- the card number should be of the form: "XXXX-XXX-XXX-XXX-XXX-XXX-XXXX";
- the program saves its state after completion (the data file must be updated);
- all messages about successful actions and errors should be displayed on the console.
- .bat file to run the application;
- PIN-code can be entered incorrectly 3 times, after that the card should be blocked;
- card blocking is removed automatically after a day.


**Application start**

To run this application you can run the .bat file, which is located at the path: ConsoleATM/out/artifacts/ConsoleATM_jar/run_app.bat 

**Initial values**

- card number: 1111-1111-1111-1111
- pin code: 1111

**Examples of how the application works**

- _Identification and authentication process_

![Identification and authentication process](https://github.com/EzerskiyK/Console-ATM/blob/main/imageFileForGitHub/1.png)

- _Menu_

  ![Menu](https://github.com/EzerskiyK/Console-ATM/blob/main/imageFileForGitHub/2.png)

  - _Check balance_

  ![check balance](https://github.com/EzerskiyK/Console-ATM/blob/main/imageFileForGitHub/3.png)

  - _Withdarawl_

  ![withdarawl](https://github.com/EzerskiyK/Console-ATM/blob/main/imageFileForGitHub/4.png)

  ![withdarawl](https://github.com/EzerskiyK/Console-ATM/blob/main/imageFileForGitHub/5.png)

  - _Top Up_

  ![withdarawl](https://github.com/EzerskiyK/Console-ATM/blob/main/imageFileForGitHub/6.png)
  
  ![withdarawl](https://github.com/EzerskiyK/Console-ATM/blob/main/imageFileForGitHub/7.png)

  
