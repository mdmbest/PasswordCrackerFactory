# PasswordCrackerFactory

## Description du projet

PasswordCrackerFactory est un outil modulaire de cassage de mots de passe permettant de choisir dynamiquement la méthode d’attaque (Brute Force ou Dictionnaire) et le type de cible (locale ou en ligne). Le projet met en œuvre le pattern de conception Fabrique (Factory Method & Abstract Factory) pour garantir l’évolutivité et la flexibilité du système. Il permet de simuler des attaques sur des cibles locales (console Java) ou en ligne (formulaire PHP).

---

## 1. Architecture logicielle (Diagramme de classes UML)

```mermaid
classDiagram
    interface AttackStrategy {
        +execute(login, target)
    }
    class BruteForceAttack
    class DictionaryAttack
    AttackStrategy <|.. BruteForceAttack
    AttackStrategy <|.. DictionaryAttack

    interface Target {
        +attemptLogin(login, password)
    }
    class LocalTarget
    class WebTarget
    Target <|.. LocalTarget
    Target <|.. WebTarget

    class AttackFactory {
        +createAttackStrategy()
        +createTarget()
    }
    class BruteForceLocalFactory
    class BruteForceWebFactory
    class DictionaryLocalFactory
    class DictionaryWebFactory

    AttackFactory <|-- BruteForceLocalFactory
    AttackFactory <|-- BruteForceWebFactory
    AttackFactory <|-- DictionaryLocalFactory
    AttackFactory <|-- DictionaryWebFactory

    BruteForceLocalFactory ..> BruteForceAttack
    BruteForceLocalFactory ..> LocalTarget
    BruteForceWebFactory ..> BruteForceAttack
    BruteForceWebFactory ..> WebTarget
    DictionaryLocalFactory ..> DictionaryAttack
    DictionaryLocalFactory ..> LocalTarget
    DictionaryWebFactory ..> DictionaryAttack
    DictionaryWebFactory ..> WebTarget

    class CrackerApp
    CrackerApp ..> AttackFactory
```

---

## 2. Choix des patrons de conception utilisés et justification

- **Pattern Fabrique (Factory Method & Abstract Factory)**  
  Utilisé pour instancier dynamiquement la combinaison souhaitée d’attaque (Brute Force ou Dictionnaire) et de cible (Locale ou Web).  
  Cela permet d’ajouter facilement de nouvelles stratégies d’attaque ou de nouveaux types de cibles sans modifier le code existant.  
  Chaque fabrique concrète (ex : `BruteForceLocalFactory`) crée une combinaison spécifique de stratégie d’attaque et de cible.

- **Strategy**  
  Les attaques (`BruteForceAttack`, `DictionaryAttack`) implémentent l’interface `AttackStrategy`, ce qui permet d’appliquer différentes stratégies d’attaque de façon interchangeable.

- **Interface Target**  
  Permet d’abstraire la cible d’authentification (locale ou web) et de rendre le système extensible à d’autres types de cibles.

---

## 3. Explication des variantes implémentées

- **Attaque par Brute Force**  
  Génère toutes les combinaisons possibles d’un alphabet donné (a-z, 0-9) jusqu’à une longueur maximale configurable.  
  Teste chaque combinaison sur la cible via la méthode `attemptLogin`.

- **Attaque par Dictionnaire**  
  Lit un fichier texte (`dic.txt`) contenant des mots de passe potentiels et les teste un à un sur la cible.

- **Cible Locale**  
  Authentification simulée en Java avec login/mot de passe codés en dur dans la classe `LocalTarget`.

- **Cible Web**  
  Authentification via un formulaire PHP (`web/login.php`), attaquée par envoi de requêtes HTTP POST depuis la classe `WebTarget`.

- **Combinaisons possibles (4 variantes)**  
  - Brute Force + Local  
  - Brute Force + Web  
  - Dictionnaire + Local  
  - Dictionnaire + Web

---

## 4. Pistes d’amélioration

- Permettre la configuration de l’alphabet et de la longueur maximale du mot de passe via la ligne de commande.
- Ajouter la gestion des délais et des erreurs réseau pour l’attaque Web.
- Implémenter d’autres stratégies d’attaque (ex : attaque par règles, rainbow tables…).
- Ajouter une interface graphique pour faciliter l’utilisation.
- Sécuriser la communication avec la cible Web (HTTPS, gestion des cookies…).
- Ajouter des logs détaillés et des statistiques sur les attaques.
- Permettre de charger dynamiquement d’autres fichiers dictionnaires.

---

## 5. Exécution

Exemple d’utilisation :
```sh
java CrackerApp --type dictionary --target local --login admin
```
ou
```sh
java CrackerApp --type bruteforce --target web --login admin
```

---

## 6. Organisation du projet

- `src/main/attacks/` : Stratégies d’attaque (`BruteForceAttack.java`, `DictionaryAttack.java`)
- `src/main/targets/` : Types de cibles (`LocalTarget.java`, `WebTarget.java`)
- `src/main/factories/` : Fabriques concrètes pour chaque combinaison
- `src/main/interfaces/` : Interfaces `AttackStrategy` et `Target`
- `src/main/CrackerApp.java` : Point d’entrée principal
- `dic.txt` : Fichier dictionnaire pour l’attaque par dictionnaire
- `web/login.php` : Formulaire PHP pour la cible en ligne

---

## 7. Auteurs
Réalisé par:
Serigne Mame Sarr
Mame Diarra Mbacké
Salamata Diedhiou
Ahmadoul Khadim Touré


