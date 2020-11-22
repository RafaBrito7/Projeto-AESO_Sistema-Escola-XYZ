<template>
  <div>
    <div>
      <b-navbar type="light" variant="light">
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
        >
          <template #default="{ hide }">
            <div class="p-3">
              <h4 id="sidebar-no-header-title">Menu de Funções</h4>
              <p>
                Seja bem vindo Aluno, aqui você terá todas as opções de funções
                que estão disponíveis no nosso sistema. 
              </p>
              <nav class="mb-3">
                <b-nav vertical>
                  <b-nav-item active @click="hide">Perfil</b-nav-item>
                  <hr class="mt-0 mb-1"/>
                  <b-nav-item href="#link-1" @click="hide">Notas</b-nav-item>
                  <b-nav-item href="#link-1" @click="hide">Disciplinas</b-nav-item>
                  <b-nav-item href="#link-1" @click="hide">Turma</b-nav-item>
                </b-nav>
              </nav>
              <b-button variant="primary" block @click="hide"
                >Close Sidebar</b-button
              >
            </div>
          </template>
          <template #footer="{ hide }">
            <div class="d-flex bg-dark text-light align-items-center px-3 py-2">
              <strong class="mr-auto">Footer</strong>
              <b-button size="sm" @click="hide">Close</b-button>
            </div>
          </template>
        </b-sidebar>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "dashboard-aluno",
};
</script>

<style>
</style>