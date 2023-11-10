## Configuration

Installez la base de données avec Docker : 
```console
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=amire -p 3306:3306 -d mysql
```

Essayez de vous connecter à la base de données depuis IntelliJ Idea (ne pas oublier de spécifier la version MySql **8.1**)

![Configuration intellij](https://media.discordapp.net/attachments/1156837072552861738/1172505777131495424/image.png?ex=65609019&is=654e1b19&hm=bc3a06d8a9a12c69fdf3375c42adec546d63c7533fd0ee3d191ac00bfb0b2898&=&width=775&height=670)

Exécutez les scripts présents dans [src/main/java/utils/database/scripts](src/main/java/utils/database/scripts) dans l'ordre suivant :
- Enseignant
- Ecole
- Account
- Annonces
- Candidatures

Utilisez la configuration widlfly sur IntelliJ, avec le WAR du projet en déploiement (un preset est déjà installé).
