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
                        <input type="text" class="form-control" id="input-name"
                            placeholder="Nome de usuário cadastrado" maxlength="50">
                            <p v-if="false" style="color: red; text-align: center">Usuário Incorreto!</p>
                    </div>
                    <div>
                    <label for="input-senha">Senha</label>
                    <input type="password" class="form-control" id="input-senha"
                    minlength="5" maxlength="15">
                    <p v-if="false" style="color: red; text-align: center">Senha Incorreta!</p>
                </div>
                <div class="form-group form-check" style="padding: 5px;">
                    <label class="radio-inline" style="margin-right: 5px;"><input type="radio" name="optradio" value="aluno">Aluno</label>
                    <label class="radio-inline" style="margin-right: 5px;"><input type="radio" name="optradio" value="administrador">Administrador</label>
                    <label class="radio-inline"><input type="radio" name="optradio" value="professor">Professor</label>
                </div>
                <button type="submit" class="btn btn-primary" @click="autenticar()">Enviar</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
  name: 'login',
  props: {
    msg: String
  },
  data() {
    return {
      name
    }
  },
  methods: {
    autenticar() {
      console.log('Autenticar')
    }
  }
}
</script>

<style>

</style>