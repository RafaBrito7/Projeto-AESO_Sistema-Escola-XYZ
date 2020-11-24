import axios from 'axios';

const URL_LOGIN_PADRAO = 'http://localhost:9090';

class LoginService {
    async autenticate (credencial) {
      const { data } = await axios.post(URL_LOGIN_PADRAO + '/credenciais/autenticar', credencial);
      return data
    }

    async listar () {
      const data  = await axios.get(URL_LOGIN_PADRAO + '/credenciais')

      return data
    }
}

export default new LoginService();