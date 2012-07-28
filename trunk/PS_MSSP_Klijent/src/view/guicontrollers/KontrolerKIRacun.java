//package view.guicontrollers;
//
///*
// * KontrolerKIRacun.java
// *
// * 02.05.2011
// *
// * @autor  Dr Sinisa Vlajic
// *
// * Katedra za softversko inzenjerstvo
// *
// * Laboratorija za softversko inzenjerstvo
// *
// * Fakultet organizacionih nauka - Beograd
// *
// */
//
//import java.io.*;
//import view.forms.EkranskaFormaRacun;
//
//
//public class KontrolerKIRacun extends OpstiKontrolerKI
//{
//  KontrolerKIRacun(EkranskaFormaRacun efr) throws IOException {oef = efr;}
//
//
//public void KonvertujGrafickiObjekatUDomenskiObjekat()
//   {
//	  Racun rac = (Racun) odo;
//      EkranskaFormaRacun efr = (EkranskaFormaRacun) oef;
//	  rac.BrojRacuna = KonverterTipova.Konvertuj(efr.BrojRacuna,rac.BrojRacuna);
//      rac.NazivPartnera = KonverterTipova.Konvertuj(efr.NazivPartnera,rac.NazivPartnera);
//      rac.UkupnaVrednost = KonverterTipova.Konvertuj(efr.UkupnaVrednost,rac.UkupnaVrednost);
//      rac.Obradjen = KonverterTipova.Konvertuj(efr.Obradjen,rac.Obradjen);
//      rac.Storniran = KonverterTipova.Konvertuj(efr.Storniran,rac.Storniran);
//      if (efr.TabStavkaRacuna.getRowCount() > 0)
//       {  StavkaRacuna [] nizObjekata = new StavkaRacuna[efr.TabStavkaRacuna.getRowCount()];
//          for(int i = 0; i< efr.TabStavkaRacuna.getRowCount(); i++)
//		      nizObjekata[i] = new StavkaRacuna(rac);
//		  rac.sracun = nizObjekata;
//          KonverterTipova.KonvertujTabeluUNizObjekata(efr.TabStavkaRacuna,nizObjekata);
//       }
//      else
//          rac.sracun = null;
//   }
//
//
// public void KonvertujDomenskiObjekatUGrafickiObjekat()
//   {  Racun rac = (Racun) odo;
//      EkranskaFormaRacun efr = (EkranskaFormaRacun) oef;
//	  KonverterTipova.Konvertuj(rac.BrojRacuna,efr.BrojRacuna);
//      KonverterTipova.Konvertuj(rac.NazivPartnera,efr.NazivPartnera);
//      KonverterTipova.Konvertuj(rac.UkupnaVrednost,efr.UkupnaVrednost);
//      KonverterTipova.Konvertuj(rac.Obradjen,efr.Obradjen);
//      KonverterTipova.Konvertuj(rac.Storniran,efr.Storniran);
//      if (rac.sracun != null)
//      	KonverterTipova.KonvertujNizObjekataUTabelu(rac.sracun,efr.TabStavkaRacuna);
//   }
//}