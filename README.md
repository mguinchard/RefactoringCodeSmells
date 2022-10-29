# KATA - CodeSmells

### Etape 1 : installation de Sonar Lint

### Etape 2 : Renommage en respectant les règles Java.

Avant :

```java
    private int m_score1=0;
private int m_score2=0;
```

Après :

```java
    private int mScore1=0;
private int mScore2=0;
```

### Etape 3 : utilisation des projets apache commons

```xml

<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
</dependency>
```

Remplacement de tous les "" par des StringUtils.EMPTY
```java
String score = "";
```
```java
String score = StringUtils.EMPTY;
```
- Ajout d'attribut en final
```java
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
```
```java
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(final String player1Name, final String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
```


- Utilisation de equals pour comparer des String plutôt ue == (et mieux utilisation de StringUtils.equals qui est nullsafe)
```java
if (playerName == "player1")
```
```java
if (StringUtils.equals(playerName, "player1"))
```
- Ajout des accolades dans les if
```java
if (StringUtils.equals(playerName, "player1")) mScore1 += 1;
        else mScore2 += 1;
```
```java
if (StringUtils.equals(playerName, "player1")) {
    mScore1 += 1;
    } else {
    mScore2 += 1;
}
```

- Suppression des init inutils
```java
 int tempScore = 0;
```
```java
 int tempScore;
```

- Utilisation du switch case/lambda
```java
  switch (mScore1)
        {
        case 0:
        score = "Love-All";
        break;
        case 1:
        score = "Fifteen-All";
        break;
        case 2:
        score = "Thirty-All";
        break;
        default:
        score = "Deuce";
        break;
        }
```
```java
    score = switch (mScore1)
        {
        case 0  -> "Love-All";
        case 1  -> "Fifteen-All";
        case 2  -> "Thirty-All";
        default -> "Deuce";
        };
```
- Utilisation des StringBuilder pour concaténer des String
```java
    score+="Love";
```
```java
score.append("Love");
```

- Suppression de champ non utilisé
```java
private final String player1Name;
private final String player2Name;

public TennisGame1(final String player1Name, final String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        }
```
```java

- Un peu de Sonar et lanement des tess à chaque modif.
