<template>
  <div>
    <div>
      <b-navbar id="sidebar-topo-pagina" type="dark" variant="dark">
        <b-button v-b-toggle.sidebar-no-header size="lg"
          ><b-icon icon="list"></b-icon
        ></b-button>
        <h4>Sistema Escolar FAR</h4>
      </b-navbar>
    </div>

    <div>
      <div>
        <b-sidebar
          id="sidebar-no-header"
          aria-labelledby="sidebar-no-header-title"
          no-header
          shadow
          backdrop
          backdrop-variant="dark"
        >
          <template #default="{ hide }">
            <div class="p-3">
              <div class="row">
                <div class="col-md-10">
                  <h4 id="sidebar-header-title">Menu de Funções</h4>
                </div>
                <b-button
                  v-b-toggle.sidebar-no-header
                  size="sm"
                  id="button-close-sidebar"
                  ><b-icon icon="x"></b-icon
                ></b-button>
              </div>
              <hr />
              <p>
                Seja bem vindo Aluno, aqui você terá todas as opções de funções
                que estão disponíveis no nosso sistema.
              </p>
              <hr />
              <nav class="mb-3">
                <b-nav vertical id="menu-vertical">
                  <b-nav-item active @click="hide"
                    ><b-button
                      ><b-icon icon="person"></b-icon> Perfil</b-button
                    ></b-nav-item
                  >
                  <b-nav-item href="#link-1" @click="hide"
                    ><b-button
                      ><b-icon icon="journals"></b-icon> Notas</b-button
                    ></b-nav-item
                  >
                  <b-nav-item href="#link-1" @click="hide"
                    ><b-button
                      ><b-icon icon="book"></b-icon> Disciplinas</b-button
                    ></b-nav-item
                  >
                  <b-nav-item href="#link-1" @click="hide"
                    ><b-button
                      ><b-icon icon="layers"></b-icon> Turma</b-button
                    ></b-nav-item
                  >
                </b-nav>
              </nav>
            </div>
            <div class="">
              <img id="img-logo-sidebar" src="@/assets/logo.png" alt="" />
            </div>
          </template>
          <template #footer="{}">
            <div class="d-flex bg-dark text-light align-items-center px-3 py-2">
              <strong class="mr-auto">Deslogar</strong>
              <b-button size="sm" @click="deslogar()">Sair</b-button>
            </div>
          </template>
        </b-sidebar>
      </div>
    </div>
    <template>
      <div id="pagina-principal">
        <div class="modal-header justify-content-center">
          <h2 class="modal-title">Bem vindo, {credencial.nome}!</h2>
        </div>
        <div class="modal-body">
          <div class="box">
            <div class="row">
              <div class="col-md-2"></div>
              <div class="col-md-2">
                <div class="card" style="width: 12rem">
                  <img
                    class="card-img-top"
                    src="@/assets/foto perfil usuario.jpg"
                    alt="foto perfil usuario"
                  />
                  <div class="card-body">
                    <p class="card-text">
                      <small class="text-muted">Foto perfil</small>
                    </p>
                  </div>
                </div>
              </div>
              <div class="col-md-8">
                <div class="dados-pessoais-perfil">
                  <strong>Nome:</strong>
                  <label> {aluno.nome}</label> 
                </div>
                <div class="dados-pessoais-perfil">
                  <strong>Matrícula:</strong>
                  <label> {aluno.matricula}</label> 
                </div>
                <div class="dados-pessoais-perfil">
                  <strong>CPF:</strong>
                  <label> {aluno.cpf}</label> 
                </div>
                <div class="dados-pessoais-perfil">
                  <strong>Turma:</strong>
                  <label> {aluno.turma}</label> 
                </div>
                <div class="dados-pessoais-perfil">
                  <strong>Escolaridade:</strong>
                  <label> {aluno.curso}</label> 
                </div>
              </div>
            </div>
          </div>
          <div>
            <hr>
            <strong>Disciplinas em Curso:</strong>
          </div>
        </div>
      </div>
    </template>
  </div>
</template>

<script>
export default {
  name: "dashboard-aluno",
  data() {
    return {
      aluno: {
        nome: null,
        funcao: null,
        cpf: null,
        turma: null,
        matricula: null
      },
    };
  },
  methods: {
    deslogar() {
      this.$router.push("login");
    },
  },
};
</script>

<style>
#sidebar-topo-pagina h4 {
  color: white;
  margin-left: 35%;
  font-weight: bold;
}

#sidebar-header-title {
  font-weight: bold;
}

#button-close-sidebar {
  background-color: red;
  border-color: white;
  width: 30px;
  height: 30px;
  margin-left: 5px;
}

#menu-vertical button {
  width: 100%;
  height: 30px;
  color: white;
  background-color: #2a3342;
  padding: 0px 0px;
  margin-top: 15px;
}

#img-logo-sidebar {
  width: 100px;
  margin: auto;
  display: block;
  position: static;
  bottom: 0;
}

#pagina-principal {
  width: 100%;
  height: 100%;
  background-color: white;
}

.modal-header h2 {
  font-weight: bold;
}

#card-perfil-foto {
  width: 180;
  height: 350;
}

.dados-pessoais-perfil{
  margin-top: 15px;
}
</style>