# MOBILE-Design-System
Open Source MOBILE Design System repository,

## How contribute?
Para contribuir você precisa criar um **merge request(MR)** seguindo as **regras de entrega**, que sera posteriormente revisado e mergeado! Não sabe o que poderia ajudar? Que tal ir para a pagina de **issue** e pegar uma para resolver? 

> É importante entender um pouco de desenvolvimento em compose e design atomico, pois este design system segue esse conceito.

### Branch:  
Todo trabalho deve ser realizado utilizando uma branch nova, toda branch deve ser criada seguindo um padrão em seu nome:  
**[tipo]** / **[contexto]** / **[descrição simples]**  

exemplo:
```
feat/button/secondary_button*
```

#### Tipos de branch:   
- **[feat]**: Branch que **adiciona** uma nova feature ao projeto
- **[fix]**: Branch que ***resolve** algum problema, principalmente listado em nossa pagina de **issues**.

#### Descrição simples:
Criar uma descrição já pensando no tipo e contexto da branch, se você esta com o tipo **feat**, num contexto de **buttons**, você não precisa descrever que esta criando um novo botão, mas apenas o nome do botão que vai ser criado. 

exemplo:
```
feat/button/secondary_button*
```

> Antes de criar uma branch, é aconselhavel buscar pela descrição se já não existe outra branch criada com o mesmo tema, este problema tende a não acontecer se este trabalho for iniciado com base em um item da nossa pagina de **issues**.

### Commit
É importante seguir um padrão de commit para facilitar que outros possam ajudar no desenvolvimento do projeto, assim como para ter um historico bem desenvolvido. Para isso é aconcelhado que a descrição do commit [siga um padrão.](https://www.dio.me/articles/git-boas-praticas-para-escrita-das-mensagens-de-commits)

> As mensagens de commit devem ser curtas e diretas, com no máximo 72 caracteres na primeira linha (assunto) e uma linha em branco após a primeira linha (descrição). Isso torna mais fácil para outros desenvolvedores entenderem rapidamente o que foi feito.

### Merge Request
Na MR devemos descrever o que foi modificado, caso tenha vindo de uma issue ela deve esta linkada na descrição.

> Esta etapa é muito importante, então pode demorar.

   
## What is Atomic Design?
Atomic Design é uma metodologia desenvolvida em 2013 por Brad Frost, que faz uma analogia com a química ao usar elementos como átomos, moléculas e organismos para criar design systems mais consistentes e padronizados dentro do desenvolvimento de uma interface.

## Design Tokens?
Tokens são como variáveis que são usadas para construir os componentes de um design system, eles podem ser cores, tamanhos entre diversos outros valores.
Os tokens deste design system usam principalmente o [builder de temas do material design](https://material-foundation.github.io/material-theme-builder/), principalmente para manter a utilização das cores dinâmicas e para facilitar a criação de uma folha de temas com o builder do material design.

Um exemplo da nossa folha de tokens pode ser encontrada [aqui](https://github.com/paixaoDev/MOBILE-Design-System/wiki/Design-Tokens)

## Components?
Componentes são partes de código reutilizáveis dentro do seu sistema e eles servem como blocos de construção de uma interface. Assim, um componente tem características como: reutilização, flexibilidade, consistência e modularidade.

A lista de componentes pode ser encontrada na [documentação](https://github.com/paixaoDev/MOBILE-Design-System/wiki/Components), por lá temos os componentes já criados e os que pretendemos criar futuramente

## Disclamer
Este repositorio foi feito como uma chance de aprender mais sobre compose e desenvolvimento de design system, é muito significativo comentarios construtivos para que possamos aprender juntos!

É importante também entender como o compose funciona e não passar por cima da sua maior qualidade que é a facil customização, então os componentes aqui vão ser "mais abertos" do que podemos encontrar em outros design system, facilitando uma implementação no projeto e edição durante seu uso. Mesmo que isso possa fugir um pouco da regra da maioria dos design systens, não faz sentido engessar os componentes. Com isso qualquer forma de melhorar a dinamica dos itens pensando nesas premissa é super bem vinda.

Espero que esse repositorio seja mais um motivo de incentivar o estudos que de que ela usado em seus projetos, vamos criar mais conteudos para compose e desenvolvimento android!

