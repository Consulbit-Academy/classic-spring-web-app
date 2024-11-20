# **Semplice Applicazione Web con Spring (Senza Spring Boot)**

Questo progetto dimostra come creare una semplice applicazione web con supporto alla persistenza **senza utilizzare Spring Boot**.   
L'obiettivo è evidenziare lo sforzo manuale richiesto per configurare un'applicazione del genere, fornendo una base di confronto 
con la stessa versione creata utilizzando Spring Boot.

La version basata su Spring Boot puo' essere scaricata da [GitHub](https://github.com/Consulbit-Academy/simple-spring-boot-web-app).

## **Caratteristiche**
- **Spring Web MVC**: Gestisce il livello web con controller e viste.
- **Persistenza con JPA e Hibernate**: Supporto a database relazionali.
- **Server Tomcat Embedded**: Configurato tramite il plugin Maven Cargo.
- **Template Thymeleaf**: Per il rendering dinamico delle viste.
- **Database H2**: Database in memoria per semplicità (o MySQL per produzione), fornito supporto per MySQL attraverso Docker Compose.

---

## **Tecnologie Utilizzate**
- **Spring Framework**: `5.3.x` (in particolare Spring Web MVC).
- **Tomcat**: Tomcat embedded `9.x`.
- **Hibernate**: `5.6.x`.
- **Thymeleaf**: `3.0.x` (se utilizzato per la parte di presentazione).
- **Database**: H2 (o MySQL attraverso Docker Compose).
- **Java**: `17`.
- **Maven**: Gestione delle dipendenze e build.

---

## **Istruzioni per l'Installazione**

### **Prerequisiti**
1. **Java 17**: Assicurati che Java 17 (o versione superiore) sia installato e configurato come JDK predefinito.
2. **Maven**: Installa Maven 3.8+ e verifica che sia disponibile nel tuo PATH.
3. **Database (Opzionale)**:
    - Se utilizzi MySQL, assicurati che il server database sia attivo e che esista un database chiamato `test` con l'utente `root` che abbia come password `admin`.

---

### **Passaggi per Eseguire l'Applicazione**

1. **Clona il Repository**:
   ```bash
   git clone https://github.com/Consulbit-Academy/classic-spring-web-app.git
   cd classic-spring-web-app
   ```

2. Configurazione del database
   1. **Database embedded H2**
      - Commenta le linee che fanno riferimento alla configurazione di MySQL e rimuovi il commento per le linee che fanno riferimento alla configurazione per H2
   2. **Database MySQL**
      - All'interno del package `resources` e' presente il file `docker-compose.yml` che puo' essere utilizzato per avviare un container MySQL gia' correttamente configurato.
        Assicurati di avere **Docker** correttamente installato sulla tua macchina e all'interno della cartella `resources`, esegui dalla linea di comando:
        `docker-compose up`.  
      Il precedente comando, esegue le istruzioni presenti nel file `docker-compose.yml` che scarica un immagine MySQL, crea ed avvia un container, crea un database chiamato `test`, setta la password per l'utente `root` ed espone la porta `3306`.

2. **Build del Progetto**:
   ```bash
   mvn clean package
   ```

3. **Esegui con Cargo**:
   Distribuisci e avvia il server Tomcat embedded:
   ```bash
   mvn cargo:run
   ```

4. **Accedi all'Applicazione**:
   Apri il browser e naviga a:
   ```
   http://localhost:8080/
   ```

---

## **Struttura del Progetto**
Il progetto segue una tipica struttura Maven per applicazioni Spring:
```
src/
  main/
    java/                         # File sorgente Java
      net.consulbit.academy.config/         # Configurazioni Spring (es. WebConfig, PersistenceConfig)
      net.consulbit.academy.controller/     # Controller per la gestione delle richieste
      net.consulbit.academy.domain/          # Entità JPA
      net.consulbit.academy.repositories/    # Logica di persistenza
    resources/                    # File di configurazione (es. application.properties)
    webapp/
      WEB-INF/                    # File relativi al web
        views/                    # Template Thymeleaf o JSP
```

---

## **Obiettivi del Confronto**
Questa applicazione evidenzia i passaggi manuali necessari per configurare:
- Gestione delle dipendenze per l'ecosistema Spring.
- Configurazione di un server Tomcat incorporato tramite Cargo.
- Configurazione della persistenza con JPA, Hibernate e un database.
- Creazione e mappatura di controller, persistenza e viste.

Nei post successivi del blog, verrà costruita un'applicazione simile utilizzando **Spring Boot** per dimostrare come Spring Boot semplifica questo processo automatizzando:
- Gestione delle dipendenze con i "starter".
- Configurazione automatica del server incorporato (Tomcat per impostazione predefinita).
- Configurazioni di persistenza e database pronte all'uso.

---

## **Principali Sfide**
1. **Configurazione del Server**: Configurazione manuale di un server Tomcat incorporato tramite Cargo.
2. **Gestione delle Dipendenze**: Assicurare la compatibilità tra Spring Framework, Hibernate e altre librerie.
3. **Configurazione della Persistenza**: Definizione delle connessioni al database, configurazioni di Hibernate e mapping delle entità.
4. **Si devono cercare tutte le librerie compatibili con la data versione di Spring utilizzata e configurare le dipendenze.**
5. **Spesso, la configurazione di `EntityManagerFactory`, `TransactionManager` e la classe `DataSource` e'molto simile se non uguale.**
6. **Stesso ragionamento come al punto 5. vale per classi come `ViewResolver` e `MessageSource`.**

---

### **Configurazione**
- La connessione al database può essere configurata in `src/main/resources/application.properties`:
  ```properties
  # Esempio per H2
  jdbc.driverClassName=org.h2.Driver
  jdbc.url=jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS test
  jdbc.username=sa
  jdbc.password=

  # Esempio per MySQL
  jdbc.driverClassName=com.mysql.cj.jdbc.Driver
  jdbc.url=jdbc:mysql://localhost:3306/test
  jdbc.username=root
  jdbc.password=admin
  ```

---