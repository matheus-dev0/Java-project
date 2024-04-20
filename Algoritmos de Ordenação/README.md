<h1>Algoritmos de ordenação em Java</h1>

<p>Diversos algoritmos de ordenação serão feitos aqui. O objetivo é melhorar a compreensão com estruturas de dados e entender o funcionamento de cada, verificando também o custo do algoritmo em termos de utilização de recursos.</p><br>

<h2>Tipos de algoritmos</h2>
<ul>
    <li><a href="https://github.com/theus-dev/Java/blob/main/Algoritmos%20de%20Ordena%C3%A7%C3%A3o/bubbleSort.java">Bubble Sort</a>
    <p>Iterações com 6 casos de vetores desordenados, com números entre 0 e 100.000: (Estarei utilizando um algoritmo de geração aleatória de vetores, logo os testes podem variar bastante, dado a natureza indeterminística de valores aleatórios.)</p>
        <ol>
            <li>5 elementos: 10 Comparações | 8 iterações</li>
            <li>150 elementos: 11.175 Comparações | 4.956 iterações</li>
            <li>700 elementos: 244.650 Comparações | 123.790 iterações</li>
            <li>2000 elementos: 1.999.000 Comparações | 999.482 iterações</li>
            <li>5000 elementos: 12.497.500 Comparações | 6.167.342 iterações</li>
            <li>10000 elementos: 49.995.000 Comparações | 24.164.833 iterações</li>
        </ol>
        <p>Conclusão: O Bubble Sort é um algoritmo de ordem quadrática Big(n<sup>2</sup>), portanto tende a ser ineficiente com quantidades altas de elementos.</p>
    </li>
    
    
<li>Quick Sort</li>
<li>Merge Sort</li>
<li>Insertion Sort</li>
<li>Selection Sort</li>
<li>Heap Sort</li>
<li>Radix Sort</li>
</ul>

