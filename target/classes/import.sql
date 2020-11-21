insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso) values (1200,'educação infantil');
insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso) values (2400,'ensino fundamental');
insert into sistema_escolar_xyz.curso (carga_horaria_total, nome_curso) values (3000,'ensino médio');

insert into sistema_escolar_xyz.turma (nome_turma, vagas, ano_admissao, id_curso) values ('primeira série', 15, '2020', 1);
insert into sistema_escolar_xyz.turma (nome_turma, vagas, ano_admissao, id_curso) values ('quinta série', 15, '2020', 2);
insert into sistema_escolar_xyz.turma (nome_turma, vagas, ano_admissao, id_curso) values ('primeiro ano', 15, '2020', 3);

insert into sistema_escolar_xyz.disciplina (carga_horaria, nome_disciplina, id_turma) values (800, 'História', 1);
insert into sistema_escolar_xyz.disciplina (carga_horaria, nome_disciplina, id_turma) values (1200, 'Matemática', 2);
insert into sistema_escolar_xyz.disciplina (carga_horaria, nome_disciplina, id_turma) values (2000, 'Língua Portuguesa', 3);

insert into sistema_escolar_xyz.adm (nome, cpf, senha, usuario, vinculo, permissao) values ('Teresinha Aparecida Gabrielly Farias', '96147101285','123456','teresinha.farias', 1, TRUE);
insert into sistema_escolar_xyz.adm (nome, cpf, senha, usuario, vinculo, permissao) values ('Ester Rita Eduarda Lopes', '95026566790','123456','ester.lopes', 1, TRUE);
insert into sistema_escolar_xyz.adm (nome, cpf, senha, usuario, vinculo, permissao) values ('Benjamin Bryan Marcos Moura', '52572947293','123456','benjamin.moura', 1, TRUE);

insert into sistema_escolar_xyz.aluno (nome, cpf, senha, usuario, vinculo, numero_matricula, id_turma) values ('Fernando Guilherme Castro', '85414765537','123456','fernando.castro', 1, '0000001', 1);
insert into sistema_escolar_xyz.aluno (nome, cpf, senha, usuario, vinculo, numero_matricula, id_turma) values ('Benedita Marina Tatiane da Silva', '63977381164','123456','benedita.silva', 1, '0000002', 2);
insert into sistema_escolar_xyz.aluno (nome, cpf, senha, usuario, vinculo, numero_matricula, id_turma) values ('Débora Rafaela Rebeca Barros', '01790438896','123456','debora.barros', 1,'0000003', 3);

insert into sistema_escolar_xyz.professor (nome, cpf, senha, usuario, vinculo, permissao, id_disciplina) values ('Fábio Diego Lima', '11314375008','123456','fabio.lima', 1,TRUE, 1);
insert into sistema_escolar_xyz.professor (nome, cpf, senha, usuario, vinculo, permissao, id_disciplina) values ('Priscila Lorena Galvão', '11370397950','123456','priscila.galvao', 1, TRUE, 3);
insert into sistema_escolar_xyz.professor (nome, cpf, senha, usuario, vinculo, permissao, id_disciplina) values ('Lorenzo Luís Igor da Cunha', '61475566654','123456','lorenzo.cunha', 1, TRUE, 2);

insert into sistema_escolar_xyz.nota (bimestre, nota, tipo_prova, id_aluno) values ('1', 10.0, 'Normal', 1);