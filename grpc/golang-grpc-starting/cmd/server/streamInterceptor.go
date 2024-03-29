package main

import (
	"errors"
	"google.golang.org/grpc"
	"io"
	"log"
)

func myStreamServerInterceptor1(srv interface{}, ss grpc.ServerStream, info *grpc.StreamServerInfo, handler grpc.StreamHandler) error {
	log.Println("[pre stream] my stream server interceptor 1: ", info.FullMethod)
	err := handler(srv, &myServerStreamWrapper1{ss})

	log.Println("[post stream] my stream server interceptor 1: ")
	return err
}

type myServerStreamWrapper1 struct {
	grpc.ServerStream
}

func (s *myServerStreamWrapper1) RecvMsg(m interface{}) error {
	err := s.ServerStream.RecvMsg(m)
	if !errors.Is(err, io.EOF) {
		log.Println("[stream] my stream server interceptor 1: ", m)
	}
	return err
}

func (s *myServerStreamWrapper1) SendMsg(m interface{}) error {
	log.Println("[stream] my stream server interceptor 1:", m)
	return s.ServerStream.SendMsg(m)
}
