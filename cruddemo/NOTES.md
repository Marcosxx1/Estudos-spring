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