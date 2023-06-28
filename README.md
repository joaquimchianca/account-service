# User Service

## Descrição
Este repositório contém a implementação do serviço de gestão de usuário do VascoBank.

## Compilação e execução
A aplicação possui configuração dos containers para rodar num ambiente de Docker.

Para compilar e executar:
````bash
git clone git@github.com:joaquimchianca/user-service.git
cd user-service
mvn clean package -DskipTests
docker compose up
````

## API

| Método HTTP | URI da API              | Descrição                                                  |
|-------------|-------------------------|------------------------------------------------------------|
| POST        | /api/usuarios           | Cadastra um usuário no banco de dados                      |
| GET         | /api/usuarios           | Lista todos os usuários com cadastro ativo                 |
| GET         | /api/usuarios/{id}      | Lista um usuário ativo com ID específico                   |
| PUT         | /api/usuarios/{id}      | Atualiza informações de um usuário ativo                   |
| DELETE      | /api/usuarios/{id}      | Soft delete de um usuário (altera seu status para inativo) |
