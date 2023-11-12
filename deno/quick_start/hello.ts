import Person, { sayHello } from "./person.ts";

const ada: Person = {
  lastName: "Lovelace",
  firstName: "Ada",
};

console.log(sayHello(ada));

const site = await fetch("https://www.deno.com");
console.log(await site.text());

Deno.serve((_request: Request) => {
  return new Response("Hello World");
});
