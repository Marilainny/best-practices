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
<q>Você sabe que está criando um código limpo quando cada rotina que você leia se mostra como o que você esperava. Você pode chamar de código belo quando ele também faz parecer que a linguagem foi feita para o problema - Ward Cunningham.</q>

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
    <li>Qual a importância do valor 4?</li>
    <li>Como eu usaria a lista retornada?</li>
</ul>
</p>

<h2>Código acima refatorado</h2>

<pre><code>public List<int[]> getFlaggedCells(){
	List<int[]> flaggedCells = new ArrayList<int[]>();
	for (int[] cell : gameboard)
		if (cell[STATUS_VALUE] == FLAGGED)
			flaggedCells.add(cell);
	return flaggedCells;
</code></pre>

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
    }
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

<p>Nome de classes: devem ser substantivos: Cliente, PaginaWiki, Conta, e AnaliseEndereço. Nome de métodos: devem ser verbos: postarPagamento, excluirPagina, salvar.</p>

<pre><code>String name = employee.getName();
    customer.setName("mike");
    if (paycheck.isPosted()){
        /*....*/
}</code></pre>

<p>Quando os construtores estiverem sobrecarregados, use métodos factory estáticos, com nomes que descrevam os parâmetros.</p>

<pre><code>Complex fulcrumPoint = Complex.FromRealNumber(23,0);</code></pre>
<pre><code>Complex fulcrumPoint = new Complex(23,0);</code></pre>

<h2>Evite</h2>

<ul type="square">
    <li>Evite gírias e brincadeiras com os nomes do código.</li>
    <li>Selecione uma palavra por conceito.</li>
    <li>Não faça trocadilhos.</li>
    <li>Use nomes a partir do domínio da solução.</li>
    <li>Use prefixo nas variáveis que formam um conjunto.</li>
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
	String guessMessage = String.format("There %s %s %s%s, verb, number, candidate, pluralModifier");
	print(guessMessage);
}</code></pre>

<h2>Exemplo variáveis que possuem contexto</h2>

<pre><code>public class GuessStatisticsMessage{
	private String number;
	private String verb;
	private String pluralModifier;
	
	public String make(char candidate, int count){
		createPluralDependentMessageParts(count);
		return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
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
    Funções devem ser pequenas, cada função tem que fazer apenas uma única coisa. Dentro da função if, else, while, entre outros, devem ter apenas uma linha, possivelmente a chamada de função. Estrutura Switch sempre fazem N coisas, não podemos evitá-lás, mas certifique se cada um está em uma classe de baixo nível e nunca é repetido.
</p>

<p>
    Essa função abaixo é grande, e conforme o quadro de funcionário ela vai aumentar ainda mais. Ela faz mais de uma coisa. Viola o princípio de Aberto-Fechado, pois precisa ser modificada sempre novos tipos forem adicionados. A solução é inserir a estrutura switch em uma ABSTRACT FACTORY.
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
		}
    }
}</code></pre>

<pre><code>public abstract class Employee{
	
	public abstract boolean isPayday();
	public abstract Money calculatePay();
	public abstract void deliverPay(Money pay);
}</code></pre>

<h2>Parâmetros</h2>

<p>A quantidade de parâmetros para uma função é zero. Depois vem mônada, em seguida díade. Evite três parâmetros. Passar boolean para uma função é uma prática ruim, pois é explícito que a função faz mais de uma coisa.</p>

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

<h2>Efeito colateral</h2>

<p>O efeito colateral é chamado de Session.initialize(), ela não inicializa a sessão, esse efeito colateral cria um acoplamento temporário. Separação, comando, consulta, as função devem fazer ou responder algo, mas não ambos. Fazer funções retornarem códigos de erros é uma leve violação da separação comando-consulta, Prefira exceções a retorno de código de erro.</p>

<pre><code>if (deletePage(page) == E_OK) {
	if (registry.deleteReference(page.name) == E_OK){
		if (configKeys.deleteKey(page.name.makeKey()) == E_OK){
			logger.log("página excluída");
		}else { 
			logger.log("configKeys não foi excluída");
		}
		logger.log("deleteReference não foi excluída do registro");
	}else{
		logger.log("a exclusão falhou");
		return E_ERROR;
	}
}</code></pre>

