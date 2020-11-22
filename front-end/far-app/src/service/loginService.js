import axios from 'axios';

const URL_LOGIN_PADRAO = 'http://localhost:9090'

class LoginService {
    async autenticate (credencial) {
      const { data } = await axios.post(URL_LOGIN_PADRAO + '/' + credencial).then(function(){
        console.log('salvo com sucesso')
      });
      return data
    }
}

export default new LoginService();

