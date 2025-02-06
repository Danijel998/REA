import "../Styles/NewAgent.css";
import * as React from "react";
import TextField from "@mui/material/TextField";
import { Button } from "@mui/material";
import Box from "@mui/material/Box";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import { useEffect, useState } from "react";
import axios from "axios";

function NewAgent() {
  const [username, setUsername] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [agency, setAgency] = useState(0);
  const [role, setRole] = useState("");
  const [agencyData, setAgencyData] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem("token");
    axios
      .get("http://localhost:8080/api/realEstateAgency/agencyList", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
      .then((response) => {
        setAgencyData(response.data);
        console.log("AGN DATA:", response.data);
      })
      .catch((error) => {
        console.log("Error while trying to get data: ", error);
      });
  }, []);

  function addUser() {
    const token = localStorage.getItem("token");
    const agencyVAT = agency.agencyIdentificationNumber;

    const body = {
      firstName: firstName,
      lastName: lastName,
      username: username,
      email: email,
      password: password,
      role: role,
      realEstateAgencyIdentificationNumber: agencyVAT,
    };

    console.log("AGENCY VAT: ", agencyVAT);
    if (password == confirmPassword) {
      axios.post("http://localhost:8080/api/user/createAgent", body, {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      });
    } else {
      alert("Please check password");
    }
  }

  console.log("Agency", agency.agencyIdentificationNumber);
  return (
    <div className="uderDetails-container">
      <div className="userDetails-form">
        <h2 className="userDetails-title">User registration</h2>
        <div className="userDetails-content">
          <div className="userDetails-data">
            <label className="label-name">Username</label>
            <TextField
              className="dataTextField"
              sx={{
                width: 300,
                "& .MuiInputBase-input.Mui-disabled": {
                  WebkitTextFillColor: "#000000",
                },
              }}
              InputProps={{
                style: {
                  height: 45,
                  borderRadius: 15,
                },
              }}
              type="text"
              id="filled-basic"
              variant="outlined"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">First Name</label>
            <TextField
              className="textField"
              sx={{
                width: 300,
                borderRadius: 50,
                "& .MuiInputBase-input.Mui-disabled": {
                  WebkitTextFillColor: "#000000",
                },
              }}
              InputProps={{
                style: {
                  height: 45,
                  borderRadius: 15,
                },
              }}
              type="text"
              id="filled-basic"
              variant="outlined"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">Last Name</label>
            <TextField
              sx={{
                width: 300,
                "& .MuiInputBase-input.Mui-disabled": {
                  WebkitTextFillColor: "#000000",
                },
              }}
              InputProps={{
                style: {
                  height: 45,
                  borderRadius: 15,
                },
              }}
              type="text"
              id="filled-basic"
              variant="outlined"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">E-Mail</label>
            <TextField
              sx={{
                width: 300,
                "& .MuiInputBase-input.Mui-disabled": {
                  WebkitTextFillColor: "#000000",
                },
              }}
              InputProps={{
                style: {
                  height: 45,
                  borderRadius: 15,
                },
              }}
              type="text"
              id="filled-basic"
              variant="outlined"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">Password</label>
            <TextField
              sx={{
                width: 300,
                "& .MuiInputBase-input.Mui-disabled": {
                  WebkitTextFillColor: "#000000",
                },
              }}
              InputProps={{
                style: {
                  height: 45,
                  borderRadius: 15,
                },
              }}
              type="password"
              id="filled-basic"
              variant="outlined"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">Confirm password</label>
            <TextField
              sx={{
                width: 300,
                "& .MuiInputBase-input.Mui-disabled": {
                  WebkitTextFillColor: "#000000",
                },
              }}
              InputProps={{
                style: {
                  height: 45,
                  borderRadius: 15,
                },
              }}
              type="password"
              id="filled-basic"
              variant="outlined"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
            />
          </div>

          <div className="userDetails-data">
            <label className="label-name">Role</label>
            <Box sx={{ width: 300 }}>
              <FormControl fullWidth>
                <Select
                  sx={{ height: 45, borderRadius: 5 }}
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  value={role}
                  label="Age"
                  onChange={(e) => setRole(e.target.value)}
                >
                  <MenuItem value="ROLE_USER">ROLE_USER</MenuItem>
                  <MenuItem value="ROLE_ADMIN">ROLE_ADMIN</MenuItem>
                  <MenuItem value="ROLE_SUPER_ADMIN">ROLE_SUPER_ADMIN</MenuItem>
                </Select>
              </FormControl>
            </Box>
          </div>

          <div className="userDetails-data">
            <label className="label-name">Agency</label>
            <Box sx={{ width: 300 }}>
              <FormControl fullWidth>
                <Select
                  sx={{ height: 45, borderRadius: 5 }}
                  labelId="demo-simple-select-label"
                  id="demo-simple-select"
                  value={agency}
                  label="Age"
                  onChange={(e) => setAgency(e.target.value)}
                >
                  {agencyData.map((e, index) => (
                    <MenuItem value={e} key={index}>
                      {e.agencyName} - {e.agencyIdentificationNumber}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Box>
          </div>
        </div>
        <div className="form-btn">
          <Button
            className="nweAgent-btn"
            variant="contained"
            onClick={addUser}
          >
            ADD
          </Button>
          <Button variant="contained" color="error">
            Contained
          </Button>
        </div>
      </div>
    </div>
  );
}

export default NewAgent;
