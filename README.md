# Projet : Programmation d’une Machine à Café

Ce projet consiste à simuler le comportement d’une machine à café intelligente à travers un programme orienté objet, en appliquant les bonnes pratiques de développement logiciel : respect des conventions de nommage, séparation des responsabilités, extensibilité du code, et principes SOLID.

---

## Objectifs

- Comprendre et appliquer la programmation orientée objet (POO).
- Mettre en œuvre les principes de conception propres à une architecture claire et maintenable.
- Gérer des cas d’utilisation courants (paiement, stock, erreurs utilisateurs).
- Développer un système modulaire, évolutif et testable.

---

## Fonctionnalités principales

1. **Sélection de boisson** : L’utilisateur peut choisir parmi une liste de boissons prédéfinies (café, thé, chocolat...).
2. **Gestion du stock** : La machine vérifie la disponibilité des ingrédients avant de préparer la boisson.
3. **Paiement** : L’utilisateur insère des pièces. Si la somme est insuffisante, la transaction est refusée.
4. **Préparation** : Une fois la boisson payée, elle est préparée et servie.
5. **Rendu de monnaie** : Si un excédent est détecté, la machine rend la monnaie.
6. **Affichage** : Messages clairs pour guider l’utilisateur (succès, erreurs, instructions).
7. **Rechargement du stock** : Interface d’administration pour recharger les ingrédients.


---

## Architecture orientée objet

Le code est découpé en classes respectant les responsabilités unitaires.

### Schéma de classes

- `MachineCafe` : Contrôleur principal de la machine.
- `Boisson` : Représente une boisson avec ses propriétés (nom, prix, ingrédients requis).
- `CatalogueBoissons` : Contient la liste des boissons disponibles.
- `StockManager` : Gère les niveaux d’ingrédients (eau, lait, café, chocolat...).
- `Monnayeur` : Gère les paiements, les pièces insérées, et le rendu de monnaie.
- `Afficheur` : Affiche des messages à l’utilisateur (console ou interface graphique).


---

## Conventions et normes de codage

### Nommage cohérent et lisible

- **Classes** : `PascalCase` — ex. : `MachineCafe`, `Boisson`, `StockManager`
- **Méthodes** : `camelCase()` — ex. : `servirBoisson()`, `verifierStock()`
- **Variables** : `camelCase` — ex. : `quantiteEau`, `prixTotal`
- **Constantes** : `UPPER_SNAKE_CASE` — ex. : `PRIX_CAFE`, `MAX_CAPACITE_EAU`

### Bonnes pratiques respectées

- **Principe SRP (Single Responsibility Principle)** : chaque classe a une responsabilité unique.
- **Code modulaire** : séparation claire entre les couches métier, affichage et logique.
- **Évitement des valeurs magiques** : utilisation de constantes déclarées globalement.
- **Commentaires clairs** : chaque méthode/documentation de classe est décrite brièvement.
- **Respect des conventions de style** selon le langage choisi (Java, Python, etc.).
- **Gestion d'erreurs robuste** : erreurs de paiement, boisson indisponible, stock vide.
