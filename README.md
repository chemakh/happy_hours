# Happy Hours 
Code source du Projet Happy Hours qui est un site  qui propose des bons plans de sortie pour les consommateurs Tunisien.
##Processus de déploiment:
###1er étape : 
Téléchargement du code Source depuis Github:
```
git clone https://github.com/chemakh/happy_hours.git
```
###2éme étape:
####Création de la base de données:
Pour le Bon bonctionnement de l'application ,il faut tout d'abord Créer la base de données nécessaire pour ça.
La configuration déja en place demande un base de données de type *Mysql* et de nom *happyHours*.Mais en peut remplacer cette configuration dans les fichier configuration ce trouvant dans le dossier *happyHoursConfig\src\main\resources\shared*
####Compilation du code source Avec *Maven* et Déploiment:
Pour la compilation et le déploiment de l'application il faut exécuter la serie du commande Dos suivante:
```
mvn clean install -Dmaven.test.skip=true
start /B java -jar happyHoursConfig/target/happyHoursConfig.jar >happyHoursConfig.log
start /B java -jar -Dspring.profiles.active=dev happyhoursService/target/happyhoursService.jar > happyhoursService.log
start /B java -jar -Dspring.profiles.active=dev happyHoursAuthServer/target/happyHoursAuth.jar > happyHoursAuth.log
```
####Test 
Pour  voire les opérations déja mise en place il faut accéder à l'url de swagger Suivant : [swagger] (http://localhost:8181/swagger-ui.html#/) ou sur la page d'authentification suivante [login](http://localhost:7777/uaa/login)

```
login: lazher.chemakh@gmail.com
password: admin
```
