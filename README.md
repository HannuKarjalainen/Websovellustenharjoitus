# REST-harjoitus
Javakurssin harjoitustyö

**Pelilogiikka:**
Pelissä luodaan ja sekoitetaan korttipakka.
Kun pelin aloittaa käskyllä /start 
peli luo uuden täyden pakan, sekoittaa sen uudestaan (metodi generateDeck()) ja vetää ensimmäisen kortin (getter /draw).
Pelin ohjeet saa näkyviin getterillä /guide
Ohjeistuksessa oli että ohjeet pitäisi laatia juureen /
mutta loin ohjeiden vastaisesti vaihtoehtoista pelaamista varten graafisen käyttöliittymän jonka ohjasin tulemaan juuresta (toivottavasti tämä ei vähennä pisteitä)

Pelissä arvataan post /guess onko seuraavaksi nostettava kortti isompi vai pienempi kuin viimeisimpänä nostettu kortti
post /guess toimii että bodyssa viedään raw tekstinä pienempi jos oletat seuraavan kortin arvon olevan pienempi tai isompi jos oletat seuraavan kortin arvon olevan isompi.
Vääristä tekstisisällöistä palauteviesti ohjaa laittamaan bodyyn oikean tekstin.
Kun arvaus tehdään, kutsuu post /guess itse getter /draw ja vetää uuden kortin ja jos kortti on arvauksen mukainen, silmäluvultaan sama tai ässä (eli 1 ja 14) saat pisteen.
Ässän päälle kaikki tulevat kortit antavat pisteen.
Peli jatkuu kunnes päätät aloittaa sen alusta getterillä /start tai kunnes olet arvannut niin monta kertaa että pakka on käyty läpi.
Palautusviestit kertovat minkä kortin nostit ja saitko pisteen ja mikä on pistelukusi.

**Ohjeet**
get /start aloittaa uuden pelin
post /guess body raw text pienempi tai isompi antaaksesi arvauksen
oikea arvaus, sama luku tai ässä sekä ässän päälle otettu kortti antavat pisteen
peli loppuu kun pakka on loppunut.
Ohjeet on katsottavissa get /guide

**Vaihtoehtona Postmanille graafinen UI**
Pelissä on laadittu myös graafinen käyttöliittymä, johon pääsee springboot maven serverin ollessa päällä osoitteesta 
http://localhost:8080/


