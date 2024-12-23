# Projeto: Sistema de Gerenciamento de Livros e Autores

## Descrição do Projeto
Este projeto é um sistema para gerenciamento de livros e autores. Ele permite buscar livros por nome, adicionar autores e livros associados, e exibir informações detalhadas sobre autores e suas obras. Além disso, o sistema integra-se com uma API externa para buscar informações de livros que não estão cadastrados na base local.

## Funcionalidades
- **Cadastro de Autores**: Registra autores com informações como nome, ano de nascimento e falecimento.
- **Cadastro de Livros**: Registra livros com título, idioma, número de downloads e associa o autor correspondente.
- **Busca de Livros**: Permite buscar livros pelo título na base local ou consultar dados em uma API externa caso o livro não seja encontrado.
- **Exibição Detalhada**: Lista autores com os títulos dos livros associados.

## Como Utilizar
1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd seu-repositorio
   ```
3. Configure o banco de dados PostgreSQL com as credenciais no arquivo `application.properties`.
4. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
5. Interaja com o sistema através da interface de linha de comando.

6. ## Como Utilizar

1. Ao iniciar o sistema, o menu com as opções acima será exibido.
2. Digite o número correspondente à funcionalidade desejada e pressione Enter.
3. Siga as instruções na tela para fornecer os dados necessários (como título do livro ou idioma).
4. O sistema retornará os resultados ou executará a ação correspondente.


## Onde Encontrar Ajuda
Se você encontrar problemas ou tiver dúvidas sobre o projeto, pode consultar as seguintes opções:
- [Documentação do Spring Boot](https://spring.io/projects/spring-boot)
- [Documentação do PostgreSQL](https://www.postgresql.org/docs/)
- A seção de **Issues** do repositório GitHub.

## Autores
- **Atos Mendes**  
  Desenvolvedor Full Stack  
  [GitHub](https://github.com/atosmendes)  
  [LinkedIn](https://linkedin.com/in/atosmendes)
