import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(name, password) {
    return axios
      .post(API_URL + "login", {
        name,
        password
      })
      .then(response => {
        console.log("login response");
        console.log(response);
        if (response.data.token) {
          localStorage.setItem("user", JSON.stringify(response.data));
          console.log("log in data");
          console.log(response);
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(name, email, password, role) {
    return axios.post(API_URL + "register", {
      name,
      password,
      email,
      role,
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem("user"));;
  }
}

export default new AuthService();