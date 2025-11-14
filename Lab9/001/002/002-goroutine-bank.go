package main

import(
	"fmt"
	"time"
)

var balance = 1000

func withdraw(amount int, source string) {
	if balance >= amount {
		fmt.Printf("%s withdraw %d\n", source, amount)
		time.Sleep(time.Millisecond * 500)
		balance -= amount
		fmt.Printf("%s completed, New balance: %d\n", source, balance)
	} else {
		fmt.Printf("%s failed: insufficient funds.\n", source)
	}
}

func main() {
	go withdraw(700, "Phone Transfer")
	go withdraw(500, "ATM Withdraw")

	time.Sleep(2 * time.Second)
	fmt.Println("Final Balance:", balance)
}