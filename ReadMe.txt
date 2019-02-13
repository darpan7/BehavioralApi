Steps to follow:
===============

Setup tools [Optional]:
----------------------
1. Download Apache Tomcat Server 7.0:
	* Download zipped file from `http://mirrors.ocf.berkeley.edu/apache/tomcat/tomcat-7/v7.0.92/bin/apache-tomcat-7.0.92.tar.gz`
	* Extract zipped file to customized location i.e. ~/Installers/
	* Copy path of dowloaded tomcat directory. ______________ (A)
2. Eclipse IDE:
	* Download it from https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2018-09/R/eclipse-jee-2018-09-macosx-cocoa-x86_64.dmg
	* Open Eclipse.
	* Import project from git into Eclipse:
		- Go to File >> Import >> import from git >> clone repo :
			+ Copy `https://github.com/darpan7/BehavioralApi.git` in url.
			+ Apply git credentials [You have to have a permission]
	* Install Apache Tomcat Server:
		- Go to File >> New >> Other >> Server >> Select "Apache" >> Tomcat Server 7.0 >> Browse >> Link directory location mentioned in (A). >> Finish
3. AngularJS 6:
	* Install npm on Mac:
		`brew install node` [No need to add sudo]
		`npm -v` should display version number.
	* Install ng globally:
		`npm install -g @angular/cli` [-g stands for globally. Remove -g if you want to install locally]
	* `npm install`:
		Error: Unexpected token / in JSON at position ....
		Solution: Remove package-lock.json file and re-run the command.

		Error: npm install hangs on one particular module.
		Solution: Simply stop the process (ctr + c) and re-run the command.



Make it Run first:
-----------------
1. Run Spring Application:
	* External Dependencies:
		MySql:
			- Install MySQL:
				Reference link: `https://dev.mysql.com/doc/refman/5.7/en/osx-installation-pkg.html`
			- Install MySQL Workbench [Optional]:
				Reference link: `https://dev.mysql.com/doc/workbench/en/wb-installing-mac.html`
			- After successful installation, test connection.
				`mysql -uroot -hlocalhost -proot` should connect to MySql database.
			- Create `testdb` schema.
				`mysql -uroot -hlocalhost -proot`
				`CREATE SCHEMA testdb`
	* Setup in Eclipse:

	* Run Commands:
		- `cd ~/<root of spring directory application>`
		- `mvn clean`
		- `mvn spring-boot:run`
			Errors and solution while running this command:
			Error:
				 `Caused by: java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException`
			Solution:
				jaxb api is not available by default in jdk. So you need to import it. One of the way is write the following lines in pom.xml:
					<dependency>
						<groupId>javax.xml.bind</groupId>
						<artifactId>jaxb-api</artifactId>
						<version>2.2.11</version>
					</dependency>
					<dependency>
						<groupId>com.sun.xml.bind</groupId>
						<artifactId>jaxb-core</artifactId>
						<version>2.2.11</version>
					</dependency>
					<dependency>
						<groupId>com.sun.xml.bind</groupId>
						<artifactId>jaxb-impl</artifactId>
						<version>2.2.11</version>
					</dependency>
					<dependency>
						<groupId>javax.activation</groupId>
						<artifactId>activation</artifactId>
						<version>1.1.1</version>
					</dependency>
	* It will keep running and waiting for request to process. Now lets setup client.

2. Run AngularJs6 Application:
	* `cd ~/<root of angular client application>
	* `ng serve` to start client.
