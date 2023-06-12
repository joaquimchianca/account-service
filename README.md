# User Service

## Descrição
Este repositório contém a implementação do serviço de gestão de usuário do VascoBank.

## API

| Método HTTP | URI da API              | Descrição                                                  |
|-------------|-------------------------|------------------------------------------------------------|
| POST        | /api/usuarios           | Cadastra um usuário no banco de dados                      |
| GET         | /api/usuarios           | Lista todos os usuários com cadastro ativo                 |
| GET         | /api/usuarios/{id}      | Lista um usuário ativo com ID específico                   |
| PUT         | /api/usuarios/{id}      | Atualiza informações de um usuário ativo                   |
| DELETE      | /api/usuarios/{id}      | Soft delete de um usuário (altera seu status para inativo) |
