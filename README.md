# Domácí úkol: Automatické testování v Javě

Vytvořte testy na admin stránku web Czechtas Shopizer za použití Selenium WebDriver, JUnit a page object patternu.

### Vytvořte tyto testy
1. Login do admina se správným uživatelem, ale špatným heslem - ověřte chybovou hlášku
2. Login do admina se špatným uživatelem  - ověřte chybovou
3. Login se správným uživatelem i heslem - ověřte že se admin otevřel

### Zpracování a odevzdání domácího úkolu

Stáhněte si projekt. V projektu už jsou nastavené veškeré závislosti a je tam připravený template

#### Varianta A: 
**použijte GIT**
1. Vytvořte si novou větev, pojmenujte ji jmeno-prijmeni
2. Pushněte vaši větev na remote
3. Vytvořte pull request

#### Varianta B: 
Pošlete mi zip


## Řešení - ukládání uživatelského jména a hesla:

Aby nebylo nutné ukládat citlivé údaje v kódu, budeme je načítat ze souboru z uživatelského počítače.

1. Ve svém domovském adresáři vytvořte soubor `automation.properties`. Pokud nevíte co je váš domovský adresář, spusťte si třídu `WhatsMyHome` a ta vám to řekne.
2. Do souboru zapište:
```
baseUrl=https://czechitas-shopizer.azurewebsites.net
username=***
password=***
```
Místo *** samozřejmě napiště uživatelské jméno a heslo.