package data;


/*
 * BrokerBazePodataka.java
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


import java.io.*;
import java.sql.*;
import model.OpstiDomenskiObjekat;
import view.KonverterTipova;

public class BrokerBazePodataka
{
   static Connection con;
   static Statement st;
   static String porukaMetode;

   // ***koristi se***//
   public boolean otvoriBazu(String imeBaze)
  	   {  String Urlbaze;

  	  	  try {
  	  	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          Urlbaze = "jdbc:odbc:" + imeBaze;
          con = DriverManager.getConnection(Urlbaze);
          con.setAutoCommit(false); // Ako se ovo ne uradi nece moci da se radi roolback.
  	          } catch(ClassNotFoundException e)
  	                { porukaMetode = "Drajver nije ucitan:" + e; return false;}
  	            catch(SQLException esql)
  	                { porukaMetode = "Greska kod konekcije:" + esql; return false;}
  	  	        catch(SecurityException ese)
   	  	            { porukaMetode = "Greska zastite:" + ese; return false;}

  	  	  porukaMetode = "Uspostavljena je konekcija sa bazom podataka."; return true;
  	   }

	 // ***koristi se***//
	public boolean commitTransakcije()
	    {  try { con.commit();
	   		   } catch(SQLException esql)
			       { porukaMetode = porukaMetode + "\nNije uspesno uradjen commit transakcije " + esql;
				     return false;
			       }
		   porukaMetode = porukaMetode + "\nUspesno uradjen commit transakcije ";
		   return true;
	    }

	// ***koristi se***//
	public boolean rollbackTransakcije()
	    {  try{ con.rollback();
			  } catch(SQLException esql)
			      { porukaMetode = porukaMetode + "\nNije uspesno uradjen rollback transakcije" + esql;
				    return false;
			      }
		   porukaMetode = porukaMetode + "\nUspesno uradjen rollback transakcije";
		   return true;
	   }

      // ***ne koristi se***//
	public boolean pamtiSlog(OpstiDomenskiObjekat odo)
	   {   String upit;
  		   try{ st = con.createStatement();
			    upit = "INSERT INTO " + odo.vratiImeKlase()  +
			           " VALUES (" + odo.vratiVrednostiAtributa() + ")";
			    st.executeUpdate(upit);
			    st.close();
			  } catch(SQLException esql)
		          { porukaMetode = porukaMetode + "\nNije uspesno zapamcen slog u bazi. " + esql;
			 	    return false;
				  }
		   porukaMetode = porukaMetode + "\nUspesno zapamcen slog u bazi. ";
		   return true;
	   }

   // ***koristi se***//
   public boolean brisiSlog(OpstiDomenskiObjekat odo)
       {  String upit;
          try {  st = con.createStatement();
                 upit ="DELETE *  FROM " + odo.vratiImeKlase() + " WHERE " + odo.vratiUslovZaNadjiSlog();
                 st.executeUpdate(upit);
                 st.close();
              } catch(SQLException esql)
                  { porukaMetode = porukaMetode + "\nNije uspesno obrisan slog u bazi: " + esql;
   	    	        return false;
   	     		  }
   	      porukaMetode = porukaMetode + "\nUspesno obrisan slog u bazi.";
          return true;
       }


   // ***ne koristi se***//
   public boolean promeniSlog(OpstiDomenskiObjekat odo)
	   {  String upit;
		  try {	 st = con.createStatement();
		         upit = "UPDATE " + odo.vratiImeKlase() +
	 		            " SET " + odo.postaviVrednostiAtributa() +
			            " WHERE " + odo.vratiUslovZaNadjiSlog();
		         System.out.println("PROMENI SLOG" + upit);
		         st.executeUpdate(upit);
		         st.close();
			   } catch(SQLException esql)
			       { porukaMetode = porukaMetode + "\nNije uspesno promenjen slog u bazi podataka: " + esql;
					 return false;
				   }
		  porukaMetode = porukaMetode + "\nUspesno promenjen slog u bazi podataka: ";
		  return true;
	    }

   // ***ne koristi se***//
   public boolean daLiPostojiSlog(OpstiDomenskiObjekat odo)
	   {  String upit;
		  ResultSet RSslogovi;

		  try { st = con.createStatement();
		        upit = "SELECT *" +
			           " FROM " + odo.vratiImeKlase() +
			           " WHERE " + odo.vratiUslovZaNadjiSlog();
		        RSslogovi = st.executeQuery(upit);
		        boolean signal = RSslogovi.next();
		        RSslogovi.close();
		        st.close();
 		        if (signal == false)
		  	      { porukaMetode = porukaMetode + "\nSlog ne postoji u bazi podataka.";
			        return false; // Slog ne postoji u bazi.
			      }
			   }catch(SQLException esql)
			      { porukaMetode = porukaMetode + "\nNije uspesno pretrazena baza: " + esql;
					return false;
				  }
		   porukaMetode = porukaMetode + "\nSlog postoji u bazi.";
		   return true;
	     }


   // ***koristi se***//
   public boolean kreirajSlog(OpstiDomenskiObjekat odo)
	   {  String upit;
	      ResultSet rs;

	      upit = "SELECT Max(" + odo.vratiAtributPretrazivanja()+ ") AS Max" +
		         " FROM " + odo.vratiImeKlase();
	      try { st = con.createStatement();
	            rs = st.executeQuery(upit);


 	            if (rs.next() == false)
				    odo.postaviPocetniBroj();
				else
		           odo.povecajBroj(rs);

 	            upit = "INSERT INTO " + odo.vratiImeKlase()  +
		               " VALUES (" + odo.vratiVrednostiAtributa() + ")";
 		        st.executeUpdate(upit);
		        st.close();
		      } catch(SQLException esql)
				  { porukaMetode = porukaMetode + "\nNe moze da se kreira novi slog: " + esql;
				    return false;
				  }
		   porukaMetode = porukaMetode + "\nKreiran je novi slog: ";
	       return true;
	    }

    // ***koristi se***//
    public boolean nadjiSlogiVratiGa(OpstiDomenskiObjekat odo)
        {  ResultSet RS;
           String nazivVezanogObjekta;
           int brojStavki;
		   String upit;
		   Statement st;
           try {

			     st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	             upit = "SELECT *" +
					    " FROM " + odo.vratiImeKlase() +
                        " WHERE " + odo.vratiUslovZaNadjiSlog();
	             RS = st.executeQuery(upit);
	             System.out.println("Upit-nadji: " + upit);
	             boolean signal = RS.next();
				 if (signal == false)
					  {
						porukaMetode = porukaMetode + "\nNe postoji slog u bazi podataka.";
					    return false;
					  }
				 porukaMetode = porukaMetode + "\nUspesno je procitan slog iz baze podataka.";

                 if (odo.Napuni(RS))  // if1
		              { for (int j=0;j<odo.vratiBrojVezanihObjekata();j++)
						  { OpstiDomenskiObjekat vezo = odo.vratiVezaniObjekat(j);
                         	if (vezo == null)
                         	     { porukaMetode = porukaMetode + "\nNe postoji vezani objekat a navedeno je da postoji.";
                         	       return false;
                         	     }
                         	else  // else1
                         	     {
								    upit = "SELECT COUNT(*) as brojStavki" +
								 	       " FROM " + vezo.vratiImeKlase() +
                         	               " WHERE " + vezo.vratiUslovZaNadjiSlogove();
								    RS = st.executeQuery(upit);

								    if (RS.next() == false)
								         { porukaMetode = porukaMetode + "\nNe postoje slogovi vezanog objekta";
								   	       return true;
								         }
                         	        brojStavki = RS.getInt("brojStavki");
								    odo.kreirajVezaniObjekat(brojStavki,j);

 								    upit = "SELECT *" +
					     	  		       " FROM " + vezo.vratiImeKlase() +
                         	               " WHERE " + vezo.vratiUslovZaNadjiSlogove();
                         	        RS = st.executeQuery(upit);

                         	        int brojSloga = 0;
                         	        while(RS.next())
								   	  { odo.Napuni(RS,brojSloga,j);
 									    brojSloga ++;
									  }
								    porukaMetode = porukaMetode + "\nUspesno su procitani slogovi vezanog objekta";
						 	     } // end else1
					      } // end for
				      } // end if1
			     RS.close();
				 st.close();
		       } catch(Exception e)
		           { porukaMetode = porukaMetode + "\nGreska kod citanja sloga iz baze podataka." + e;
			         return false;
			       }
		   return true;
        }

   // ***koristi se***//
   public  boolean vratiLogickuVrednostAtributa(OpstiDomenskiObjekat odo, String nazivAtributa)
       { String upit;
	     ResultSet rs;
	     boolean s = false;
         try { st = con.createStatement();
	           upit = " SELECT *" +
	                  " FROM " + odo.vratiImeKlase() +
	                  " WHERE " + odo.vratiUslovZaNadjiSlog();
	           System.out.println("upit: " + upit);
	           rs = st.executeQuery(upit);
               rs.next();

			   s = KonverterTipova.Konvertuj(rs, s, nazivAtributa);

	           rs.close();
               st.close();
	         } catch(Exception e)
	             {  porukaMetode = porukaMetode + "\nGreska kod citanja logicke vrednosti atributa sloga." + e;
	                return false;
			     }
         return s;
       }

   // ***koristi se***//
   public boolean pamtiSlozeniSlog(OpstiDomenskiObjekat odo)
      { String upit;
        try { st = con.createStatement();
		      upit = " INSERT INTO " + odo.vratiImeKlase()  +
		             " VALUES (" + odo.vratiVrednostiAtributa() + ")";
		      st.executeUpdate(upit);
      	      for(int j=0;j<odo.vratiBrojVezanihObjekata();j++)
		            { OpstiDomenskiObjekat vezo;
   	                  for(int i=0; i < odo.vratiBrojSlogovaVezanogObjekta(j);i++)
   	                        { vezo = odo.vratiSlogVezanogObjekta(j,i);
   	    	                  upit = " INSERT INTO " + vezo.vratiImeKlase()  +
                                     " VALUES (" + vezo.vratiVrednostiAtributa() + ")";
                              st.executeUpdate(upit);
	  		                }
	                 }

              st.close();
            } catch(SQLException esql)
                {  porukaMetode = porukaMetode + "\nNije zapamcen slozeni slog: " + esql;
   	    	       return false;
   	  		    }
        porukaMetode = porukaMetode + "\nZapamcen je slozeni slog.";
        return true;
      }

