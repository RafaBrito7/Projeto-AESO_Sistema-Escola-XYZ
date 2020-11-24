import axios from 'axios';

const URL_LOGIN_PADRAO = 'http://localhost:9090';

class alunoService {
    async getAlunoById (idCredencial) {
      const { data } = await axios.get(URL_LOGIN_PADRAO + '/alunos/' + idCredencial);
      return data;
    }
}

export default new alunoService();