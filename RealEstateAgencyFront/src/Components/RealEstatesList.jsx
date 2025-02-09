import "../Styles/RealEstatesList.css";
import * as React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useEffect, useState } from "react";
import axios from "axios";

function RealEstatesList() {
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
      })
      .catch((error) => {
        console.log("Error message: ", error);
      });
  }, []);
  return (
    <div className="container">
      <TableContainer component={Paper} sx={{ width: 1300 }}>
        <Table sx={{ width: 1300 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Agency name</TableCell>
              <TableCell>Agency VAT</TableCell>
              <TableCell>Postcode</TableCell>
              <TableCell>City</TableCell>
              <TableCell>Street</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {agencyData.map((row) => (
              <TableRow
                key={row.id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.agencyID}
                </TableCell>
                <TableCell>{row.agencyName}</TableCell>
                <TableCell>{row.agencyIdentificationNumber}</TableCell>
                <TableCell>{row.agencyPostcode}</TableCell>
                <TableCell>{row.agencyCity}</TableCell>
                <TableCell>{row.agencyStreet}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
}

export default RealEstatesList;
