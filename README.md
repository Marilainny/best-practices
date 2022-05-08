<!-- Configuração do git README.md no site: https://docs.github.com/pt/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax-->

# edu-java-basico
Repositório de código basico de java, de acesso público.
<h1>Anotações Gerais</h1>

<h2>Constantes</h2>
<p>Assinatura final, nome da constante usar letras Uppercase, pode declarar a contante como static</p>
<pre><code>final int DAYS_PER_WEEK = 7;</code></pre>
<pre><code>puclic class calendar{

    public static final int DAYS_PER_WEEK = 7;

    }
</code></pre>

<h2>Enum</h2>
<p>Enum são objetos</p>
<pre><code>enum Weekday {MONDAY, TUESDAY, WENESDAY, THURDAY, FRIDAY, SATURDAY, SUNDAY};</code></pre>
<pre><code>Weekday startDay = Weekday.MODAY;</code></pre>

<h2>Basic Arithmetic</h2>
<p>Preste atenção ao usar calculos com inteiros</p>
<pre><code>17 / 5 é 3</code></pre>
<pre><code>17.0 / 5 é 3.4</code></pre>

<p>Um inteiro dividido por zero vai ocorrer uma Exception e parar seu programa.</p>
<p>Incrementar ++n é diferente de incrementar n++.</p>

<h2>Potência, raiz</h2>
<pre><code>Math.pow(x, y)</code></pre>
<pre><code>Math.sqrt(x)</code></pre>

<h2>Conversão char</h2>
<pre><code>'J' + 1 = 75</code></pre>
<p>O valor de 'J' é 74</p>

<h2>Cast operador</h2>
<pre><code>
    double x = 3.75
    int n = (int) x;        
</code></pre>
<p>Neste exemplo o valor será arredondado</p>
<pre><code>int n = (int) Math.round(x);</code></pre>
<pre><code>
    int n = 1;
    char next = (char) ('J'+ n); //converter 75 to 'K'.
</code></pre>

<h2>Operadores lógicos</h2>
<p>Evite Exception validando os valores zero</p>
<pre><code> n! = 0 && s + (100 -s) / n < 50</code></pre>
<pre><code> n == 0 || s + (100 -s) / n >= 50</code></pre>

<h2>Condição</h2>
<pre><code> time < 12 ? "am" : "pm"</code></pre>

<h2>Concatenação</h2>
<pre>
    <code>
    int age = 42;
    String output = age + " years.";
    --output: 42 years.
    </code>
</pre>
<pre>
    <code>
    "Next year, you will be " + age + 1 //Error
    "Next year, you will be " + (age + 1) //Ok
    </code>
</pre>

<p>Para combinar várias strings separadas com um delimitador use o join</p>
<pre>
    <code>
    String names = String.join(",", "Peter", "Paul", "Mary");
    // Sets names to "Peter, Paul, Mary";
    </code>
</pre>
<p>Concatenação em grande quantidade de strings use StringBuilder</p>
<pre>
    <code>
    StringBuilder builder = new StringBuilder();
    While(more strings){
        builder.append(next string);
    }
        String result = builder.toString();
    </code>
</pre>

<p>Para selecionar uma parte da string utilize o Substring</p>
<pre>
<code>
    String greeting = "Hello, World!";
    String location = greeting.substring(7,12);
    // Sets location to "World"
</code>
</pre>

<p>Use o método slipt para retornar um array de substrings</p>
<pre>
<code>
    String names = "Peter, Paul, Mary";
    String[] result = names.slipt(", ");
    // An array of three strings ["Peter", "Paul", "Mary"];
</code>
</pre>
<pre>
<code>
    input.split("\s+")
    //splits coloca um espaço em branco.
</code>
</pre>
<pre>
<code>
    String fraseComEspaco = "  Java java  ";
    fraseComEspaco.trim().length());
    //"Java java"
</code>
</pre>
<p>O método trim() remove o espaço em branco no ínicio e no final de uma string. Após feito isso, é chamado o método
    split() que retorna um array de String separando as palavras por espaço ou qualquer outro delimitador que vc
    preferir.</p>

<h2>Comparação de string</h2>
<p>Não use operador == para comparar strings.</p>
<pre>
<code>
    String location = greeting.substring(7, 12);
    location == "World" //locatin e World são o mesmo objeto na memoria
</code>
</pre>
<p> Nulo não é o mesmo que Vazio</p>
<pre>
<code>
    String middleName = null;
    if (middleName == null) ...
    "" //vazio
</code>
</pre>
<p>Um método nulo causa "null pointer exception". E finaliza o programa.</p>
<pre><code>
    if ("World".equals(localition))
    "world".equalsIgnoreCase(location);
    first.compareTo(second)
</code></pre>

<h2>Converter Inteiro em String</h2>
<pre><code>
    int n = 42;
    String str = Integer.toString(n);

    String str = "101010";   
    int n = Integer.parseInt(str);
</code></pre>



