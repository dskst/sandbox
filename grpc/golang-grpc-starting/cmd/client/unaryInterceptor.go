package main

import (
	"context"
	"google.golang.org/grpc"
	"log"
)

func myUnaryClientInterseptor1(ctx context.Context, method string, req, reply interface{}, cc *grpc.ClientConn, invoker grpc.UnaryInvoker, opts ...grpc.CallOption) error {
	log.Println("[pre] my unary client interceptor 1: ", method)
	err := invoker(ctx, method, req, reply, cc, opts...)
	log.Println("[post] my unary client interceptor 1: ", method)
	return err
}
