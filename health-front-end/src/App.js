import "./App.css";

function App() {
  console.log("Hello World!");

  fetch("auth/login", {
    headers: {
      "Content-Type": "application/json",
    }, 
    method: "post",
  });

  return (
    <div className="App">
      <h1>Hello World!</h1>
    </div>
  );
}

export default App;
