## @Component
A anotação @Component marca a classe como um bean do Spring, tornando-a candidata para injeção de dependência.

## @AutoWire
* Injeta uma implementação.
* O Spring escaneará as classes anotadas com @Component.
* "Alguma classe implementa a interface Coach?"
* Se sim, ela será injetada

### Exemplo:
Suponha que temos uma interface Tecnico:

```java
public interface Tecnico {
    void getTreinoDiario();
}
```

E duas implementações dessa interface:

```java
import org.springframework.stereotype.Component;

@Component
public class TecnicoDeFutebol implements Tecnico {
    @Override
    public void getTreinoDiario() {
        System.out.println("30 chutes ao gol");
    }
}

@Component
public class TecnicoDeCorrida implements Tecnico {
    @Override
    public void getTreinoDiario() {
        System.out.println("30 minutos de corrida");
    }
}
```

Em nossa classe de serviço, podemos injetar uma dessas implementações:
### Injeção via Construtor:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* 
Vantagens: Promove a imutabilidade e facilita a escrita de testes unitários, pois as dependências são passadas diretamente no construtor.
Desvantagens: Requer mais código boilerplate (um construtor adicional).
*/

@Component
public class TecnicoService {

    private final Tecnico tecnico;

    @Autowired
    public TecnicoService(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void fazerTreino() {
        tecnico.getTreinoDiario();
    }
}
```

### Injeção via Campo:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* 
Vantagens: Código mais conciso e fácil de ler.
Desvantagens: Menos adequado para testes unitários e não promove a imutabilidade da classe.
*/

@Component
public class TecnicoService {
    @Autowired
    private Tecnico tecnico;

    public void fazerTreino() {
        tecnico.getTreinoDiario();
    }
}
```


## @RequiredArgsConstructor, lombok
```java
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/*
Esta anotação gera automaticamente um construtor com um parâmetro para cada campo final não inicializado da classe.
Como tecnico é declarado como final, o Lombok gera um construtor que aceita um Tecnico.
Injeção via Construtor:

O Spring usará este construtor gerado pelo Lombok para injetar a dependência Tecnico.
O que acontece no Spring:
- O Spring encontra a anotação @Component na classe TecnicoService e registra essa classe como um bean.
- O Spring encontra a anotação @RequiredArgsConstructor (gerada pelo Lombok) e vê que a classe tem um campo final chamado tecnico.
- O Spring gera e utiliza o construtor que recebe um Tecnico como argumento e o injeta automaticamente quando cria uma instância de TecnicoService.
*/

@Component
@RequiredArgsConstructor
public class TecnicoService {

    private final Tecnico tecnico;

    public void fazerTreino() {
        tecnico.getTreinoDiario();
    }
}

```