/* Rekurzivno
public int pamtiSlozeniSlog(OpstiDomenskiObjekat odo)
      { String upit;

         try{

		 st = con.createStatement();
		 upit ="INSERT INTO " + odo.vratiImeKlase()  +
		                " VALUES (" + odo.vratiVrednostiAtributa() + ")";
		 st.executeUpdate(upit);

      	 for (int j=0;j<odo.vratiBrojVezanihObjekata();j++)
		  { OpstiDomenskiObjekat vezo;

   	          for(int i=0; i < odo.vratiBrojSlogovaVezanogObjekta(j);i++)
   	            {  vezo = odo.vratiSlogVezanogObjekta(j,i);
   	    	       pamtiSlozeniSlog(vezo);
	  		   }
	      }



       st.close();
             }   catch(SQLException esql)
                    { porukaMetode = porukaMetode + "\nNije uspesno zapamcen slozeni slog u bazi podataka: " + esql;
   	    	            return false;
   	  		     }
         porukaMetode = porukaMetode + "\nUspesno zapamcen slozeni slog u bazi podataka: ";
         return true;
      }*/

// ***koristi se***//
public String vratiPorukuMetode () {return porukaMetode;}

// ***koristi se***//
public void isprazniPoruku() {porukaMetode = "";}

// ***koristi se***//
public void dodajPorukuMetode (String poruka) {porukaMetode =  "\n" + poruka + porukaMetode;}
}