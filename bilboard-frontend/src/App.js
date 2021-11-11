import "./App.css";
import LoginRegister from "./screens/LoginRegister";
import BilboardNavbar from "./components/BilboardNavbar";
import Grid from "@mui/material/Grid";

function App() {
  return (
    <div className="App" style={{overflowX: "hidden"}}>
      <div>
        <LoginRegister></LoginRegister>
      </div>
    </div>
  );
}

export default App;
