insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso) values (1200,'educação infantil');
insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso) values (2400,'ensino fundamental');
insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso) values (3000,'ensino médio');

insert into sistema_escolar_xyz.turma (nome_turma, vagas, ano_admissao, id_curso) values ('primeira série', 15, '2020', 1);
insert into sistema_escolar_xyz.turma (nome_turma, vagas, ano_admissao, id_curso) values ('quinta série', 15, '2020', 2);
insert into sistema_escolar_xyz.turma (nome_turma, vagas, ano_admissao, id_curso) values ('primeiro ano', 15, '2020', 3);

insert into sistema_escolar_xyz.disciplina (carga_horaria, nome_disciplina, id_turma) values (800, 'História', 1);
insert into sistema_escolar_xyz.disciplina (carga_horaria, nome_disciplina, id_turma) values (1200, 'Matemática', 2);
insert into sistema_escolar_xyz.disciplina (carga_horaria, nome_disciplina, id_turma) values (2000, 'Língua Portuguesa', 3);

insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('adm', 'ester.lopes', '123456');
insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('adm', 'teresinha.farias', '123456');
insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('adm', 'benjamin.moura', '123456');

insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('professor', 'fabio.lima', '123456');
insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('professor', 'priscila.galvao', '123456');
insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('professor', 'lorenzo.cunha', '123456');

insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('aluno', 'fernando.castro', '123456');
insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('aluno', 'benedita.silva', '123456');
insert into sistema_escolar_xyz.credencial (tipo_usuario, usuario, senha) values ('aluno', 'debora.barros', '123456');

insert into sistema_escolar_xyz.adm (nome, cpf, vinculo, permissao, id_credencial) values ('Teresinha Aparecida Gabrielly Farias', '96147101285', 1, TRUE, 1);
insert into sistema_escolar_xyz.adm (nome, cpf, vinculo, permissao, id_credencial) values ('Ester Rita Eduarda Lopes', '95026566790', 1, TRUE, 2);
insert into sistema_escolar_xyz.adm (nome, cpf, vinculo, permissao, id_credencial) values ('Benjamin Bryan Marcos Moura', '52572947293', 1, TRUE, 3);

insert into sistema_escolar_xyz.aluno (nome, cpf, vinculo, numero_matricula, id_turma, id_credencial) values ('Fernando Guilherme Castro', '85414765537', 1, '0000001', 1, 7);
insert into sistema_escolar_xyz.aluno (nome, cpf, vinculo, numero_matricula, id_turma, id_credencial) values ('Benedita Marina Tatiane da Silva', '63977381164', 1, '0000002', 2, 8);
insert into sistema_escolar_xyz.aluno (nome, cpf, vinculo, numero_matricula, id_turma, id_credencial) values ('Débora Rafaela Rebeca Barros', '01790438896',1,'0000003', 3, 9);

insert into sistema_escolar_xyz.professor (nome, cpf, vinculo, permissao, id_disciplina, id_credencial) values ('Fábio Diego Lima', '11314375008', 1,TRUE, 1, 4);
insert into sistema_escolar_xyz.professor (nome, cpf, vinculo, permissao, id_disciplina, id_credencial) values ('Priscila Lorena Galvão', '11370397950', 1, TRUE, 3, 5);
insert into sistema_escolar_xyz.professor (nome, cpf, vinculo, permissao, id_disciplina, id_credencial) values ('Lorenzo Luís Igor da Cunha', '61475566654', 1, TRUE, 2, 6);

insert into sistema_escolar_xyz.nota (bimestre, nota, tipo_prova, id_aluno) values ('1', 10.0, 'Normal', 1);