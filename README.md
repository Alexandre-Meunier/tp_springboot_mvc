# TP sur SpringBoot - Dev Avancée R6.05 - Alexandre Meunier


## Exercice 1 : Premier projet en utilisant le framework Spring Boot

### Question 2: Commençons avec les bases de Spring Web MVC

Rendez-vous sur http://localhost:8080/ pour vérifier que le serveur a démarré mais qu'une page d'erreur s'affiche (en effet rien n'indique la page racine / à utiliser).

    En effet, le serveur a bien démarré, mais une erreur s'est produite. La page retourne l'erreur 404

Est-ce que l'une des pages suivantes est visible :
- http://localhost:8080/template1.html
- http://localhost:8080/plain.html


      La page temple1.html renvoie une erreur 404.
      Cependant, la page plain.html apparait correctement avec le contenue. Cela veut dire que les fichiers html dans le répertoire static sont comme des vues qui peuvent être appelé à tout moment

### Question 3 : Mécanisme des templates

A quoi correspond la chaîne renvoyé par la méthode getTemplate1() ?

    La chaine renvoyé par cette fonction correspond au template à afficher. 
    Donc cela va chercher le template1.html dans le répertoire templates.

Est-il absolument nécessaire que la méthode s'appelle getTemplate1() ?

    Non, la méthode n'a pas d'impact car c'est l'annotation RequestMapping qui associe une map qui exécute la fonction getTemplate1()

Quel rôle joue la page template1.html ?

    Son role est d'afficher du html quand elle est appelé par le controller********


## Exercice 2 : Listez et ajouter des employées

### Question 3: Intéraction dans la vue

Question : A quoi correpond la valeur retournée ?

    La chaine retourné retourne la vue à afficher, cherché dans les templates.


Question : Quelle est cette modification? Pourquoi ?
    
    IEmployeeRepository permet de créer un répertoire permettant la gestion des employees avec la BDD

Question : Que constatez-vous ?
    
    Dans application.properties, 'spring.jpa.hibernate.ddl-auto' peut être à :
        - none, donc pas de sauvegarde dans la BDD; 
        - create-drop, donc cela créé la BDD au démarrage de l'application et la supprime à l'arrêt;
        - update, ce qui permet de persister les données même après l'arrêt de l'application 

# Spring Boot, MVC,JPA (partie 2)
## Exercice 1 : Remplissage automatique de la base de données (à des fins de tests)

Question : A quoi correspondent ces propriétés ?

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

    Ces lignes permettent à hibernate d'afficher les requêtes SQL et de les formater en SQL pour rendre lisible

Question : Interpréter les affichages sur la console

    Dans la console, on peut voir les actions d'hibernate sur la BDD. Ainsi, il supprime la table employee si elle existe et la recréé


## Exercice 2 : Remplissage du référentiel des employées


A quoi correspond l'annotation @Component ?

    Cette annotation permet de détecter un bean automatiquement pour injecter les dépendances


A quoi servent les instructions :

```java
@Autowired
private IEmployeeRepository employeeRepository;
```

    Ces instructions servent à injecter l'interface pour les constructeurs, les accesseurs, etc.


## Exercice 3 : Refactorisation du code (partie 1)

Question : Quelle est l'URL qui permet d'accéder à la page home de l'application ?

    L'url est http://localhost:8080/employee/home ou http://localhost:8080/employee (Dans mon cas)


## Exercice 4 : Affichage des fiches détaillées des employées


A quoi sert l'annotation @RequestMapping(value = "/{id}") (indice : documentez-vous sur JAX-RS) ?

    Cette annotation permet de regarder dans le lien si il y a un id.


A quoi sert l'annotation @PathVariable(name="id") ?

    Cette annotation permet de préciser à la méthod que le paramètre id provient de la valeur id défini par le requestMapping


Donnez un exemple de requête HTTP qui activerait cette méthode, en expliquant les valeurs d'initialisation des paramètres.

    Avec ma requêt "http://localhost:8080/employee/2", la méthode aura comme id 2 et un model

Explication de :
    
    <a th:href="@{/employee/{id}(id=${employee.id})}" th:text="${employee.id}"></a>

    Dans ce code, le href renvoie le lien d'un employee en fonction de son id, donc l'attribut id va avoir comme valeur employee.id


