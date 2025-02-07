# Desafio projeto em Spring

O objetivo deste desafio é a criação de uma aplicação web que retorne os dados climáticos quando o usuário inserir os 
parâmetros de latitude e longitude.

### 🎯 1 - Objetivo do projeto:

- Construir o back-end da API com Java e Spring;
- Utilizar Thymeleaf para a construção do front-end;
- Validar possíveis erros de input do usuário;
- Salvar as pesquisas do usuário em um banco de dados falso em formato JSON.

###
### 🛠️ 2 - Hard Skills desenvolvidas:

Com o desenvolvimento do projeto, foram trabalhadas algumas habilidades, como:
        
- Criação e manipulação de projeto Spring;
- Manipulação de biblioteca GSON;
- Revisão do framework Bootstrap;
- Criação e manipulação das páginas web com Thymeleaf;
- Manipulação de arquivo JSON para salvamento de dados.

###
### 🏭 3 - Execução do projeto:

Para colocar o projeto em execução, é necessário possuir Java 23 ou superior e Maven 3.9.9 ou superior instalados na
máquina. Caso não possua, os links abaixo podem auxiliar a cumprir estes requisitos.

    Java: https://www.oracle.com/br/java/technologies/downloads/

###### OBS: use o camando "java --version" para verificar se o Java foi instalado corretamente.

####

    Maven: https://maven.apache.org/download.cgi

###### OBS: use o camando "mvn -v" para verificar se o Maven foi instalado corretamente.

Após realizar a instalação do Java e Maven, acesse a pasta springChallenge como no exemplo abaixo:

    C:\user\Documents\GitHub\Project\springChallenge> 

Com a pasta aberta, execute o seguinte código para instalação de dependências do projeto:

    mvn clean install

###### OBS: em caso de erro, utilize o comando "mvn dependency:purge-local-repository" para forçar instalação de dependências.

Após a realização da instalação de dependências, utilize o comando abaixo para inicializar o servidor:

    mvn spring-boot:run

Por fim, com o servidor em produção, basta inserir a rota abaixo para acessar a aplicação:

    http://localhost:8082/form/submit