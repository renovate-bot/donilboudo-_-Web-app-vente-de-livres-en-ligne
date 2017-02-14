# Web-app-vente-de-livres-en-ligne
Cette application aura pour but de faire la vente livres en ligne.
Nous utilisons les technologies suivants:
  1.Spring MVC
  2.Maven
  3.Hibernate
  
 Pour utiliser cette premiere version:
  1.telecharger le code source
  2.acceder au dossier du projet avec console et executer la commande maven : mvn clean install
  3.importer le projet dans votre IDE
  
 Prerequis:
    1.Installer une base de donnee MySQL et demarrer service avec les informations suivants:
      port:8889
      user:root
      password:root
      
    2.Excecuter les sql suivants pour initialiser la base de donnee:
      CREATE DATABASE bookStore;
    
      CREATE TABLE `BOOK` (
      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
      `isbn` varchar(50) DEFAULT NULL,
      `title` text,
      `author` varchar(100) DEFAULT NULL,
      `editor` varchar(100) DEFAULT NULL,
      `price` double DEFAULT NULL,
      `details` text,
      `coverImage` varchar(100) DEFAULT '',
      `releaseDate` datetime DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


    CREATE TABLE `SHOPPING_CART_ITEM` (
      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
      `bookFK` int(11) unsigned NOT NULL,
      `quantity` int(11) DEFAULT NULL,
      `totalCost` double NOT NULL,
      PRIMARY KEY (`id`),
      KEY `CART_BOOK` (`bookFK`),
      CONSTRAINT `CART_BOOK` FOREIGN KEY (`bookFK`) REFERENCES `BOOK` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
    
    
    insert into BOOK values
    (
      1,
      "9782755629132",
      "Calendar girl : février",
      "Audrey Carlan",
      "HUGO & CIE",
      12.95,
      "Mia arrive dans une nouvelle ville pour poursuivre ses activités d'escort girl afin de payer la dette que son père a contracté avant d'être violement agressé.",
      "calendar-girl",
      NULL
      );

    insert into BOOK values
    (
      2,
      "9782764624678",
      "Traces de l'histoire de Montréal",
      "David Francklin",
      "BOREAL",
      15,
      "L'histoire exceptionnelle de Montréal est abordée ici sous un angle distinct, celui des traces de son histoire, visibles dans l'espace urbain et dans la mémoire collective. Ces traces s'observent dans les vestiges et les bâtiments de diverses époques qui parsèment le paysage montréalais. Elles sont visibles dans les objets et les lieux de la vie quotidienne. Elles sont perpétuées dans le souvenir des événements du passé. Ces traces ont été produites, transmises et conservées par des générations de Montréalaises et de Montréalais. Elles sont révélées ici à travers l'oil d'artistes qui, en utilisant divers médias, en ont assuré la pérennité. L'illustration est au cour de la démarche et l'écrit ne vient que la mettre en contexte. Le lecteur est invité à découvrir l'histoire de Montréal par le regard, à s'imprégner de ces images pour reconstituer une trame qui s'étend sur plusieurs siècles. Il peut s'agir d'objets, de plans, de tableaux, de gravures, d'affiches ou de photographies. Le livre est structuré en cinq grands chapitres chronologiques. Chacun d'eux s'amorce par une très brève synthèse rappelant les principales caractéristiques de l'époque. Pour chaque période, l'allure générale de la ville est esquissée au moyen de plans, de vues ou de photographies aériennes. Le lecteur plonge ensuite dans cet espace urbain où sont mis en valeur des lieux, des immeubles ou des moments clés.",
      "traces-histoire-montreal",
      NULL
    );

    insert into BOOK values
    (
      3,
      "9782259249713",
      "L'Immeuble Christodora",
      "Tim Murphy",
      "PLON",
      32.95,
      "Un roman kaléidoscopique qui retrace la vie d'un certain New York, de l'anarchie des années sida aux hipsters de demain.  New York. Milly et Jared, couple aisé animé d'ambitions artistiques, habite l'immeuble Christodora, vieux building de Greenwich Village. Les habitants du Christodora mènent une vie de bohèmes bien loin de l'embourgeoisement qui guette peu à peu le quartier. Leur voisin, Hector, vit seul. Personnage complexe, ce junkie homosexuel portoricain n'est plus que l'ombre du militant flamboyant qu'il a été dans les années quatre-vingt.  Mateo, le fils adoptif de Milly et Jared, est choyé par ses parents qui voient en lui un artiste. Mais le jeune homme, en plein questionnement sur ses origines, se rebelle contre ses parents et la bourgeoisie blanche qu'ils représentent.  Milly, Jared, Hector et Mateo, autant de vies profondément liées d'une manière que personne n'aurait pu prévoir. Dans cette ville en constante évolution, les existences de demain sont hantées par le poids du passé.",
      "immeuble-christodora",
      NULL
    );
    
    
   3. Deployer mainteant l'application sur un serveur comme Tomcat
