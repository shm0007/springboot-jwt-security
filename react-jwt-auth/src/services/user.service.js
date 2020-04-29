import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:12345/api/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }

  createItem(name, location){
    return axios.post(API_URL + 'restaurant', {
      name,
      location
    }, { headers: authHeader() })
  }

  getItemList() {
    return axios.get(API_URL + 'restaurant/all', { headers: authHeader() });
  }

}

export default new UserService();