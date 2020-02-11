## Final Spring essential training exercise solution

Exercice (en équipe): Créer une application permettant de gérer les enployés d'une entreprise.
Voici les entités fonctionnelles utilisées:
* Salaire
  - int: montant
  - String: seuil d'imposition
* Employe:
  - String: nom
  - String: prénom
  - liste de Salaires: salaires
  - Agence: agence
* Agence:
  - String: nom
  - Employe: directeur

Les méthodes demandées sont:
* Lecture d'une agence et de plusieurs agences (avec tous les employés y travaillant)
* CRUD employé
* Mutation d'un employé:
  - L'employé change d'agence
  - L'employe se fait payer un nouveau salaire dont le montant est stocké en configuration

Chaque endpoint de MODIFICATION sera protégé par un mécanisme de vérification de l'identité de l'utilsiateur (header "username" de la requête)
Vous pourrez pré-charger la base avec des données.
N'hésitez-pas à utiliser tout ce que vous avez appris lors de la formation (sauf JHipster)
Si vous avez fini avant la fin, vous pouvez implémenter d'autres fonctionnalités/entités si vous le souhaitez. Soyez foufous.
