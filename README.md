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

## Cas d'utilisation (Use Case)

1. L’utilisateur insère une somme d'argent dans la machine.
2. Le système vérifie que le montant est suffisant pour une boisson.
3. L’utilisateur sélectionne une boisson dans le catalogue.
4. Le système vérifie la disponibilité des ingrédients (eau, café, etc.).
5. Si tout est disponible, la boisson est préparée.
6. L’utilisateur reçoit sa boisson.
7. Le système rend la monnaie si nécessaire et affiche un message de confirmation.
8. Si une erreur survient à n’importe quelle étape (ex. : pas assez d’eau), un message d’erreur est affiché et la transaction est annulée.

---

## Logique métier

- Les prix des boissons sont fixés et stockés dans le `CatalogueBoissons`.
- La classe `Monnayeur` gère les pièces insérées, valide le montant, et calcule la monnaie à rendre.
- `StockManager` vérifie si chaque ingrédient requis pour une boisson est disponible.
- Si les conditions de paiement et de stock sont remplies, la machine prépare la boisson.
- Si un problème survient (ex. : stock insuffisant), le processus est annulé proprement.

---

## Gestion des erreurs

- **Paiement insuffisant** : Message d'erreur, annulation de la commande.
- **Ingrédient manquant** (eau, café, lait...) : Message "boisson indisponible".
- **Rendu de monnaie impossible** : Message d’erreur avec remboursement complet.
- **Choix invalide de boisson** : Affichage d’un message d’instruction.
- **Erreur système ou coupure de courant (simulée)** : Interruption du processus avec message d’erreur.

---

## Optimisations

- Architecture orientée objet permettant d’ajouter facilement de nouvelles boissons.
- Séparation claire des responsabilités (Stock, Paiement, Interface, Logique métier).
- Utilisation de constantes pour éviter les "magic numbers".
- Gestion centralisée des erreurs avec exceptions personnalisées (ex. : `BoissonIndisponibleException`, `StockInsuffisantException`).
- Testabilité : chaque composant peut être testé de manière indépendante (Mock du stock, paiement...).

---

## Modélisation

### Diagramme de classes (simplifié)

+------------------+
| MachineCafe |
+------------------+
| - stockManager |
| - monnayeur |
| - afficheur |
| - catalogue |
+------------------+
| +servirBoisson() |
| +demarrer() |
+------------------+

    |
    v

+------------------+ +------------------+ +------------------+
| Boisson | | StockManager | | Monnayeur |
+------------------+ +------------------+ +------------------+
| nom | | stockIngredients | | montantActuel |
| prix | | +verifier() | | +insererPiece() |
| ingredients | | +reduireStock() | | +rendreMonnaie() |
+------------------+ +------------------+ +------------------+


                        |
                        v
                 +------------------+
                 |    Afficheur     |
                 +------------------+
                 | +afficher()      |
                 | +erreur()        |
                 +------------------+


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

---

## Structure des fichiers

```bash
machine-a-cafe/
├── src/
│   ├── MachineCafe.java          # Classe principale
│   ├── Boisson.java              # Définition des boissons
│   ├── CatalogueBoissons.java    # Liste de boissons disponibles
│   ├── StockManager.java         # Gestion du stock d’ingrédients
│   ├── Monnayeur.java            # Gestion des paiements et rendu de monnaie
│   └── Afficheur.java            # Interface console ou graphique
├── tests/                        # Tests unitaires
│   ├── MachineCafeTest.java
│   ├── StockManagerTest.java
├── README.md
└── .gitignore
