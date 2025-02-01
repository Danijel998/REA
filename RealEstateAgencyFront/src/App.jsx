import "./App.css";
import { Navigate, Route, Routes } from "react-router-dom";
import HomePage from "./Components/HomePage";
import NewRealEstate from "./Components/NewRealEstate";
import RealEstatesList from "./Components/RealEstatesList";
import NewAgent from "./Components/NewAgent";
import AgentsList from "./Components/AgentsList";
import NavBar from "./Components/NavBar";
import Login from "./Components/Login";
import { useEffect, useState } from "react";
function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem("user-token");
    if (token) {
      setIsAuthenticated(true);
    }
  }, []);

  return (
    <div>
      {isAuthenticated ? (
        <div className="background-container">
          <NavBar setIsAuthenticated={setIsAuthenticated} />
          <Routes>
            <Route
              path="/homePage"
              element={
                isAuthenticated ? <HomePage /> : <Navigate to="/login" />
              }
            />

            <Route
              path="/addNewRealEstate"
              element={
                isAuthenticated ? <NewRealEstate /> : <Navigate to="/login" />
              }
            />

            <Route
              path="/realEstatesList"
              element={
                isAuthenticated ? <RealEstatesList /> : <Navigate to="/login" />
              }
            />

            <Route
              path="/addNewAgent"
              element={
                isAuthenticated ? <NewAgent /> : <Navigate to="/login" />
              }
            />

            <Route
              path="/agentsList"
              element={
                isAuthenticated ? <AgentsList /> : <Navigate to="/login" />
              }
            />
          </Routes>
        </div>
      ) : (
        <div className="background-container2">
          <Routes>
            <Route
              path="/login"
              element={<Login setIsAuthenticated={setIsAuthenticated} />}
            />
          </Routes>
        </div>
      )}
    </div>
  );
}

export default App;
