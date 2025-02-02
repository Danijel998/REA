import { useContext, useEffect, useState } from "react";
import "../Styles/UserDetails.css";
import TextField from "@mui/material/TextField";
import axios from "axios";
import usernameContext from "./UsernameProvider";

function UserDetails() {
  const { username } = useContext(usernameContext);
  const [userDetails, setUserDetails] = useState([
    {
      firstName: "",
      lastName: "",
      username: "",
      realEstateAgencyIdentificationNumber: 0,
      role: "",
      email: "",
    },
  ]);
  useEffect(() => {
    const token = localStorage.getItem("token");

    axios
      .get(`http://localhost:8080/api/user/agent/${username}`, {
        headers: {
          Authorization: `Bearer ${token},`,
        },
      })
      .then((response) => {
        setUserDetails(response.data);
      })
      .catch((error) => {
        console.log("Error retriving data: ", error);
      });
  }, [username]);
  return (
    <div className="uderDetails-container">
      <div className="userDetails-form">
        <h2 className="userDetails-title">User details</h2>
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
              disabled
              id="filled-basic"
              variant="filled"
              value={userDetails.username}
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
              disabled
              id="filled-basic"
              variant="filled"
              value={userDetails.firstName}
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
              disabled
              id="filled-basic"
              variant="filled"
              value={userDetails.lastName}
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
              disabled
              id="filled-basic"
              variant="filled"
              value={userDetails.email}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">Agency VAT</label>
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
              disabled
              id="filled-basic"
              variant="filled"
              value={userDetails.realEstateAgencyIdentificationNumber}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">Role</label>
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
              disabled
              id="filled-basic"
              variant="filled"
              value={userDetails.role}
            />
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserDetails;
