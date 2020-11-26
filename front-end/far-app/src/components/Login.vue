<template>
  <div class="container" id="container-principal">
    <div id="div-img-logo">
      <img
        id="logo-img-sistema"
        src="../assets/logo.png"
        alt="Logo Sistema Escolar"
      />
    </div>
    <div class="d-flex justify-content-center">
      <div id="form">
        <div class="form-group">
          <font-awesome-icon icon="user" />
          <label for="input-name"> Usuário</label>
          <input
            type="text"
            class="form-control"
            id="input-name"
            placeholder="Nome de usuário cadastrado"
            maxlength="50"
            v-model="credencial.usuario"
          />
          <p v-show="false">
            <font-awesome-icon icon="times" /> Usuário Incorreto!
          </p>
        </div>
        <div class="form-group">
          <font-awesome-icon icon="unlock-alt" />
          <label for="input-senha"> Senha</label>
          <input
            type="password"
            class="form-control"
            id="input-senha"
            minlength="5"
            maxlength="15"
            placeholder="**********"
            v-model="credencial.senha"
          />
          <p v-show="false">Senha Incorreta!</p>
        </div>
        <div class="form-check">
          <label class="radio-inline"
            ><input
              type="radio"
              name="optradio"
              value="aluno"
              v-model="credencial.tipoUsuario"
            />Aluno</label
          >
          <label class="radio-inline"
            ><input
              type="radio"
              name="optradio"
              value="administrador"
              v-model="credencial.tipoUsuario"
            />Administrador</label
          >
          <label class="radio-inline"
            ><input
              type="radio"
              name="optradio"
              value="professor"
              v-model="credencial.tipoUsuario"
            />Professor</label
          >
        </div>
        <div class="row">
          <div class="col-md-6">
            <button
              type="submit"
              class="btn btn-primary"
              @click="autenticar()"
              v-bind:disabled="
                credencial.usuario == null ||
                credencial.senha == null ||
                credencial.tipoUsuario == null
              "
            >
              Enviar
            </button>
          </div>
          <div class="col-md-6">
            <small id="redefinir-senha">
              <a href="https://mail.google.com/" target="_blank"
                >Esqueceu a sua Senha?</a
              >
            </small>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import loginService from "../service/loginService";

export default {
  name: "login",
  props: {
    msg: String,
  },
  data() {
    return {
      credencial: {
        usuario: null,
        senha: null,
        tipoUsuario: null,
      },
    };
  },
  methods: {
    autenticar() {
      if (
        this.credencial.usuario != null &&
        this.credencial.senha != null &&
        this.credencial.tipoUsuario != null
      ) {
        loginService
          .autenticate(this.credencial)
          .then((data) => {
            this.credencial = data;
            this.$router.push({
              name: 'dashboard-aluno', 
              query: {credencial: this.credencial.idCredencial}});
          })
          .catch((error) => {
            alert("Credenciais Não Encontradas!", error);
          });
      }
    },
  },
};
</script>

<style>
html {
  background-color: #2a3342;
}

#container-principal {
  background-color: white;
  width: 600px;
  height: 500px;
  border-radius: 50px;
  margin-top: 60px;
}

#div-img-logo {
  text-align: center;
  padding: 10px;
}

#div-img-logo img {
  width: 150px;
  margin-top: 20px;
}

#form {
  margin-top: 20px;
  width: 350px;
}

#form label {
  padding: 3px;
}

#form input {
  padding: 3px;
}

.form-group label {
  font-weight: bold;
}

.form-group p {
  color: red;
  text-align: left;
  font-style: italic;
}

.form-check {
  margin-bottom: 10px;
}

.form-check label {
  margin-left: 10px;
}

.form-check input {
  margin-right: 4px;
}

#redefinir-senha {
  position: absolute;
  margin-top: 9px;
  margin-left: 20px;
}
</style>