# Anotações JPA
Hibernate é a implementação padrão JPA do Spring Boot

## @Entity class
Deve ter no mínimo
- Anotação @Entity()
- Um construtor public ou pretected sem argumentos
  - A classe pode ter outros construtores

## @Column - Opcional
- O uso de @Column é opcional
- Se nã oespecificada, o nome da columa será o mesmo que o campo da classe
- No geral, não é recomendado deixarmos sem, pois:
  - Se refatorarmos o código Java, os campos não serão iguais aos da base de dados
  - É uma mudança que vai quebrar o código pois precisaremos atualizar a coluna da base de dados
O mesmo se aplica a @Table, o nome da tabela é o mesmo da classe

# EntityManager ou JpaRepository
## EntityManager
- Se precisamos de flexibilidade e controle de baixo nível, usamos EntityManager 
  - Quando precisamos de um controle baixo nível das operações da base de dados e queremos utilizar consultas customizadas
  - Disponibiliza acesso de baixo nível ao JPA e trabalha diretamente com entidades JPA
  - Consultas mais complexas que requerem recursos mais avançados como consultas nativas SQL ou chamadas de stored procedures
  - Quando temos requisitos customisados que não são facilmente manipulados em um alto nível

## JpaRepository
- Disponibiliza operações comunmente utilizadas em CRUD, tudo já pronto para a gente, reduzindo a quantidade de código que precisamos escrever
- Recursos adicionais como paginação e organização
- Gera as consultas com base em nomes de métodos
- Se queremos um alto nível de abstração, usamos o JPA

### Podemos utilizar ambos em um projeto, mas é sempre bom sabermos ambas as tecnologias
- A escolha depende dos requisitos da aplicação e da preferencia do desenvolvedor/projeto

# @Transactional
- Começa e termina uma transação em nosso código JPA
  Não é Sempre Necessário: Embora a anotação @Transactional facilite muito o gerenciamento de transações, em certas situações, nós podemos precisar de um controle mais fino sobre transações. Por exemplo, se precisar de múltiplas operações atômicas ou se estiver lidando com transações distribuídas, pode ser necessário ajustar o escopo ou os parâmetros da anotação @Transactional.

# Anotações especializadas para DAOs
- @Component
- @RestController
- @Repository
São aplicadas em implementações DAO
- Spring irá registrar automaticamente a implementação DAO graças ao component-scaning
- Spring também disponibiliza a tradução de qualquer exception relacionada a JDBCs 