<h2>exceções</h2>

<p>Ao usar a exceções em vez de retornar códigos de erros, então o tratamento de erro pode ser separado.</p>

<pre><code>try {
	deletePage(page);
	registry.deleteReference(page.name);
	configKeys.deleteKey(page.name.makeKey());
}
catch (Exception e){
	logger.log(e.getMessage();
}</code></pre>

<p>Extraia os blocos try/catch.As funções deve fazer uma coisa só. Classe de erro cria dependências.</p>

<pre><code>public void delete(Page page){
	try{
		deletePageAndAllReferences(page);
	}
	catch (Exception e){
		logError(e);
	}
}</code></pre>

<pre><code>private void deletePageAndAllReferences(Page page) throws Exception {
	deletePage(page);
	registry.deleteReference(page.name);
	configKeys.deleteKey(page.name.makeKey());
}</code></pre>

<pre><code>private void logError(Exception e){
	logger.log(e.getMessage());
}</code></pre>

<h1>Comentários</h1>

<p>Código claro e expressivos com poucos comentários são superiores a muitos comentários. Explicar o código pelo comentário é ruim. Certos comentários são necessários e benéficos, mas sempre que for possível, usar o nome da função para transmitir a informação. A maioria dos comentários são ruins pois não são atualizados ao longo do tempo, e podem levar ao erro se não estiverem bem objetivo. Alguns comentários são redundantes. Evite o comentário se for possível usar uma função ou uma variável.</p>

<h2>Formatação do código</h2>

<p>Declaração das variáveis - Todas as variáveis devem ser declaradas antes que possam ser usadas. Declarar uma variável significa criá-la em algum ponto do programa. Variáveis de Classe - Variáveis declaradas como estáticas são variáveis compartilhadas entre todos os objetos instanciados a partir de uma classe.</p>

<p>Variáveis Locais - Podem ser utilizadas dentro do método onde foram declaradas, não sendo acessíveis de outros pontos do programa.</p>

<pre><code>private static void readPreferences(){
	inputStream is = null
	try{
		is = new FileInputStream(getPreferencesFile());
		setPreferences(new Properties(getPreferences());
		getPreferences().load(is);
	}catch (IOException e) {
		try{
			if (is != null){
				is.close();
			}catch (IOException e1){
			}
		}
	}
}</code></pre>

<pre><code>public int countTestCases(){
	int count = 0;
	for (Test each : tests){
		count += each.countTestCases();
	}
	return count;
}</code></pre>

<p>Instâncias de variáveis devem ser declaradas no início da classe. funções dependentes devem ficar verticalmente próximas.</p>

<pre><code>public class WikiPageResponder implements SecureResponder{
	protected WikiPage page;
	protected PageData pageData;
	protected String pageTitle;
	protected Request request;
	protected PageCrawler crawler;
	
	public Response makeResponse(FitNesseContext context, Request request) 
		throws Exception {
		String pageName = getNameOrDefault(request, "FrontPage");
		loadPage(pageName, context);			
		if(page == null){
			return notFoundResponse(context, request);
		}else{
			return makePageResponse(context);
		}
	}
		
	private String getPageNameOrDefault(Resquest request, String defaultPageName){
		
		String PageName = request.getResource();
		if (StringUtil.isBlank(pageName)){
			pageName = defaultPageName;
		}
		return pageName;
	}
	
	protected Response notFoundResponse(FitNesseContext context, Request request)
		throws Exception {
			return new NotFoundResponder().makeResponse(context, request);
	}
	
	private SimpleReponse makePageResponse(FitNesseContext context)
		throws Exception {
			pageTitle = PathParser.render(crawler.getFullPath(page));
		String html = makeHtml (context);
		
		SimpleReponse response = new SimpleResponse();
		reponse.setMaxAge(0);
		reponse.setContent(html);
		return response;
	}	
}</code></pre>

