# Sistem Gestiune Bibliotecă (Library System)
Acest branch conține implementarea unui sistem arhitectural pentru o bibliotecă.

**Concepte Arhitecturale OOP Implementate:**
* **Încapsulare:** Toate atributele claselor sunt `private` și accesate exclusiv prin getter/setter pentru a menține un `valid state`.
* **Asociere (Association):** Implementarea corectă a relației `Member` <-> `Book`. Un `Member` deține o referință (Listă) către obiectele `Book` pe care le are împrumutate, dar obiectele `Book` continuă să existe independent în `Catalogul` bibliotecii.
* **Separation of Concerns (SoC):** 
  * Clasa `Book` răspunde doar de starea ei.
  * Clasa `Member` răspunde doar de datele clientului.
  * Clasa `Library` acționează ca un orchestrator care aplică regulile de business (ex: validarea disponibilității înainte de checkout).

