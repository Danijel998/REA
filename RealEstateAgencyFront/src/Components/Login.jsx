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
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Logo from "../assets/Logo.png";
import axios from "axios";

function Login({ setIsAuthenticated }) {
  const [showPassword, setShowPassword] = useState(false);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  function loginUser(e) {
    e.preventDefault();

    const credentials = {
      username,
      password,
    };

    axios
      .post("http://localhost:8080/api/auth/authenticate", credentials, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((response) => {
        const token = response.data.jwt;
        if (token) {
          localStorage.setItem("user-token", token);
          setIsAuthenticated(true);
          navigate("/homePage");
        } else {
          alert("Invalid credentials, please try again");
        }
        localStorage.clear();
        localStorage.setItem("user-token", token);
      })
      .catch((error) => {
        console.log("Authentication error: " + error);
        alert("An error occurred. Please try again later.");
      });
  }

  //Show password
  const handleClickShowPassword = () => setShowPassword((show) => !show);
  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const handleMouseUpPassword = (event) => {
    event.preventDefault();
  };

  return (
    <div className="login-container">
      <div className="login-credentials">
        <img src={Logo} className="logo-img" alt="Logo" />
        <div className="form-group">
          <TextField
            id="standard-basic"
            label="Username"
            variant="standard"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            sx={{
              "& .MuiInputBase-root": {
                color: "black",
              },
              "& .MuiInputLabel-root": {
                color: "black",
              },
              "& .MuiOutlinedInput-root": {
                "& fieldset": {
                  borderColor: "black",
                },
                "&:hover fieldset": {
                  borderColor: "black",
                },
                "&.Mui-focused fieldset": {
                  borderColor: "black",
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
                color: "black",
              },
              "& .MuiInputLabel-root": {
                color: "black",
              },
              "& .MuiOutlinedInput-root": {
                "& fieldset": {
                  borderColor: "black",
                },
                "&:hover fieldset": {
                  borderColor: "black",
                },
                "&.Mui-focused fieldset": {
                  borderColor: "black",
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
              value={password}
              onChange={(e) => setPassword(e.target.value)}
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
        <Button variant="contained" onClick={loginUser}>
          LOG IN
        </Button>
        <label>Forgot password? Reset password</label>
      </div>
    </div>
  );
}

export default Login;
