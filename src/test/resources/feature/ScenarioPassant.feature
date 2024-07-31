@SceanrioComplet
Feature: Tester le site SwagLabs
  En tant que utilisateur je veux tester le site swag Labs

  Background: Je souhaite tester la connexion et l ajout du produit au panier
    Given Je me rends sur le site SwagLabs
    When Je saisie le username
    And Je saisie le password
    And Je clique sur le bouton Login
    Then La page des produit s affichent
    When Je clique sur le bouton Add to cart du produit BackPack
    And Je clique sur le bouton Add to cart du produit T-Shirt
    Then Les produit s ajoutent dans le panier

  @SuppressionDuPanier
  Scenario: Je souhaite tester la suppression du produit du panier
    When Je clique sur l icone panier
    And Je clique sur le bouton remove
    Then Le produit sera supprimé du panier

  @Checkout
  Scenario: Je souhaite tester la checkout des données personnels
    When Je clique sur l icone panier
    And Je clique sur le bouton checkout
    When Je rempli le username
    And Je saisie le lastname
    And Je saisie le code postal
    And je clique sur le bouton continue
    Then une page overview s affiche
    When je clique sur le bouton finish
    Then une page Checkout:Complete s affiche

  @Logout
  Scenario: Je souhaite tester la deconnexion du site SwagLabs
    When Je clique sur le menu burger
    And Je clique surle bouton Logout
    Then Je me redirige vers la page d authentification "Swag Labs"