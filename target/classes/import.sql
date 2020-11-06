insert into sistema_escolar_xyz.serie (nome_serie) values ('ads2019.1');
insert into sistema_escolar_xyz.serie (nome_serie) values ('ads2019.2');
insert into sistema_escolar_xyz.serie (nome_serie) values ('ads2020.1');
insert into sistema_escolar_xyz.serie (nome_serie) values ('ads2020.2');

insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso, serie_id) values (20.0, 'Análise e Desenvolvimento de Sistemas',1);
insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso, serie_id) values (20.0, 'Análise e Desenvolvimento de Sistemas',2);
insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso, serie_id) values (20.0, 'Análise e Desenvolvimento de Sistemas',3);
insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso, serie_id) values (20.0, 'Análise e Desenvolvimento de Sistemas',4);

insert into sistema_escolar_xyz.bimestre (tipo_bimestre) values ('Primeiro bimestre');
insert into sistema_escolar_xyz.bimestre (tipo_bimestre) values ('Segundo bimestre');
insert into sistema_escolar_xyz.bimestre (tipo_bimestre) values ('Terceiro bimestre');
insert into sistema_escolar_xyz.bimestre (tipo_bimestre) values ('Quarto bimestre');
insert into sistema_escolar_xyz.bimestre (tipo_bimestre) values ('Recuperação');

insert into sistema_escolar_xyz.tipo_prova (tipo_prova) values ('Prova normal');
insert into sistema_escolar_xyz.tipo_prova (tipo_prova) values ('Segunda chamada');

insert into sistema_escolar_xyz.funcao_pessoa (nome_funcao) values ('Administrador');
insert into sistema_escolar_xyz.funcao_pessoa (nome_funcao) values ('Professor');
insert into sistema_escolar_xyz.funcao_pessoa (nome_funcao) values ('Aluno');