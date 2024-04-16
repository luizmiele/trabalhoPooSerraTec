# Programação Orientada a Objeto - Grupo 4
## Alunos:

César Guerra Peixe, 

Luiz Miele,

Lucas Amorim Rodrigues,

Ismael Antonio carvalho jagne,

Dionatan de Andrade Cardoso.

## Sistema de Gerenciamento de Academia:

### Packages:

Conexão, DAO, Main, Menu, Model, Service, Util.

![image](https://github.com/luizmiele/trabalhoPooSerraTec/assets/164147010/6db06753-8128-4030-bcdf-16a77958883a)

### Model:

No Package Model, realizamos a modelagem dos objetos, como a classe abstrata Pessoa e suas subclasses, como Aluno.

![image](https://github.com/luizmiele/trabalhoPooSerraTec/assets/164147010/bf9b2ab9-cdfa-4bb5-8a4a-5813afb64de0)

![image](https://github.com/luizmiele/trabalhoPooSerraTec/assets/164147010/ae701b4e-2ddf-4bac-b5b3-8606d237143f)

### Menu:

Classe Main, que gerencia a interação com o usuário através do package Menu.

![image](https://github.com/luizmiele/trabalhoPooSerraTec/assets/164147010/86575610-e54a-49d4-a64e-5e31cc25f2b3)

![image](https://github.com/luizmiele/trabalhoPooSerraTec/assets/164147010/b8ab756b-420e-4b7e-a51c-11c02dccfa22)

Login:

![image](https://github.com/luizmiele/trabalhoPooSerraTec/assets/164147010/8822e5a5-3c7b-4030-884f-c53ff8e2d6d3)

Menu principal:

![image](https://github.com/luizmiele/trabalhoPooSerraTec/assets/164147010/dc1d07e1-f8a5-49a4-b6c5-4afa70baf46c)

### Conexão:

Decidimos utilizar um banco de dados para registrar as informações do nosso projeto, através do package Conexão.

![image](https://github.com/luizmiele/trabalhoPooSerraTec/assets/164147010/eaeaa721-85a4-4c8d-8edb-b9b3aa686266)

Segue o modelo e população do banco de dados:

```
CREATE TABLE pessoa (
    pessoaID SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    CPF VARCHAR(11) UNIQUE,
    dataNascimento DATE,
    telefone VARCHAR(20),
    email VARCHAR(50),
    senha VARCHAR(100),
    tipo VARCHAR(20)
); 

create table plano (
	planoID SERIAL primary key,
	nomePlano VARCHAR(50),
	duracao int,
	valor float,
	descricao VARCHAR(200)
);

create table funcionario (
	funcionarioID int primary key,
	cargo VARCHAR(50),
	Foreign key (funcionarioID) references pessoa(pessoaID)
);

create table personal (
	personalID int primary key,
	especialidade VARCHAR(100),
	cref VARCHAR(50),
	horarioAgendamentos text,
	Foreign key (personalID) references pessoa(pessoaID)
);

create table aluno (
	alunoID int primary key,
	planoContratado int,
	dataMatricula Date,
	Foreign key (alunoID) references pessoa(pessoaID),
	Foreign key (planoContratado) references plano(planoID)
);

create table Avaliacao (
avaliacaoID SERIAL primary key,
alunoID int,
personalID int,
data Date not null,
descricao VARCHAR(200) not null,
Foreign key (alunoID) references aluno(alunoID),
Foreign key (personalID) references personal(personalID) 
);

create table agendamento (
	agendamentoID SERIAL primary key,
	data date,
	horario Time,
	personalID int,
	alunoID int,
	foreign key (personalID) references personal(personalID),
	foreign key (alunoID) references aluno(alunoID)
);
```

```
INSERT INTO pessoa (nome, CPF, dataNascimento, telefone, email, senha, tipo)
values
('Ismael Jagne', '12345678910', '1993-11-05', '11987654326', 'lucas@email.com', '12345', 'funcionario'),
('Dionatan Andrade', '12345678911', '1988-01-15', '11987654327', 'julia@email.com', '12345', 'funcionario'),
('Lucas Amorim', '12345678912', '1990-06-20', '11987654328', 'fernanda@email.com', '12345', 'funcionario'),
('Cesar Guerra', '12345678913', '1987-03-10', '11987654329', 'rafael@email.com', '12345', 'funcionario'),
('Luiz Miele', '123', '1995-08-15', '11987654330', 'gustavo@email.com', '456', 'funcionario'),
('Luisa Martins', '111', '1989-10-25', '11987654331', 'luisa@email.com', '222', 'personal'),
('Felipe Ferreira', '12345678916', '1992-12-10', '11987654332', 'felipe@email.com', '12345', 'personal'),
('Patricia Gomes', '12345678917', '1991-05-20', '11987654333', 'patricia@email.com', '12345', 'personal'),
('Bruno Cardoso', '12345678918', '1994-07-05', '11987654334', 'bruno@email.com', '12345', 'personal'),
('Camila Costa', '12345678919', '1986-09-30', '11987654335', 'camila@email.com', '12345', 'personal'),
('João Silva', '333', '1990-05-10', '11987654321', 'joao@email.com', '444', 'aluno'),
('Maria Oliveira', '69294882241', '1985-07-15', '11987654322', 'maria@email.com', '12345', 'aluno'),
('Pedro Costa', '69407292169', '1992-02-20', '11987654323', 'pedro@email.com', '12345', 'aluno'),
('Ana Santos', '33355139599', '1994-04-25', '11987654324', 'ana@email.com', '12345', 'aluno'),
('Carlos Lima', '71681820722', '1991-09-30', '11987654325', 'carlos@email.com', '12345', 'aluno'),
('Lucas Rodrigues', '63843773815', '1993-11-05', '11987654326', 'lucas@email.com', '12345', 'aluno'),
('Julia Pereira', '54433236284', '1988-01-15', '11987654327', 'julia@email.com', '12345', 'aluno'),
('Fernanda Ribeiro', '79226847118', '1990-06-20', '11987654328', 'fernanda@email.com', '12345', 'aluno'),
('Rafael Souza', '42889465225', '1987-03-10', '11987654329', 'rafael@email.com', '12345', 'aluno'),
('Gustavo Alves', '00044186703', '1995-08-15', '11987654330', 'gustavo@email.com', '12345', 'aluno'),
('Luisa Martins', '15132921299', '1989-10-25', '11987654331', 'luisa@email.com', '12345', 'aluno'),
('Felipe Ferreira', '74199242449', '1992-12-10', '11987654332', 'felipe@email.com', '12345', 'aluno'),
('Patricia Gomes', '71283446758', '1991-05-20', '11987654333', 'patricia@email.com', '12345', 'aluno'),
('Bruno Cardoso', '11379631580', '1994-07-05', '11987654334', 'bruno@email.com', '12345', 'aluno'),
('Camila Costa', '78552441667', '1986-09-30', '11987654335', 'camila@email.com', '12345', 'aluno'),
('Roberto Silva', '48134296106', '1996-04-12', '11987654336', 'roberto@email.com', '12345', 'aluno'),
('Mariana Oliveira', '27637631206', '1997-07-18', '11987654337', 'mariana@email.com', '12345', 'aluno'),
('Henrique Costa', '81345726694', '1998-02-22', '11987654338', 'henrique@email.com', '12345', 'aluno'),
('Isabela Santos', '41013887760', '1999-04-27', '11987654339', 'isabela@email.com', '12345', 'aluno'),
('Diego Lima', '35809083595', '2000-09-02', '11987654340', 'diego@email.com', '12345', 'aluno'),
('Aline Rodrigues', '36517281886', '1995-11-07', '11987654341', 'aline@email.com', '12345', 'aluno'),
('Ricardo Pereira', '16742433329', '1996-01-17', '11987654342', 'ricardo@email.com', '12345', 'aluno'),
('Fernanda Gomes', '28396307458', '1997-06-21', '11987654343', 'fernanda2@email.com', '12345', 'aluno'),
('Pedro Cardoso', '52175509532', '1998-10-26', '11987654344', 'pedro2@email.com', '12345', 'aluno'),
('Bruna Costa', '23866731701', '1999-12-15', '11987654345', 'bruna@email.com', '12345', 'aluno');

INSERT INTO plano (nomePlano, duracao, valor, descricao)
VALUES
    ('GOLD', 30, 200.00, 'Apenas Musculação'),
    ('PLATINUM', 60, 350.00, 'Musculação, zumba e capoeira.'),
    ('DIAMOND', 90, 500.00, 'Musculação, natação, spinnig, aula de tenis de mesa, totó e Rope Skipping.');
   
INSERT INTO personal (personalID, especialidade, cref, horarioagendamentos)
VALUES
    (6, 'MUSCULACAO', '123456', 'Segunda a sexta, das 08:00 às 12:00'),
    (7, 'CROSSFIT', '654321', 'Terça e quinta, das 18:00 às 22:00'),
    (8, 'CAPOEIRA', '987654', 'Segunda, quarta e sexta, das 14:00 às 20:00'),
    (9, 'SPINNING', '456123', 'Segunda e quinta, das 10:00 às 16:00'),
    (10, 'MUSCULACAO', '321654', 'Quarta e sexta, das 16:00 às 20:00');

INSERT INTO funcionario (funcionarioID, cargo)
VALUES
    (1, 'Recepcionista'),
    (2, 'Recepcionista'),
    (3, 'Recepcionista'),
    (4, 'Gerente'),
    (5, 'ADM');
   
INSERT INTO Aluno (alunoID, planoContratado, datamatricula)
VALUES
    (11, 1, CURRENT_DATE),
    (12, 2, CURRENT_DATE),
    (13, 3, CURRENT_DATE),
    (14, 3, CURRENT_DATE),
    (15, 2, CURRENT_DATE),
    (16, 1, CURRENT_DATE),
    (17, 2, CURRENT_DATE),
    (18, 3, CURRENT_DATE),
    (19, 3, CURRENT_DATE),
    (20, 2, CURRENT_DATE),
    (21, 1, CURRENT_DATE),
    (22, 2, CURRENT_DATE),
    (23, 1, CURRENT_DATE),
    (24, 2, CURRENT_DATE),
    (25, 2, CURRENT_DATE),
    (26, 3, CURRENT_DATE),
    (27, 3, CURRENT_DATE),
    (28, 3, CURRENT_DATE),
    (29, 1, CURRENT_DATE),
    (30, 3, CURRENT_DATE),
    (31, 2, CURRENT_DATE),
    (32, 1, CURRENT_DATE),
    (33, 2, CURRENT_DATE),
    (34, 3, CURRENT_DATE),
    (35, 2, CURRENT_DATE); 

insert into avaliacao (alunoID,personalID,data,descricao)
values (12, 6,'2024-10-01','Perdeu 3kg desde a última avaliação!');

insert into avaliacao (alunoID,personalID,data,descricao)
values (13, 10,'2024-10-01','Ganhou 10kg desde a última avaliação!');

insert into avaliacao (alunoID,personalID,data,descricao)
values (15, 6,'2024-04-10','Está com 75kg, faltando 5 kg para peso ideal');

insert into avaliacao (alunoID,personalID,data,descricao)
values (11, 6,'2024-10-01','Perdeu 3kg desde a última avaliação!');

insert into avaliacao (alunoID,personalID,data,descricao)
values (11, 6,'2024-10-07','Perdeu 5 kg desde a última avaliação!');

insert into avaliacao (alunoID,personalID,data,descricao)
values (13, 10,'2024-10-12','Está com 88kg, precisando perder 8kg para peso ideal');

INSERT INTO agendamento (data, horario, personalID, alunoID)
VALUES 
('2024-04-12', '15:00:00', 6, 11),
('2024-04-12', '16:00:00', 7, 15),
('2024-04-12', '17:00:00', 8, 11),
('2024-04-12', '18:00:00', 9, 17),
('2024-04-12', '19:00:00', 10, 18),
('2024-04-12', '20:00:00', 6, 19),
('2024-04-12', '21:00:00', 8, 11),
('2024-04-12', '22:00:00', 8, 21),
('2024-04-12', '23:00:00', 7, 22),
('2024-04-13', '01:00:00', 9, 11),
('2024-04-13', '02:00:00', 10, 24),
('2024-04-13', '03:00:00', 6, 11),
('2024-04-13', '04:00:00', 9, 26),
('2024-04-13', '05:00:00', 7, 27),
('2024-04-13', '06:00:00', 6, 28);
```














