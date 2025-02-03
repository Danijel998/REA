import "../Styles/NavBar.css";

import { NavLink } from "react-router-dom";
import * as React from "react";
import Button from "@mui/material/Button";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import { useNavigate } from "react-router-dom";

function NavBar({ setIsAuthenticated }) {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const navigate = useNavigate();

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleLogOut = () => {
    setIsAuthenticated(false);
    navigate("/login");
    localStorage.clear();
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  return (
    <nav className="navBar">
      <ul className="navBar-list">
        <li>
          <NavLink className="navBar-list-element" to="/homePage">
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
      <ul className="navBar-user-element">
        <li>
          <Button
            id="basic-button"
            aria-controls={open ? "basic-menu" : undefined}
            aria-haspopup="true"
            aria-expanded={open ? "true" : undefined}
            onClick={handleClick}
          >
            veselinovicd
          </Button>
          <Menu
            id="basic-menu"
            anchorEl={anchorEl}
            open={open}
            onClose={handleClose}
            MenuListProps={{
              "aria-labelledby": "basic-button",
            }}
          >
            <MenuItem onClick={handleClose}>Profile</MenuItem>
            <MenuItem onClick={handleClose}>My account</MenuItem>
            <MenuItem onClick={handleLogOut}>Logout</MenuItem>
          </Menu>
        </li>
      </ul>
    </nav>
  );
}

export default NavBar;
