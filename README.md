# UCE Génie Logiciel Avancé : Techniques de tests

# Nom et prénom
- Nom : BLONDEAU
- Prénom : Pierre

# Groupe
- Groupe : M1 alternant

# Lien javadoc
https://blondeaupierre.github.io/ceri-m1-techniques-de-test/testapidocs/fr/univavignon/pokedex/api/package-summary.html

# Badges
[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/WRoHsLXHhYWuabProeSYMi/NB5iUKhfeRPa4btZb3Dhgf/tree/master.svg?style=svg&circle-token=CCIPRJ_WJUUbrkmo7AyD5rRjjK2Mp_25067ae858dac1ae4d025048d7f6e523f56d9a64)](https://dl.circleci.com/status-badge/redirect/circleci/WRoHsLXHhYWuabProeSYMi/NB5iUKhfeRPa4btZb3Dhgf/tree/master)
[![codecov](https://codecov.io/gh/blondeaupierre/ceri-m1-techniques-de-test/graph/badge.svg?token=KXPSENIOA3)](https://codecov.io/gh/blondeaupierre/ceri-m1-techniques-de-test)
![Checkstyle](target/site/badges/checkstyle-result.svg)

# Rapport team rocket

- Mon test passe parce que je génére un bulbasaur à l’index 1, ce qui est correspond au bon nom dans la hashmap.

- Un pokemon peut-être défini avec n’importe quel index (pas de metadata, on gérait le range des index dans IPokemonMetadataProvider).

- Tout pokémon avec un index négatif aura des statistiques d’attaque, défense et stamina = 1000.

- IV 0 ou 1 alors c'est un double dans notre cas + compris entre 0 et 15 normalement.

- Via codecov : éléments de la fonction non testés (si index non existant et stats = 1000 si index < 0).

- Checkstyle ok.



## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.