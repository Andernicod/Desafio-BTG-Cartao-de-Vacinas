# Desafio BTG - Carteira de Vacinação

Este é um projeto que desenvolvi para o desafio BTG incluindo o Frontend (HTML, CSS, JavaScript) e Backend (No qual foi desenvolvido na linguagem Java utilizando SpringBoot, JWT e Banco de Dados Postgree)

[![Video de Apresentação](https://img.youtube.com/vi/frwpT8oDAq4/0.jpg)](https://youtu.be/frwpT8oDAq4)

## O Sistema:
O sistema permite o gerenciar carteiras de vacinação, com as seguintes funções:

- Autenticação  
- Cadastrar  
- Registrar e excluir pacientes  
- Registrar e excluir vacinas por paciente  
- Consulta das vacinas aplicadas  
- Edição das vacinas  
- Comunicação entre Frontend e Backend via **API REST**

## Tecnologias Usadas:

### Frontend
- **HTML5:** Para as páginas de login, cadastro e o painel de vacinação.
- **CSS3:** Arquivos:
  - `style_login.css` para telas de login
  - `style_vacinas.css` para o sistema principal de vacinas
- **JavaScript:**
  - Manipulação do DOM
  - Requisições assíncronas na API usando `fetch`
  - Armazenamento de JWT do token no `localStorage` para autenticar
  - Popups para alertas e inputs no editar

### Backend (Spring Boot em Java)

- **Spring Boot:**
  - Foi ultilizada a estrutura MVC (Controllers, Repositories, Entities)
  - Os Endpoints em RESTful
- **Spring Security + JWT (Token):**
  - Para autenticação
  - Proteção de endpoints com JWT
- **Banco de Dados:**
  - Relacionamentos: Foi usado o relacionamento ManyToOne entre Vacinas e Pacientes para vincular uma vacina com sua data de aplicação a um determinado paciente

## Funcionalidades:

### Autenticação de Usuário:

| Método | Endpoint | Descrição |
|-------|---------|--------|
| POST | `/register` | Cadastro de um novo usuário |
| POST | `/authenticate` | Para login e geração de JWT |

###  Pacientes:

| Método | Endpoint | Função |
|-------|---------|--------|
| POST | `/api/pacientes` | Cria um novo paciente |
| GET | `/api/pacientes` | Lista os pacientes |
| GET | `/api/pacientes/{id}` | Busca o paciente por ID |
| PUT | `/api/pacientes/{id}` | Edita o paciente |
| DELETE | `/api/pacientes/{id}` | Exclui o paciente e suas vacinas |

### Vacinas:

| Método | Endpoint | Função |
|-------|---------|--------|
| POST | `/api/vacinas` | Cadastra uma vacina |
| GET | `/api/vacinas/paciente/{id}` | Lista as vacinas por paciente |
| PUT | `/api/vacinas/{id}` | Edita a vacina |
| DELETE | `/api/vacinas/{id}` | Exclui a vacina |

## Funcionalidades do Frontend:

Login e cadastro de usuário  
Busca de pacientes  
Cadastrar, editar e excluir pacientes  
Consulta as vacinas de um paciente  
Cadastra, edita e exclui vacinas de um paciente  
Popups personalizados para feedback (sucesso, erro, confirmação)

## Como Rodar o Projeto?
### Backend:

# Requisitos: Java 17+, Maven
./mvnw spring-boot:run

### Frontend:
Basta abrir a rota http://localhost:8080/html/login.html no navegador (após garantir que o backend esteja rodando).

## Conclusão
Neste projeto, desenvolvi um sistema funcional, aplicando boas práticas de programação. Foi uma ótima oportunidade para aprofundar meus conhecimentos em front e backend, além de trabalhar com autenticação e API REST.