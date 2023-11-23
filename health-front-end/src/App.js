import { useEffect } from "react";
import "./App.css";

function App() {
  //console.log("Hello World!");

  useEffect(() => {
    fetch("http://localhost:8080/auth/register", {
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username: "user123",
        password: "password123",
      }),
      method: "post",
    }).then((response) => {
      if (response.status === 200) {
        console.log("success");
      }
    });
  }, []);

  return (
    <div className="App">
      <h1>Hello World!</h1>
    </div>
  );
}

export default App;
