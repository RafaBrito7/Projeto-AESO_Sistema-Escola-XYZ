<template>
    <div class= "login">
      <div style="padding: 10px;">
        <img id="logo-img-sistema" src="../assets/logo.png" alt="Logo Sistema Escolar"
                    width="150px">
      </div>
        <div class="d-flex justify-content-center" style="margin-top: 20px;">
            <form style="width: 300px;">
                <div class="form-group" style="text-align: left;">
                        <label for="input-name">Usuário</label>
                        <input type="text" class="form-control" id="input-name" v-model="credencial.name"
                            placeholder="Nome de usuário cadastrado" maxlength="50">
                            <p v-if="false" style="color: red; text-align: center">Usuário Incorreto!</p>
                </div>
                <div>
                    <label for="input-senha">Senha</label>
                    <input type="password" class="form-control" id="input-senha" v-model="credencial.senha"
                    minlength="5" maxlength="15">
                    <p v-if="false" style="color: red; text-align: center">Senha Incorreta!</p>
                </div>
                <div class="form-group form-check" style="padding: 5px;">
                    <label class="radio-inline" style="margin-right: 5px;"><input type="radio" name="optradio" value="aluno" v-model="credencial.funcao">Aluno</label>
                    <label class="radio-inline" style="margin-right: 5px;"><input type="radio" name="optradio" value="administrador" v-model="credencial.funcao">Administrador</label>
                    <label class="radio-inline"><input type="radio" name="optradio" value="professor" v-model="credencial.funcao">Professor</label>
                </div>
                <button type="submit" class="btn btn-primary" @click="autenticar()" 
                v-bind:disabled="credencial.name == null || credencial.senha == null || credencial.funcao == null" >Enviar</button>
            </form>
        </div>
    </div>
</template>

<script>
import loginService from '../service/loginService';

export default {
  name: 'login',
  props: {
    msg: String
  },
  data() {
    return {
      credencial: {
        name: null,
        senha: null,
        funcao: null
      }
    }
  },
  methods: {
    autenticar() {
      if (this.credencial.name != null && this.credencial.senha != null && this.credencial.funcao != null) {
        loginService.autenticate(this.credencial)
        .then(data => {
          console.log(data);
          alert('Logado!');})
          .catch(data => {
            console.log(data);
            alert('Logado!');});
        
      } else{
        alert('Login Faiou');
      }      
    }
  }
}
</script>

<style>

</style>