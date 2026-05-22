# JDBC Intro - Filme CRUD
Acest branch conține o soluție completă pentru stocarea și manipularea informațiilor despre filme folosind Java Database Connectivity (JDBC).

**Detalii Tehnice:**
* **Baza de date:** H2 in-memory (selectată pentru portabilitate și lipsa nevoii de configurare a unui server local pentru evaluare).
* **Dependințe:** Gestionate prin Maven (`pom.xml`).
* **Securitate SQL:** S-a utilizat `PreparedStatement` pentru toate operațiunile care includ parametri, prevenind astfel atacurile de tip SQL Injection.
* **Operațiuni:** Creare tabelă (dinamic), Insert (Create), Select (Read), Update, Delete.
* **Management Resurse:** Folosirea `try-with-resources` pentru a asigura închiderea corectă a conexiunilor și statement-urilor.

