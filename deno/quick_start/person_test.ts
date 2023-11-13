import { assertEquals } from "https://deno.land/std@0.206.0/assert/mod.ts";
import Person, { sayHello } from "./person.ts";

Deno.test("sayHello function", () => {
  const grace: Person = {
    lastName: "Hopper",
    firstName: "Grace",
  };
  assertEquals("Hello Grace!", sayHello(grace));
});
