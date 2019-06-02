drop database if exists fnac ; 
create database fnac;
	use fnac;

	create table article (
		idarticle int(5)not null auto_increment,
		designation varchar(50),
		prix float(6.2),
		qte int(5),
		categorie varchar(50),
		primary key(idarticle)
		); 
	insert into article values (null, "le roi lion", 3.50,45,"Dessin animés"),
		(null,"Seul sur Mars", 10.50,5,"Film"),
		(null, "deuxieme guerre mondiale", 12.50,50, "Livre"); 

		create table user (
			iduser int(5)not null auto_increment,
			email varchar(100)not null,
			mdp = varchar(225)not null,
			nom varchar (50),
			prenom varchar(50),
			droits enum("admin","user","autre"),
			primary key(iduser));
		insert into user values (null, "a@gmail.com", "123", "admin", "admin", "admin");