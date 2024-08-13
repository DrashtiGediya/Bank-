# Bank-
This is a simple banking system API built with Spring Boot. It includes features for depositing, withdrawing, showing balance, and transferring money.

## Features

- **Deposit Money**: Add funds to an account.
- **Withdraw Money**: Remove funds from an account.
- **Show Balance**: Check the current balance of an account.
- **Transfer Money**: Transfer funds between accounts.

## Technologies Used

- **Spring Boot**: Framework for building Java applications.
- **Spring Data JPA**: For data persistence.
- **MySql Database**: In-memory database for testing.
- **Maven**: Build and dependency management tool.

## API Endpoints

- **Deposit Money**
    - `PUT /bank/deposite?accountNo=accountNo&amount=50.0`
   
- **Withdraw Money**
    - `PUT /bank/withdraw?accountNo=accountNo&amount=20.0`

- **Show Balance**
    - `GET /bank//getBalance/{accountNo}`
- **Transfer Money**
    - `PUT /bank/transfer`
    - Request Body: `{ "fromAccountId": 1, "toAccountId": 2, "amount": 20.0 }`
 
    - ## Contributing

Feel free to submit issues or pull requests if you would like to contribute to the project.
