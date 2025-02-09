import "../Styles/NewRealEstate.css";
import * as React from "react";
import TextField from "@mui/material/TextField";
import { Button } from "@mui/material";
import { useState } from "react";
import axios from "axios";

function NewRealEstate() {
  const [agencyVAT, setAgencyVAT] = useState("");
  const [agencyName, setAgencyName] = useState("");
  const [agencyPostcode, setAgencyPostcode] = useState("");
  const [agencyStreet, setAgencyStreet] = useState("");
  const [agencyCity, setAgencyCity] = useState("");

  function addAgency() {
    const token = localStorage.getItem("token");

    const body = {
      agencyIdentificationNumber: agencyVAT,
      agencyName: agencyName,
      agencyPostcode: agencyPostcode,
      agencyStreet: agencyStreet,
      agencyCity: agencyCity,
    };

    axios
      .post("http://localhost:8080/api/realEstateAgency/createAgency", body, {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      })
      .catch((error) => {
        if (error.response) {
          if (error.response.status === 409) {
            alert("Agency with this VAT already exist!");
          } else {
            alert("Something went wrong: ");
          }
          console.log("Error response: ", error.response);
        } else {
          console.log("Error: ", error);
          alert("Something went wrong");
        }
      });
  }

  return (
    <div className="uderDetails-container">
      <div className="userDetails-form">
        <h2 className="userDetails-title">Agency registration</h2>
        <div className="userDetails-content">
          <div className="userDetails-data">
            <label className="label-name">Identification number</label>
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
              value={agencyVAT}
              onChange={(e) => setAgencyVAT(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">Name</label>
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
              value={agencyName}
              onChange={(e) => setAgencyName(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">Postcode</label>
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
              value={agencyPostcode}
              onChange={(e) => setAgencyPostcode(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">City</label>
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
              value={agencyCity}
              onChange={(e) => setAgencyCity(e.target.value)}
            />
          </div>
          <div className="userDetails-data">
            <label className="label-name">Street</label>
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
              value={agencyStreet}
              onChange={(e) => setAgencyStreet(e.target.value)}
            />
          </div>
        </div>
        <div className="form-btn">
          <Button
            className="nweAgent-btn"
            variant="contained"
            onClick={addAgency}
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

export default NewRealEstate;
