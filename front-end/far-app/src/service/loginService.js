import axios from 'axios';

const URL_LOGIN_PADRAO = 'http://localhost:9090'
const URL_LOGIN_PADRAO = 'localhost:9090/credenciais';
const headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

class LoginService {
    async autenticate (credencial) {
      const { data } = await axios.post(URL_LOGIN_PADRAO + '/credenciais/autenticar', credencial).then(function(){
        headers: headers;
        console.log('salvo com sucesso')
      });
      return data
    }

    async listar () {
      const data  = await axios.get(URL_LOGIN_PADRAO + '/credenciais')

      return data
    }
}

export default new LoginService();