package main

import (
	"fmt"
	"sync"
	"time"
)

var balance = 1000
var mu sync.Mutex

func withdraw(amount int, source string, wg *sync.WaitGroup) {
	defer wg.Done()

	mu.Lock()
	defer mu.Unlock()

	if balance >= amount {
		fmt.Printf("%s withdraw %d\n", source, amount)
		time.Sleep(time.Millisecond * 500)
		balance -= amount
		fmt.Printf("%s completed, New balance: %d\n", source, balance)
	} else{
		fmt.Printf("%s failed: insufficient funds. \n", source)
	}
}

func main() {
	var wg sync.WaitGroup
	wg.Add(2)

	go withdraw(700, "Phone Transfer", &wg)
	go withdraw(500, "ATM Withraw", &wg)

	wg.Wait()
	fmt.Print("Final Balance:", balance)
}