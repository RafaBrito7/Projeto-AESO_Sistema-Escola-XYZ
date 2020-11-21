import axios from 'axios';

const URL_LOGIN_PADRAO = 'localhost:0666/credenciais'
class LoginService {
    async autenticate (credencial) {
      const { data } = await axios.post(URL_LOGIN_PADRAO + '/autenticar', credencial);
      return data
    }
}

export default new LoginService();

