<!-- Configuração do git README.md no site: https://docs.github.com/pt/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax-->

# best-practices
Repositório público para estudo de boas práticas de programação.

<h2>Código Limpo</h2>
<ol>
    <li>Habilidades Práticas do Agile Software</li>
    <li>autor: Robert Cecil Martin</li>
    <li>editora: Alta Books</li>
</ol>


<q>Referência dos estudos do livro: Código Limpo - Habilidades Práticas do Agile Software - Autor: Robert C. Martin -
    2009.</q>

<h1>O que é um código limpo?</h1>
<q>Você sabe que está criando um código limpo quando cada rotina que você leia se mostra como o que você esperava. Você
    pode chamar de código belo quando ele também faz arecer que a linguagem foi feita para o problema - Ward
    Cunningham.</q>

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

<p>
    Escolher nomes que revelem seu propósito<br>
    No exemplo abaixo:
<pre><code>public List<int[]> getThem {
        List<int[]> list1 = new ArrayList<int[]>();
        for (int[] x : theList)
            if (x[0] ==4)
                list1.add(x);
        return list1;</code></pre>
</p>
<p>
<ul type="square">
    <li>Que tipos de coisas estão em theList?</li>
    <li>Qual a importância de um item na posição zero na theList?</li>
    <li>Qual a importâncai do valor 4?</li>
    <li>Como eu usaria a lista retornada?</li>
</ul>
</p>
<h2>Código acima refatorado</h2>
<pre><code>public List<int[]> getFlaggedCells(){
	List<int[]> flaggedCells = new ArrayList<int[]>();
	for (int[] cell : gameboard)
		if (cell[STATUS_VALUE] == FLAGGED)
			flaggedCells.add(cell);
	return flaggedCells;</code></pre>

<h2>Simplificando o código</h2>
<pre><code>public List<Cell> getFlaggedCells(){
	List<Cell> flaggedCells = new ArrayList<Cell>();
	for (Cell cell : gameboard)
			if (cell.isFlagged())
				flaggedCells.add(cell);
	return flaggedCells;		
}</code></pre>

<h2>Faça Distinções significativas</h2>
<pre><code>public static void copyChars(char a1[], char a2[]){
	for (int i = 0; i < a1.length; i++){
		a2[i] = a1[i];
	}
}</code></pre>

<h2>Use nomes pronunciáveis</h2>
<pre><code>class DtaRcrd102 {
	private Date genymdhms;
	private Date modymdhms;
	private final String pszqint = "102";	
}</code></pre>

<pre><code>class Customer{
	private Date generationTimestamp;
	private Date modificationTimestamp;
	private final String recordId = "102";
}</code></pre>

<h2>Use nomes passíveis de busca</h2>
<pre><code>for (int j=0; j<34; j++){
	s += (t[j]*4)/5;
}</code></pre>

<pre><code>int realDaysPerIdealDay = 4;
    const int WORK_DAYS_PER_WEEK = 5;
    int sum = 0;

    for (int j=0; j < NUMBER_OF_TASKS; j++){
        int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
        int realTaskWeeks = (realdays / WORK_DAYS_PER_WEEK);
        sum += realTaskWeeks;
    }</code></pre>
<h2>Evite nome de váriavél em código</h2>
<pre><code>public class Part {
	private String m_dsc; //Descrição textual
	void setName(String name){
		m_dsc = name;
	}
}</code></pre>
<h3>Forma correta sem codificação</h3>
<pre><code>public class Part{
	String description;
	void setDescription(String description){
		this.description = description;
	}
}</code></pre>
<h2>Padrões</h2>
<p>Nome de classes: devem ser substantivos: Cliente, PaginaWiki, Conta, e AnaliseEndereço. Nome de métodos: devem ser
    verbos: postarPagamento, excluirPagina, salvar.</p>
<pre><code>String name = employee.getName();
    customer.setName("mike");
    if (paycheck.isPosted()){
        /*....*/
    }</code></pre>
<h2>Quando os construtores estiverem sobrecarregados, use métodos factory estáticos, com nomes que descrevam os
    parâmetros.</h2>
<pre><code>Complex fulcrumPoint = Complex.FromRealNumber(23,0);</code></pre>
<pre><code>Complex fulcrumPoint = new Complex(23,0);</code></pre>

<h2>Evite</h2>
<ul type="square">
    <li>Evite gírias e brincadeiras com os nomes do código.</li>
    <li>Selecione uma palavra por conceito.</li>
    <li>Não faça trocadilhos.</li>
    <li>Use nomes a partir do domínio da solução.</li>
    <li>Use prefixo nas variaveis que formam um conjunto.</li>
    <li>A solução as vezes é criar uma classe que engloba um conjunto de variáveis.</li>
</ul>
<pre><code>public class Address{
	String addrFirstName;
	String addrLastName;
	String addrState;
}</code></pre>

<h2>Variáveis com contexto obscuro</h2>
<pre><code>private void printGuessStatistica(char candidate, int count){
	String number;
	String verb;
	String pluralModifier;
	
	if (count == 0){
		number = "no";
		verb = "Existem";
		pluralModifier = "s";
	}else if (count == 1){
		number = "1";
		verb = "Existe";
		pluralModifier = "";
	}else {
		number = Integer.toString(count);
		verb = "Existem";
		pluralModifier = "s";
	}
	String guessMessage = String.format(
	"There %s %s %s%s, verb, number, candidate, pluralModifier");
	print(guessMessage);}</code></pre>

<h2>Exemplo variáveis que possuem contexto</h2>
<pre><code>public class GuessStatisticsMessage{
	private String number;
	private String verb;
	private String pluralModifier;
	
	public String make(char candidate, int count){
		createPluralDependentMessageParts(count);
		return String.format(
		"There %s %s %s%s",
		verb, number, candidate, pluralModifier);		
	}
	private void createPluralDependentMessageParts(int count){
		if(count ==0){
			thereAreNoLetters();
		}else if (count ==1){
			thereIsOneLetter();
		}else {
			thereAreManyLetters(count);
		}
	}
	private void thereAreManyLetters(int count){
		number = Integer.toString(count);
		verb = "Existem";
		pluralModifier = "s";
	}
	private void thereIsOneLetter(){
		number = "1";
		verb = "Existem";
		pluralModifier = "";
	}
	private void thereAreNoLetters(){
		number = "no";
		verb = "Existem";
		pluralModifier = "s";
	}
}</code></pre>
<h2>Funções</h2>
<p align="justify">
    Funções devem ser pequenas, cada função tem que fazer apnas uma única coisa. Dentro da função if, else, while, entre outros, devem ter apenas uma linha, possivelmente a chamada de função. Estrutura Switch sempre fazem N coisas, não podemos evitar-lás, mas certifique se cada um está em uma classe de baixo nível e nunca é repetido.
</p>
<p>
    Essa função abaixo é grande, e conforme o quadro de funcionário ela vai aumentar ainda mais. Ela faz mais de uma coisa.Viola o princípio de Aberto-Fechado, pois precisa ser modificada sempre novos tipos forem adicionados. A solução é inserir a estrutura switch em uma ABSTRACT FACTORY.
</p>
<pre><code>public Money calculatePay(Employee e){
	throws InvalidEmployeeType{
		switch (e.type){
			case COMMISSIONED:
				return calculateCommissionedPay(e);
			case HOURLY:
				return calculateHourlyPay(e);
			case SALARIED:
				return calculateSalariedPay(e);
			default:
			throw new InvalidEmployeeType(e.type);
		}</code></pre>
<pre><code>public abstract class Employee{
	
	public abstract boolean isPayday();
	public abstract Money calculatePay();
	public abstract void deliverPay(Money pay);
}</code></pre>
<h2>Parâmetros</h2>
<p>A quantidade de parâmetros para uma função é zero. Depois vem monâde, em seguida díade Evite três parâmetros. Passar boolean para uma função é um prática ruim, pois é explicito que a função faz mais de uma coisa.</p>
<pre><code>public class UserValidador{
	
	private Cryptographer cryptographer;
	
	public boolean checkPassword(String username, String password){
		User user = UserGateway.findByName(userName);
		if (user != User.NULL) {
			String codedPharse = User.getPharseEncodeByPassword();
			String pharse = crytographer.decrypt(codePharse, password);
			if("Valid Password".equals(pharse){
				Session.initialize();
				return true;
			}
		}
		return false;
	}
}</code></pre>
