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
