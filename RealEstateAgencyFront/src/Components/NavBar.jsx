import "../Styles/NavBar.css";

import { NavLink } from "react-router-dom";

function NavBar() {
  return (
    <nav className="navBar">
      <ul className="navBar-list">
        <li>
          <NavLink className="navBar-list-element" to="/">
            HOME PAGE
          </NavLink>
        </li>

        <li>
          <NavLink className="navBar-list-element" to="/addNewRealEstate">
            NEW REAL ESTATE
          </NavLink>
        </li>
        <li>
          <NavLink className="navBar-list-element" to="/realEstatesList">
            REAL ESTATE LIST
          </NavLink>
        </li>
        <li>
          <NavLink className="navBar-list-element" to="/addNewAgent">
            NEW AGENT
          </NavLink>
        </li>
        <li>
          <NavLink className="navBar-list-element" to="/agentsList">
            AGENT LIST
          </NavLink>
        </li>
      </ul>
    </nav>
  );
}

export default NavBar;
