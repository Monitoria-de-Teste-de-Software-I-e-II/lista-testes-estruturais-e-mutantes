# Tutorial: cobertura de testes e testes de mutação no Eclipse

Este tutorial explica como verificar a cobertura dos testes no Eclipse e como executar testes de mutação usando PITest em um projeto Maven com Java, JUnit 5 e JaCoCo.

## 1. Antes de começar

Verifique se o projeto foi importado como projeto Maven no Eclipse:

1. Abra o Eclipse.
2. Clique em **File > Import**.
3. Escolha **Maven > Existing Maven Projects**.
4. Selecione a pasta do projeto.
5. Clique em **Finish** e aguarde o Eclipse importar as dependências do Maven.

Caso o Eclipse mostre erros logo após a importação, clique com o botão direito sobre o projeto e escolha **Maven > Update Project**. Confirme a atualização para que as dependências sejam baixadas novamente.

## 2. Executando os testes no Eclipse

Para executar todos os testes:

1. Abra a pasta `src/test/java`.
2. Clique com o botão direito sobre a pasta de testes.
3. Escolha **Run As > JUnit Test**.

Outra opção é abrir uma classe de teste e clicar com o botão direito no editor ou no nome da classe:

1. Abra uma classe em `src/test/java`, por exemplo:

```text
src/test/java/br/ufrn/dimap/services/CalculadoraDescontoTest.java
```

2. Clique com o botão direito dentro do editor.
3. Escolha **Run As > JUnit Test**.

O resultado da execução aparece na aba **JUnit**. Nela, o Eclipse mostra quantos testes passaram, quantos falharam e em qual método ocorreu cada falha.

## 3. Vendo cobertura de testes pelo Eclipse

Cobertura de testes mostra quais partes do código foram executadas pelos testes.

O Eclipse geralmente usa o recurso de cobertura do **EclEmma**, que já vem integrado em muitas instalações da IDE. Para rodar os testes com cobertura:

1. Clique com o botão direito na pasta `src/test/java`.
2. Escolha **Coverage As > JUnit Test**.
3. Aguarde os testes terminarem.
4. Veja o resumo de cobertura na aba **Coverage**.

Depois da execução, o próprio editor marca as linhas do código:

- Verde: linha executada pelos testes.
- Vermelho: linha não executada pelos testes.
- Amarelo: linha parcialmente coberta, comum em estruturas condicionais.

Se a opção **Coverage As** não aparecer, instale o plugin **EclEmma Java Code Coverage** pelo menu **Help > Eclipse Marketplace** e reinicie o Eclipse.

Também é possível gerar o relatório HTML do JaCoCo pelo Maven. Para isso, clique com o botão direito no projeto e escolha **Run As > Maven test**. Ao final da execução, abra o arquivo:

```text
target/site/jacoco/index.html
```

Esse relatório mostra a cobertura por pacote, classe, método e linha.

## 4. Executando testes de mutação com PITest

No Eclipse, é possível executar o PITest de duas formas:

- usando o plugin **Pitclipse**, diretamente pela interface do Eclipse;
- usando o plugin do Maven, que também funciona pelo terminal e em outras IDEs.

### 4.1. Executando o PITest com o plugin Pitclipse

O **Pitclipse** é um plugin do Eclipse para executar testes de mutação com o PITest dentro da própria IDE.

1. Acesse **Help > Eclipse Marketplace...**.
2. No campo **Find** de search, informe: *pitclipse*
3. Pressione **Enter** e aguarde o Eclipse carregar os itens disponíveis.
4. Selecione os itens do Pitclipse.
5. Clique em **Next**, depois em **Finish**.
6. Reinicie o Eclipse, se ele pedir.

Depois da instalação, para executar o PITest:

1. Clique com o botão direito sobre o projeto Java.
2. Escolha **Run As > PIT Mutation Test**.
3. Aguarde a execução terminar.

Ao final, o Eclipse abre views com os resultados:

- **PIT Summary**: mostra o resumo da cobertura de mutação.
- **PIT Mutations**: mostra os mutantes encontrados e sua localização no código.

Também é possível configurar opções específicas em **Run > Run Configurations... > PIT Mutation Test**. As preferências gerais ficam em **Window > Preferences > Pitest**.

### 4.2. O que observar no relatório do PITest

No relatório, procure principalmente por:

- **Killed**: mutantes mortos pelos testes.
- **Survived**: mutantes que sobreviveram.
- **No Coverage**: mutantes em partes do código que os testes não executaram.
- **Test Strength**: percentual de mutantes eliminados pelos testes.

O ponto mais importante é olhar os mutantes marcados como **Survived**. Eles indicam trechos em que os testes ainda não conseguem perceber uma alteração incorreta no código.

Ao clicar em uma classe no relatório, o PITest mostra as linhas em que os mutantes foram criados. Quando um mutante aparece como **Survived**, revise os testes daquela regra de negócio e crie novos casos para diferenciar o comportamento correto do comportamento alterado pelo mutante.
