import "../Styles/Login.css";

import * as React from "react";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import Input from "@mui/material/Input";
import InputLabel from "@mui/material/InputLabel";
import InputAdornment from "@mui/material/InputAdornment";
import FormControl from "@mui/material/FormControl";
import TextField from "@mui/material/TextField";
import Visibility from "@mui/icons-material/Visibility";
import VisibilityOff from "@mui/icons-material/VisibilityOff";
import { useState, useEffect } from "react";
import Logo from "../assets/Logo.png";

function Login() {
  const [showPassword, setShowPassword] = useState(false);

  //Show password
  const handleClickShowPassword = () => setShowPassword((show) => !show);
  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const handleMouseUpPassword = (event) => {
    event.preventDefault();
  };

  return (
    <div className="login-container background-container">
      <div className="login-credentials">
        <img src={Logo} className="logo-img" alt="Logo" />
        <div className="form-group">
          <TextField
            id="standard-basic"
            label="Standard"
            variant="standard"
            sx={{
              "& .MuiInputBase-root": {
                color: "black", // Tekst boja
              },
              "& .MuiInputLabel-root": {
                color: "black", // Label boja
              },
              "& .MuiOutlinedInput-root": {
                "& fieldset": {
                  borderColor: "black", // Boja ivice kada nije fokusiran
                },
                "&:hover fieldset": {
                  borderColor: "black", // Boja ivice kada je hover
                },
                "&.Mui-focused fieldset": {
                  borderColor: "black", // Boja ivice kada je fokusiran
                },
              },
            }}
          />
        </div>

        <div className="form-group">
          <FormControl
            sx={{
              m: 1,
              width: "25ch",
              "& .MuiInputBase-root": {
                color: "black", // Tekst boja
              },
              "& .MuiInputLabel-root": {
                color: "black", // Label boja
              },
              "& .MuiOutlinedInput-root": {
                "& fieldset": {
                  borderColor: "black", // Boja ivice kada nije fokusiran
                },
                "&:hover fieldset": {
                  borderColor: "black", // Boja ivice kada je hover
                },
                "&.Mui-focused fieldset": {
                  borderColor: "black", // Boja ivice kada je fokusiran
                },
              },
            }}
            variant="standard"
          >
            <InputLabel htmlFor="standard-adornment-password">
              Password
            </InputLabel>
            <Input
              id="standard-adornment-password"
              type={showPassword ? "text" : "password"}
              endAdornment={
                <InputAdornment position="end">
                  <IconButton
                    aria-label={
                      showPassword
                        ? "hide the password"
                        : "display the password"
                    }
                    onClick={handleClickShowPassword}
                    onMouseDown={handleMouseDownPassword}
                    onMouseUp={handleMouseUpPassword}
                  >
                    {showPassword ? <VisibilityOff /> : <Visibility />}
                  </IconButton>
                </InputAdornment>
              }
            />
          </FormControl>
        </div>
        <Button variant="contained">Contained</Button>
        <label>Forgot password? Reset password</label>
      </div>
    </div>
  );
}

export default Login;
