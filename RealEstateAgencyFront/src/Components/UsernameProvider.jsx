import React, { createContext, useState } from "react";

const usernameContext = createContext();

export const UsernameContextProvider = ({ children }) => {
  const [username, setUsername] = useState("");

  return (
    <usernameContext.Provider value={{ username, setUsername }}>
      {children}
    </usernameContext.Provider>
  );
};

export default usernameContext;
