<!-- Configuração do git README.md no site: https://docs.github.com/pt/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax-->

# best-practices
Repositório público para estudo de boas práticas de programação.

<h2>Código Limpo</h2>
<ol>
    <li>Habilidades Práticas do Agile Software</li>
    <li>autor: Robert Cecil Martin</li>
    <li>editora: Alta Books</li>
</ol>


<q>Referência dos estudos do livro: Código Limpo - Habilidades Práticas do Agile Software - Autor: Robert C. Martin - 2009.</q>

<h1>O que é um código limpo?</h1>
<q>Você sabe que está criando um código limpo quando cada rotina que você leia se mostra como o que você esperava. Você pode chamar de código belo quando ele também faz arecer que a linguagem foi feita para o problema -  Ward Cunningham.</q>

<h2>A regra de escoteiro</h2>
<p>
    Não basta escrever um código bom. Ele precisa ser mantido sempre limpo.
</p>
<h2>Nomes significativos</h2>
<p>
    Use nomes que revelem seu propósito:
</p>     
<pre><code>int d; //tempo decorrido em dias</code></pre> 
<pre><code>//forma correta de declarar
int elapsedTimeInDays;
int daysSinceCreation;
int daysSinceModification;
int fileAgeInDays;</code></pre> 

