var Login = {
    template: `
<div class="middle-box text-center loginscreen animated fadeInDown">
    <div class="container"
        style="background-color: white; margin-top: 5%; width: 600px; padding: 20px; border-radius: 20px;">
        <div style="padding: 10px;">
            <img id="logo-img-sistema" src="./assets/imgs/Logo Sistema Escolar.png" alt="Logo Sistema Escolar"
                width="150px">
        </div>
        <div class="d-flex justify-content-center" style="margin-top: 20px;">
            <form style="width: 300px;">
                <div class="form-group" style="text-align: left;">
                    <label for="input-name">Usuário</label>
                    <input type="text" class="form-control" id="input-name" v-model="login.name"
                        placeholder="Nome de usuário cadastrado" maxlength="50">
                        <p v-if="false" style="color: red; text-align: center">Usuário Incorreto!</p>
                </div>
                <div class="form-group" style="text-align: left;">
                    <label for="input-senha">Senha</label>
                    <input type="password" class="form-control" id="input-senha"  v-model="login.senha"
                    minlength="5" maxlength="15">
                    <p v-if="false" style="color: red; text-align: center">Senha Incorreta!</p>
                </div>
                <div class="form-group form-check" style="padding: 5px;">
                    <label class="radio-inline" style="margin-right: 5px;"><input type="radio" name="optradio" value="aluno" v-model="login.funcao">Aluno</label>
                    <label class="radio-inline" style="margin-right: 5px;"><input type="radio" name="optradio" value="administrador" v-model="login.funcao">Administrador</label>
                    <label class="radio-inline"><input type="radio" name="optradio" value="professor" v-model="login.funcao">Professor</label>
                </div>
                <button v-bind:disabled="login.name == null || login.senha == null || login.funcao == null" v-on:click="doGetLogin"
                type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </div>
</div>
    `
};