package main

import (
	"fmt"
)

var factory = map[string]func() Executor{
	"code_a": func() Executor {
		return &ImplementationA{}
	},
	"code_b": func() Executor {
		return &ImplementationB{}
	},
}

type Executor interface {
	Execute()
}

type ImplementationA struct{}

func (i ImplementationA) Execute() {
	fmt.Println("Implementation A executed")
}

type ImplementationB struct{}

func (i ImplementationB) Execute() {
	fmt.Println("Implementation B executed")
}

func main() {
	var executor Executor
	code := "code_a" // or "code_b"
	executor = factory[code]()
	executor.Execute()
}
