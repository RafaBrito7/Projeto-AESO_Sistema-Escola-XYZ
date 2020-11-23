import axios from 'axios';

const URL_LOGIN_PADRAO = 'localhost:9090/credenciais';
const headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

class LoginService {
    async autenticate (credencial) {
      const { data } = await axios.post(URL_LOGIN_PADRAO, credencial, {
        headers: headers
      });
      return data
    }
}

export default new LoginService();