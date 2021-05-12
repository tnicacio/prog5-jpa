# Gerenciador de Compromissos
Trabalho para a disciplina de Programação 5 do Instituto Federal Catarinense

## :book: Enunciado do Trabalho
Crie um projeto em Java utilizando JPA que crie a base a partir do diagrama de classe
abaixo. <br/> Devem ser criados os métodos que permitam o acesso aos dados de todas as
classes para as operações de: <br/> <br/>
a. Inserir dados (1 ponto); <br/>
b. Alterar dados (1 ponto); <br/>
c. Consultar dados filtrando id (1 ponto); <br/>
d. Consultar todos (1 ponto); <br/>
e. Excluir dados (1 ponto); <br/>
f. Consultar contato pelo nome (1 ponto); <br/>
g. Consultar compromisso pelo local (1 ponto); <br/>
h. Consultar compromisso pelo contato (1 ponto); <br/>
i. Mapeamento correto (2 pontos). <br/> <br/>

Obs: <br/>
- Deve ser criado utilizando a abordagem codefirst; <br/>
- O nome da base deve ser jpacodfirst; <br/>

### Diagrama de Classes
![Diagrama de Classes](https://user-images.githubusercontent.com/50798315/118049285-ea549000-b353-11eb-9c69-b70c494f77c4.png)

## :scroll: Requisitos
Com base no enunciado do trabalho foram desenvolvidos os requisitos funcionais e não-funcionais

### Funcionais
<strong>RF01:</strong> O sistema deve permitir a inserção de dados ```insert``` <br/>
<strong>RF02:</strong> O sistema deve permitir a alteração de dados ```update``` <br/>
<strong>RF03:</strong> O sistema deve permitir a consulta aos dados através do id de cada entidade ```findById``` <br/>
<strong>RF04:</strong> O sistema deve permitir a consultar todos os registros das entidades ```findAll``` <br/>
<strong>RF05:</strong> O sistema deve permitir a exclusão dos dados ```deleteById``` <br/>
<strong>RF06:</strong> O sistema deve permitir consultar o contato pelo nome ```Contato.findByNome``` <br/>
<strong>RF07:</strong> O sistema deve permitir consultar compromissos pelo local ```Compromisso.findByLocal``` <br/>
<strong>RF08:</strong> O sistema deve permitir consultar compromissos pelo contato ```Compromisso.findByContato``` <br/>
<strong>RF09:</strong> Um Participante deve possuir um único Contato, e um Contato está atribuído a um único Participante <br/>
<strong>RF10:</strong> Um Participante pode possuir 0 ou N compromissos, e um Compromisso pode estar atribuído a 0 ou N participantes <br/>
<strong>RF11:</strong> Um Compromisso deve possuir um único Local, e um Local pode estar atribuído a 0 ou N compromissos<br/> 

### Não-funcionais
<strong>RNF01:</strong> Deve ser programado em Java, utilizando JPA <br/>
<strong>RNF02:</strong> Deverá ser utilizada a abordagem code-first <br/>
<strong>RNF03:</strong> O nome da base de dados deve ser jpacodfirst <br/>

## :nerd_face: Como testar
1. Clone este repositório através do comando ```git clone git@github.com:tnicacio/prog5-jpa.git``` <br/>
2. Execute a aplicação que possui [Program](https://github.com/tnicacio/prog5-jpa/blob/main/src/main/java/com/tnicacio/trabjpa/application/Program.java) como sua classe principal.

## :computer: Ferramentas Utilizadas
- PostgreSQL
- pgAdmin 4
- Netbeans 12
