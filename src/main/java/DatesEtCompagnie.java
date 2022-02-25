/**
 * Indiquer le ou les numeros de TP et d'exercice.
 *
 * @author (votre nom)
 */
import java.util.Scanner ;
public class DatesEtCompagnie {

    public static void main(String[] args) {
        System.out.println("Hello world !");
        System.out.println(estBissextile(2020));
    }

    /**
     *  @param annee une année
     *  @return vrai si l'année est bissextile, faux sinon
     */
    public static boolean estBissextile(int annee) {
        if (annee%4==0 && annee%100!=0 || annee%400==0) {
            return true;
        }
        return false ;
    }
     /**
     *  Détermine le nombre de jours dans un mois d'une année donnée
     *  @param mois
     *      mois
     *  @param année
     *      année
     *  @return le nombre de jours dans le mois
     */
    public static int nbJours(int mois, int annee) {
        if (mois==4 || mois==6 || mois==9 || mois==11) {
            return 30;
        }
        if (mois==1 || mois==3 || mois==5 || mois==7 || mois==8 || mois==10 || mois==12) {
            return 31;
        }
        if (estBissextile(annee)==true) {
            return 29;
        }
        return 28;
    }
     /**
     *  Détermine si une date est valide
     *  @param jour
     *      jour de la date
     *  @param mois
     *      mois de la date
     *  @param année
     *      année de la date
     *  @return vrai si la date est valide, faux sinon
     */
    public static boolean estValide(int jour, int mois, int annee) {
        // Cas où une valeur donnée est impossible
        if (annee<1582 || mois>12 || mois<1 || jour<1 || jour>31) {
            return false;
        }
        // Cas où le jour est plus grand que le nombre de jour dans le mois
        if (nbJours(mois,annee)<jour) {
            return false;
        }
        // Sinon la date est valide et on retourne vrai
        return true;
    }
    public static void saisieCalculAffichageValidite() {
        // Déclaration des variables
        int jour, mois, annee;
        boolean saisieValide;
        
        // Saisie des variables par l'utilisateur
        jour=saisieEntier("Saisissez le jour");
        mois=saisieEntier("Saisissez le mois");
        annee=saisieEntier("Saisissez l'année");
    
        // Test de la validitée de la date entrée par l'utilisateur
        if(estValide(jour,mois,annee)==true) {
            saisieValide=true;
        }
        else {
            saisieValide=false;
        }
    
    
        // Affichage des résultats à l'utilisateur
        if (saisieValide==true) {
            System.out.println("La date "+jour+"/"+mois+"/"+annee);
            System.out.println("est une date valide");
        }
        else {
            System.out.println("La date "+jour+"/"+mois+"/"+annee);
            System.out.println("n'est pas une date valide");
        }
    }
    /**
     * Fonction aidant a saisir un entier.
     * A priori, pas besoin de la modifier
     * @return entier saisi par l'utilisateur
     */
    public static int saisieEntier(String txt) {
        System.out.println(txt);
        Scanner clavier = new Scanner(System.in) ;
        int nombreSaisi = clavier.nextInt() ;
        return nombreSaisi ;
    }
}