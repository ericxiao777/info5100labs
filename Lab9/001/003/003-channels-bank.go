package main

 

import (

    "fmt"

    "time"

)

 

// Transaction represents a request to withdraw from a customer account

type Transaction struct {

    Amount     int

    Source     string

    CustomerID string

}

 

// Ledger stores balances for both customer and bank

type Ledger struct {

    CustomerBalance int

    BankBalance     int

}

 

// transactionProcessor receives transactions from the channel

// and performs double-entry accounting:

//   - Debit (subtract) from the customer

//   - Credit (add) to the bank

func transactionProcessor(ledger *Ledger, txChan chan Transaction) {

    for tx := range txChan {

        fmt.Printf("Processing: %s withdrawing %d for customer %s\n",

            tx.Source, tx.Amount, tx.CustomerID)

 

        time.Sleep(time.Millisecond * 300) // simulate processing delay

 

        // Double-entry accounting

        if ledger.CustomerBalance >= tx.Amount {

            ledger.CustomerBalance -= tx.Amount  // Debit customer

            ledger.BankBalance += tx.Amount      // Credit bank

 

            fmt.Printf("✅ Transaction complete. Customer: %d | Bank: %d\n",

                ledger.CustomerBalance, ledger.BankBalance)

        } else {

            fmt.Printf("❌ Transaction failed: insufficient funds for %s\n", tx.CustomerID)

        }

    }

}

 

func main() {

    // Initial balances

    ledger := Ledger{

        CustomerBalance: 1000,

        BankBalance:     5000,

    }

 

    // Channel for sending transaction requests

    txChan := make(chan Transaction)

 

    // Start the processor

    go transactionProcessor(&ledger, txChan)

 

    // Send two concurrent banking transactions into the channel

    go func() {

        txChan <- Transaction{Amount: 700, Source: "Phone Transfer", CustomerID: "CUST1001"}

    }()

 

    go func() {

        txChan <- Transaction{Amount: 500, Source: "ATM Withdrawal", CustomerID: "CUST1001"}

    }()

 

    // Give goroutines time to send transactions

    time.Sleep(time.Second * 2)

 

    // Close channel (optional for this demo)

    close(txChan)

 

    fmt.Println("\nFinal Balances:")

    fmt.Println("Customer Balance:", ledger.CustomerBalance)

    fmt.Println("Bank Balance:", ledger.BankBalance)

}

