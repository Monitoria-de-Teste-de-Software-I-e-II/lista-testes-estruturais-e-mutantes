# Lista de Exercícios 02 - Teste Estrutural e Teste de Mutação

## Contexto geral

Este projeto Maven já está configurado com Java 17 ou superior, JUnit 5 e JaCoCo. As classes necessárias já estão implementadas no pacote `br.ufrn.dimap.services`.

Nesta lista, você deve analisar o código, criar testes unitários com JUnit 5 e interpretar os relatórios gerados pelas ferramentas de cobertura e mutação.

Você não deve alterar as classes para resolver as questões. Crie apenas classes de teste em `src/test/java/br/ufrn/dimap/services`.

## Instruções de execução

Para compilar o projeto:

```bash
mvn clean compile
```

O Maven precisa estar usando JDK 17 ou superior. Verifique com:

```bash
mvn -version
```

Se o Maven estiver apontando para um JDK anterior, ajuste a variável `JAVA_HOME` antes de executar os comandos.

Para executar os testes unitários:

```bash
mvn test
```

Para gerar o relatório de cobertura com JaCoCo:

```bash
mvn clean test
```

Após a execução, abra o relatório em:

```text
target/site/jacoco/index.html
```

## Tutorial no IntelliJ

Para um passo a passo sobre como executar testes, visualizar cobertura e rodar testes de mutação no IntelliJ IDEA, consulte:

[Tutorial: cobertura de testes e testes de mutação no IntelliJ](docs/TUTORIAL_COBERTURA_E_MUTACAO_INTELLIJ.md)
