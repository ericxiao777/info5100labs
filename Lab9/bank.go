package main

import "fmt"

var bank string = "BMO"

func main() {
	location := "Toronto"
	est := 1817
	
	displayBankInfo(location, est)
}

func displayBankInfo(location string, est int){
	fmt.Println("Bank Name", bank)
	fmt.Println("Location", location)
	fmt.Println("Established in", est)
}
