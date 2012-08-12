package model;

/*
 * OpstiDomenskiObjekat.java
 *
 * 02.05.2011
 *
 * @autor  Dr Sinisa Vlajic
 *
 * Katedra za softversko inzenjerstvo
 *
 * Laboratorija za softversko inzenjerstvo
 *
 * Fakultet organizacionih nauka - Beograd
 *
 */


//import model.*;
import java.sql.*;

// Operacije navedenog interfejsa je potrebno da implementira svaka od domenskih klasa,
// koja zeli da joj bude omogucena komunikacija sa Database broker klasom.
public interface OpstiDomenskiObjekat
{

// POZIVA SE IZ BROKERA BAZE PODATAKA - pocetak

// ***koristi se***//
String vratiVrednostiAtributa();

// ***koristi se***//
String postaviVrednostiAtributa();

// ***koristi se***//
String vratiImeKlase();
/*************JELENA************/
// ***koristi se***//
String vratiNazivTabele();

void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo);

int vratiID();

void postaviAtributPretrazivanja(String atribut);

//Object vratiVrednostAtributeaPretrazivanja();

/************* end JELENA************/

// ***koristi se***//
String vratiAtributPretrazivanja();



// ***koristi se***//
String vratiUslovZaNadjiSlog();

// ***koristi se***//
String vratiUslovZaNadjiSlogove();


// ***koristi se***//
boolean Napuni(ResultSet RSslog);

// ***koristi se***//
int povecajBroj(ResultSet rs);

// ***koristi se***//
OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta);

// ***koristi se***//
void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta);

// ***koristi se***//
void kreirajVezaniObjekat(int brojStavkiVezanogObjekta,int brojVezanogObjekta);

// ***koristi se***//
int vratiBrojVezanihObjekata();

// ***koristi se***//
public void postaviPocetniBroj();

// ***koristi se***//
public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta,int brojSloga);

// ***koristi se***//
public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta);
// POZIVA SE IZ BROKERA BAZE PODATAKA - kraj


// POZIVA SE IZ KLASA ZA SO - pocetak

// ***koristi se***//
public boolean vrednosnaOgranicenja();

// ***koristi se***//
public void Obradi();

// ***koristi se***//
public void Storniraj();

// ***koristi se***//
public String vratiNazivNovogObjekta();

// ***koristi se***//
public String vratiNazivObjekta(); // koga, sta
// POZIVA SE IZ KLASA ZA SO - kraj


}
