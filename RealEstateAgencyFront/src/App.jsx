import "./App.css";
import { Routes, Route } from "react-router-dom";
import HomePage from "./Components/HomePage";
import NewRealEstate from "./Components/NewRealEstate";
import RealEstatesList from "./Components/RealEstatesList";
import NewAgent from "./Components/NewAgent";
import AgentsList from "./Components/AgentsList";
import NavBar from "./Components/NavBar";

function App() {
  return (
    <div className="background-container">
      <NavBar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/addNewRealEstate" element={<NewRealEstate />} />
        <Route path="/realEstatesList" element={<RealEstatesList />} />
        <Route path="/addNewAgent" element={<NewAgent />} />
        <Route path="/agentsList" element={<AgentsList />} />
      </Routes>
    </div>
  );
}

export default App;
