import express from "npm:express@4";

const app = express();

app.get("/", (request, response) => {
  response.send("Hello World!");
});

app.listen(3000);
