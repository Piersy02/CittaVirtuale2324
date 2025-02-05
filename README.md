# 🌍 Citta Virtuale

**Citta Virtuale** è un progetto sviluppato per l'esame di **Ingegneria del Software** presso **UNICAM** nell'anno accademico 2023/2024.  
Il team di sviluppo è composto da:
- **Saverio Maria Piersigilli**
- **Mattia Penna**
- **Giulia Lupi**

L'obiettivo del software è **digitalizzare e gestire informazioni territoriali**, consentendo la registrazione e consultazione di eventi, punti di interesse, itinerari e altre informazioni culturali.

---

## Struttura del Progetto

Citta Virtuale è basato su un'architettura **API REST**, che permette di gestire i dati attraverso chiamate HTTP.  
L'interfaccia grafica per l'interazione con le API è fornita da **Swagger**, che facilita l'esplorazione delle chiamate in modo intuitivo e veloce.

Le API consentono di:
-  Creare e gestire eventi, itinerari e punti di interesse.
-  Controllare e modificare i contenuti associati a ciascun elemento.

Nel progetto è incluso un file **Visual Paradigm**, che documenta le fasi di progettazione attraverso **diagrammi UML**, mostrando casi d'uso e flussi implementati nel codice.

---

## 📦 Installazione e Avvio del Progetto

### **Prerequisiti**
- **Java 17+** installato
- **Maven** installato sul dispositivo
- **Git** (opzionale, per clonare il repository)

### **Istruzioni**
- Puoi scaricare il progetto manualmente oppure clonarlo tramite Git
- Esegui il seguente comando per compilare ed eseguire i test:
mvn clean install
- Dopo la compilazione, esegui il file JAR generato:
java -jar .\target\ProgettoIDS-0.0.1-SNAPSHOT.jar
- Una volta avviato il server, puoi accedere alla documentazione delle API tramite Swagger visitando:
http://localhost:8080/swagger-ui/index.html
- Per visualizzare il DB
http://localhost:8080/h2-console
