package main

import "fmt"

var balance = 1000

func withdraw(amount int, source string) {
	if balance >= amount {
		fmt.Printf("%s withdraw %d\n", source, amount)
		balance -= amount
	} else {
		fmt.Printf("%s failed: insufficient funds\n", source)
	}
}

func main() {
	withdraw(300, "Phone Transfer")
	withdraw(500, "ATM Withdraw")
	withdraw(500, "Outer space")

	fmt.Println("Final Balance:", balance)
}
