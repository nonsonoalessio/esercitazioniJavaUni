# Classi

## Class `Studente`

```java
public class Studente{
    String nome;
    String matricola;
    double votoMedio;
}
```

Attributo `matricola` read-only; altri read-write.

Prevedere: 
* costruttore che inizializzi entrambi;
* metodo `toString` che stampi (hint: _usare `printf()`_):
  > nome - matricola - votoMedio (con 2 decimals)

## Class `Stack`

5 metodi: 
* `push()` (se lo stack è pieno lancia `FullStackException`); 
* `pop()` (se lo stack è vuoto lancia `EmptyStackExcpetion`); 
* `top()`  (se lo stack è vuoto lancia `EmptyStackExcpetion`); 
* `isEmpty()` / `isFull()`; 

Lo stack prevede due costruttori, uno senza parametri con dim max 50 e uno con un parametro intero che è la dimensione massima.

# Eccezioni
Creiamo una gerarchia di eccezioni, in un package `Exeptions` che ha 3 eccezioni:
* `stackException` **extends** `Exception`;
* `FullStackException` **estends** `StackException`;
* `EmptyException` **extends** `StackException`.
