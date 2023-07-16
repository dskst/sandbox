package main

import "golang.org/x/tour/reader"

type MyReader struct{}

func (r MyReader) Read([]byte) (int, error) {
	return 0, nil
}

func main() {
	reader.Validate(MyReader{})
}
