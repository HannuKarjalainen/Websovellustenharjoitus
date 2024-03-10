# Harjoitustyö
Web-sovellusten perusteet harjoitustyö

**Kuvaus**

Sivusto joka sisältää javascript ja html -frontendin ja javalla toteutetun springboot -backendiä käyttävän kortinarvauspelin.
Lisäksi sivustolla on esittelyvideo ja backendissä olevat koodit lyhyesti aukaistuna.

**Asennusohje**

Lataa kaikki tiedostot koneelle ja käynnistä springboot-backend koneeltasi, tämän jälkeen sivusto löytyy localhost:8080/.

**Yleistä sivustosta**

Yleistyylit on luotu styles.css tiedostoon.

Enemmän sisältöä sisältävät sivut Korttipeli ja Koodit sisältävät muutaman oman style säännön liittyen muunmuassa sivun asetteluun kun näyttö kapenee.
Esimerkiksi suuremmalla resoluutiolla koodit sivun java-tiedoston kuva ja selite on vierekkäin ja pienemmällä allekkain.

Myös Koti ja Highscore -sivuilla on muutamia vain näitä sivuja koskevia tyyli muotoilua niiden omissa html-tiedostoissaan.

**Koti**
Aloitussivu eli index.html upotetun youtubevideon jossa harjoitustyö esitellään.

Videon alla on vielä lyhyt yhteenveto sivuston sivuista.

**Korttipeli:**

Korttipeli.html päästää sinut pelaamaan "Isompi vai pienempi"-arvauspeliä.
Pelin backend on toteutettu Maven projektina Spring Boot -backendissä.
Backendin täytyy siis olla pystyssä jotta peliä voi pelata.
Frontend ja visuaalinen ilme on toteutettu käyttäen HTML-kieltä ja Javascriptia.

Pelissä luodaan ja sekoitetaan korttipakka.

Peli alkaa painamalla "Aloita peli"-nappia
Pelin ohjees saa huomautuksena ruudulle kun painaa "Ohjeet"-nappia.

Pelissä arvataan "Pienempi" tai "Isompi"-nappia painamalla onko seuraavaksi nostettava kortti isompi vai pienempi kuin viimeisimpänä nostettu kortti.
Paina pienempi jos oletat seuraavan kortin arvon olevan "Pienempi" tai "Isompi" jos oletat seuraavan kortin arvon olevan isompi.

Kun arvaus tehdään, vetää peli uuden kortin ja jos kortti on arvauksen mukainen, silmäluvultaan sama tai ässä (eli 1 ja 14) saat pisteen.
Ässän päälle kaikki tulevat kortit antavat pisteen.
Peli jatkuu kunnes päätät aloittaa sen alusta napilla "Aloita Peli" tai kunnes olet arvannut niin monta kertaa että pakka on käyty läpi.
Oikein menneet arvaukset kohdassa pisteesi kasvavat visuaalisesti muuttamalla pistekorttia. 

Jos haluat pisteesi Highscore-listalle, tulee sinun pakan loputtua painaa vielä kerran "Pienempi" tai "Isompi"-nappia.
10 parasta tulosta tallentuu local storageen ja ne on nähtävissä Highscore-sivulta.

Korttipeli huomioi näytön koon ja siirtää pakassa jäljellä olevien korttien kuvat joko pelin viereenn tai alle riippuen näytön koosta.

**Hihghscore**

Highscore.html haetaan localstoragesta scores jonka avulla näytetään pelaajalle hänen 10 parasta tulosta ja milloin hän on ne tehnyt.
Välimuistin tyhjentäminen tyhjentää myös listan.

**Koodit**

Koodit.html sisältää backendissä olevista java tiedostoista ruutukaappauksen koodeista ja lyhyen selitteen sisällöstä.
Kun näytön leveys pienenee oletuksena vierekkäin asetetut kuvat ja tekstit ilmestyvät allekain.

Html-sivujen koodithan käyttäjä saa katsomalla ne itse selaimestaan.

**/Images/**

Images-kansiossa on jpg tiedostona korttipakan 52 korttia ja 53 pistekorttia (joista 1 on liikaa sillä maksimipisteet on 51).
Lisäksi Images kansiossa on kuvat java tiedostoista.

**Backend**

Taustalla pyörivä BigorsmallApplication.java ja maven -projektin tein tämän kurssin kanssa yhtä aikaa pyörivän Java-ohjelmointi IN00CT05-3006 - Kevät 2024 harjoitustyönä.

Backendin avaaminen tässä yhteydessä ei ole tarpeen, mutta siihen saa yleiskäsityksen lukemalla Koodit.html sivulle laaditut yhteenvedot.

Tämä harjoitustyö pyörii myös käytettävissä pilvipalvelussa siihen pisteeseen asti kun sitä voi ilmaiseksi pyörittää. Jos olen sen jo ajanut alas, 
joudutaan backend pyörittämään käyttäjän itsensä toimesta. Palvelun linkki lisätään palautustiedostoon moodleen, enkä sitä laita julkiseen repositorioon.-

Tässä viimeisenä palautettavassa työssä olen yhdistänyt Web-sovellusten perusteet, Java-ohjelmointi ja Pilvipalvelut kursseilta oppimani yhdeksi paketiksi.
