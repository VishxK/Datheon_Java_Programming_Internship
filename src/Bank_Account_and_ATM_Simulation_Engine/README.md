# Bank Account and ATM Simulation Engine

A console-based Java application that simulates common ATM and bank-account operations. The application demonstrates object-oriented design, account inheritance, customer authentication, transaction logging, and domain-specific exception handling.

All data is created in memory when the application starts. No database, external service, or third-party library is required.

## Features

- Authenticate customers using a customer ID and four-digit PIN.
- View balances for all accounts belonging to the authenticated customer.
- Deposit funds into savings or checking accounts.
- Withdraw funds with account-specific validation.
- Support savings accounts with a required minimum balance.
- Support checking accounts with a configurable overdraft limit.
- Record opening, deposit, and withdrawal transactions.
- Print a timestamped audit trail for every account.
- Handle invalid menu selections, numeric input, PINs, and transaction requests.
- Log out securely and return to the main ATM menu.

## Technology Stack

- **Language:** Java
- **JDK:** 17 or newer
- **Libraries:** Java Standard Library only
- **Interface:** Command-line console
- **Build system:** Direct `javac` compilation or IntelliJ IDEA

## Project Structure

```text
Bank_Account_and_ATM_Simulation_Engine/
├── ATM.java                       # Application entry point and console workflow
├── Account.java                   # Abstract account base class and common operations
├── SavingsAccount.java             # Savings account minimum-balance rules
├── CheckingAccount.java            # Checking account overdraft rules
├── Customer.java                   # Customer identity, PIN verification, and accounts
├── Transaction.java                # Timestamped transaction record
├── InsufficientFundsException.java # Withdrawal-limit exception
├── InvalidPINException.java        # Authentication exception
└── README.md
```

## Prerequisites

Install **JDK 17 or newer** and verify that Java is available on your `PATH`:

```text
java -version
javac -version
```

No package manager, database, or additional dependency is required.

## Run from the Command Line

From the repository root, compile the application:

### Windows

```bat
javac -d out\production\Datheon_Java_Programming_Internship src\Bank_Account_and_ATM_Simulation_Engine\*.java
java -cp out\production\Datheon_Java_Programming_Internship Bank_Account_and_ATM_Simulation_Engine.ATM
```

### macOS/Linux

```bash
mkdir -p out/production/Datheon_Java_Programming_Internship
javac -d out/production/Datheon_Java_Programming_Internship src/Bank_Account_and_ATM_Simulation_Engine/*.java
java -cp out/production/Datheon_Java_Programming_Internship Bank_Account_and_ATM_Simulation_Engine.ATM
```

## Run in IntelliJ IDEA

1. Open the repository in IntelliJ IDEA.
2. Configure the project to use JDK 17 or newer.
3. Open `src/Bank_Account_and_ATM_Simulation_Engine/ATM.java`.
4. Run the `main` method in `ATM`.

## Sample Customers

The application loads two sample customers at startup:

| Customer ID | Name | PIN | Accounts |
| --- | --- | --- | --- |
| `001` | Kasun Perera | `1234` | Savings `SAV-1001` (Rs. 500.00); Checking `CHK-1001` (Rs. 300.00, Rs. 150.00 overdraft limit) |
| `002` | Vishwa Omalka | `5678` | Savings `SAV-1002` (Rs. 1,250.00) |

These credentials are intended only for demonstration and learning purposes.

## Application Workflow

When the application starts, it displays the main ATM menu:

| Option | Action |
| --- | --- |
| `1` | Insert card / log in using a customer ID and PIN |
| `2` | Exit the ATM |

After successful authentication, the customer account menu provides:

| Option | Action |
| --- | --- |
| `1` | View balances for all linked accounts |
| `2` | Deposit funds into a selected account |
| `3` | Withdraw funds from a selected account |
| `4` | Print the audit transaction trail |
| `5` | Log out |

## Account Rules

### Savings accounts

- A savings account must be opened with at least **Rs. 100.00**.
- Withdrawals are allowed only when the resulting balance remains at least **Rs. 100.00**.
- Deposit and withdrawal amounts must be greater than zero.

### Checking accounts

- Withdrawals may reduce the balance below zero.
- The resulting balance cannot be lower than the configured overdraft limit.
- For example, an account with a `Rs. 150.00` overdraft limit may reach `-Rs. 150.00`, but not below it.
- Deposit and withdrawal amounts must be greater than zero.

## Transaction Audit Trail

Each account starts with an `OPENING` transaction. Successful deposits and withdrawals append a new transaction containing:

- Timestamp
- Transaction type
- Transaction amount
- Resulting account balance

Rejected transactions do not change the balance and are not added to the transaction log.

## Design Overview

- `ATM` manages application startup, sample data, console input, authentication, menus, and customer operations.
- `Customer` stores customer identity, PIN verification, and the customer’s accounts.
- `Account` defines shared account state and deposit behavior while requiring subclasses to implement withdrawal rules.
- `SavingsAccount` and `CheckingAccount` provide specialized withdrawal policies through inheritance.
- `Transaction` represents an immutable audit record.
- `InvalidPINException` and `InsufficientFundsException` make authentication and withdrawal failures explicit.

## Limitations

- Data is stored only in memory and is lost when the application exits.
- Customer PINs are stored as plain text for demonstration purposes; this is not suitable for production authentication.
- The application uses `double` for currency calculations. A production banking system should use a decimal-safe representation such as `BigDecimal`.
- There is no card reader, persistent storage, account creation flow, transfer feature, or automated test suite.
- The project does not currently include a Maven or Gradle build configuration.
- The application is intended for one interactive console session at a time.

## License

No license for this project.
