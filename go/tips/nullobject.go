package main

import "fmt"

type ExampleObject struct {
	Id string
}

var NilExampleObject = ExampleObject{}

func (e *ExampleObject) IsNil() bool {
	return *e == NilExampleObject
}

func main() {
	var object ExampleObject
	if object.IsNil() {
		fmt.Println("object is nil")
	}
}
