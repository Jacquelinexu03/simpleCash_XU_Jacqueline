# projet_Xu_Jacqueline
Java projet

# Document de conception

1. Diagramme UML simple (dans dossier 'document')

Client → Account (1:n)
Advisor → Client (1:n)
Account → Transaction (1:n)

2. User stories

Le client souhaite avoir une application qui permet de gerer les comptes clients et leur conseiller, les transactions
et aussi gerer le respect des regles tel que les decouverts.

3. Swagger

[GET]       http://localhost:8080/{entity}          -> avoir tous les instances d'entity
[GET]       http://localhost:8080/{entity}/{id}     -> avoir les infos d'une entity
[POST]      http://localhost:8080/{entity}          -> creer une entity
[PUT]    http://localhost:8080/{entity}/{id}        -> update une entity
[DELETE]    http://localhost:8080/{entity}/{id}     -> supprimer une entity

4. Bilan du projet

Difficulte:

- le temps
- le fait de jongler sur pleins de fichier en meme temps (notamment les Dto)

A faire:

- utilisation de l'Audit (leur fonction)
- utilisation SimpleCash (leur fonction)
- modifier l'acces des conseillers aux clients restreintes (max 10)
- creation des clients et association automatique a son conseiller
- terminer les class