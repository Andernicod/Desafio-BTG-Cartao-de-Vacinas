# Desafio BTG - Carteira de Vacinação

Este é um projeto que desenvolvi para o desafio BTG, incluindo o Frontend (HTML, CSS, JavaScript) e Backend (desenvolvido em Java utilizando Spring Boot, JWT e banco de dados PostgreSQL).

[![Vídeo de Apresentação](https://img.youtube.com/vi/frwpT8oDAq4/0.jpg)](https://youtu.be/frwpT8oDAq4)

## O Sistema

O sistema permite gerenciar carteiras de vacinação, com as seguintes funções:

- Autenticação  
- Cadastro  
- Registro e exclusão de pacientes  
- Registro e exclusão de vacinas por paciente  
- Consulta das vacinas aplicadas  
- Edição das vacinas  
- Comunicação entre Frontend e Backend via **API REST**

## Tecnologias Usadas

### Frontend

- **HTML5:** Para as páginas de login, cadastro e painel de vacinação.  
- **CSS3:**  
  - `style_login.css` para telas de login  
  - `style_vacinas.css` para o sistema principal de vacinas  
- **JavaScript:**  
  - Manipulação do DOM  
  - Requisições assíncronas na API usando `fetch`  
  - Armazenamento do token JWT no `localStorage` para autenticação  
  - Popups para alertas e inputs no editar  

### Backend (Spring Boot em Java)

- **Spring Boot:**  
  - Estrutura MVC (Controllers, Repositories, Entities)  
  - Endpoints RESTful  
- **Spring Security + JWT:**  
  - Autenticação e proteção de endpoints com JWT  
- **Banco de Dados:**  
  - Relacionamentos ManyToOne entre Vacinas e Pacientes para vincular vacina à data de aplicação e paciente  

## Funcionalidades

### Autenticação de Usuário

| Método | Endpoint       | Descrição                  |
|--------|----------------|----------------------------|
| POST   | `/register`    | Cadastro de um novo usuário |
| POST   | `/authenticate`| Login e geração de JWT      |

### Pacientes

| Método | Endpoint          | Função                       |
|--------|-------------------|-----------------------------|
| POST   | `/api/pacientes`  | Cria um novo paciente        |
| GET    | `/api/pacientes`  | Lista os pacientes           |
| GET    | `/api/pacientes/{id}` | Busca o paciente por ID  |
| PUT    | `/api/pacientes/{id}` | Edita o paciente          |
| DELETE | `/api/pacientes/{id}` | Exclui o paciente e suas vacinas |

### Vacinas

| Método | Endpoint                 | Função                     |
|--------|--------------------------|----------------------------|
| POST   | `/api/vacinas`           | Cadastra uma vacina        |
| GET    | `/api/vacinas/paciente/{id}` | Lista vacinas por paciente |
| PUT    | `/api/vacinas/{id}`      | Edita a vacina             |
| DELETE | `/api/vacinas/{id}`      | Exclui a vacina            |

## Funcionalidades do Frontend

- Login e cadastro de usuário  
- Busca de pacientes  
- Cadastrar, editar e excluir pacientes  
- Consulta das vacinas de um paciente  
- Cadastrar, editar e excluir vacinas de um paciente  
- Popups personalizados para feedback (sucesso, erro, confirmação)  

## Como Rodar o Projeto?

### Backend

Requisitos: Java 17+, Maven

```bash
./mvnw spring-boot:run