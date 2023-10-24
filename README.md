
# Students Gen

API RESTful de cadastro de alunos e de suas notas semestrais.






## Stack utilizada

**Back-end:** Java 17.0 LTS, Spring Boot 3


## Documentação da API

#### Retorna todos os alunos cadastros

```http
  GET /students
```

#### Retorna um aluno


```http
  GET /students/${idStudent}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `idStudent` | `UUID` | **Obrigatório**. É a chave de cada aluno cadastrado. |

#### Cadastra um aluno


```http
  POST /students
```
```
  {
    "name": "string",
    "age": int,
    "firstSemesterGrade": bigdecimal,
    "secondSemesterGrade": bigdecimal,
    "teachersName": "string",
    "classroomNumber": int  
   }

```

#### Atualiza o cadastro de um aluno


```http
  PUT /students/${idStudent}
```
```
  {
    "name": "string",
    "age": int,
    "firstSemesterGrade": bigdecimal,
    "secondSemesterGrade": bigdecimal,
    "teachersName": "string",
    "classroomNumber": int  
   }

```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `idStudent` | `UUID` | **Obrigatório**. É a chave de cada aluno cadastrado. |

#### Remove o cadastro de um aluno


```http
  DELETE /students/${idStudent}
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `idStudent` | `UUID` | **Obrigatório**. É a chave de cada aluno cadastrado. |


