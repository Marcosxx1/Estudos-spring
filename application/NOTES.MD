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

# Prototyte Scope
No Spring Framework, o escopo protótipo (@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)) cria uma nova instância de um bean toda vez que ele é solicitado pelo container do Spring. Isso contrasta com o escopo singleton padrão do Spring, onde uma única instância de um bean é criada e compartilhada por toda a aplicação.
Exemplo
```java```

```java 
import com.example.application.service.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TecnicoFutebol implements Tecnico {
    // Implementação do Tecnico
}

// E no controller

@RestController
public class DemoController {
    private final Tecnico tecnico;
    private final Tecnico outroTecnico;

    @Autowired
    public DemoController(
            @Qualifier("tecnicoFutebol") Tecnico umTecnico,
            @Qualifier("tecnicoFutebol") Tecnico oOutroTecnico) {
        this.tecnico = umTecnico;
        this.outroTecnico = oOutroTecnico;
    }
}

```

# Bean LifeCycle
- O container do spring é iniciado
  - O Spring Container é inicializado, geralmente através da cração de um _ApplicationContext_
- Bean é instanciado
  - O Spring Container cria uma instância do bean
- Dependencias são injetadas
  - Após a criação do bean, o Spring resolver e injeta quaisquer dependências declaradas
- Processamento interno do Spring
  - O Spring executa qualquer processamento adicional necessário, como chamar métodos de callback de _BeanPostProcessor_
- Nosso _init_ customizado é iniciado nessa etapa
  - Se houver métodos de inicialização personalizados definidos pelo usuário, eles são chamados nesta etapa
- Bean está pronto para uso
  - O bean está completamente configurado e pronto para ser usado pela aplicação
- Container é desligado
  - Quando a aplicação é encerrada, o Spring Container começa o processo de desligamento
- Nosso _destroy_ customizado
  - Se houver métodos de destruição personalizados definidos pelo usuário, serão chamado aqui
- Para
  - O Container do Spring é completamente encerado

```java
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Configuration
public class AppConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    public static void main(String[] args) {
        // O container do Spring é iniciado
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Bean está pronto para uso
        ExampleBean bean = context.getBean(ExampleBean.class);

        // Container é desligado
        ((AnnotationConfigApplicationContext) context).close();
    }
}

class ExampleBean implements InitializingBean, DisposableBean {

    public ExampleBean() {
        System.out.println("1. Bean é instanciado");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("4. Processamento interno do Spring");
    }

    public void customInit() {
        System.out.println("5. Nosso _init_ customizado é iniciado nessa etapa");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("8. Nosso _destroy_ customizado");
    }

    public void customDestroy() {
        System.out.println("9. Para");
    }
}
```