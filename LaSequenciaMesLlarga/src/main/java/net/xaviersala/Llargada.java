package net.xaviersala;

/**
 * Calcula la llargada de la seqüència de caràcters més llarga d'una cadena.
 *
 * @author xavier
 *
 */
public class Llargada {

       /**
     * Calcula quina és la seqüència de caràcters repetits més gran.
     *
     * @param frase frase a analitzar
     * @return caràcters i repeticions
     */
    public String calcula(String frase) {

        String resultat = "";

        // Si no hi ha caràcters s'ha acabat
        if (frase.length() == 0) {
            return resultat;
        }

        int max = 0;
        int count = 0;
        char caracter=frase.charAt(0);

        for(int i=0; i<frase.length(); i++) {
            // Mentre el caràcter es repeteixi, es compta...
            if (frase.charAt(i) == caracter) {
                count ++;
            } else {
                // Ja no es repeteix. Si és el màxim s'afegeix
                if (count == max) {
                    resultat = resultat + "," + caracter;
                } else if (count > max) {
                    // Si més més gran es canvien els resultats
                    resultat = Character.toString(caracter);
                    max = count;
                }
                // Comencem a comptar de nou
                caracter = frase.charAt(i);
                count = 1;
            }
        }
        // Falta la darrera repetició
        if (count == max) {
            resultat = resultat + "," + caracter;
        } else if (count > max) {
            resultat = Character.toString(caracter);
            max = count;
        }

        return resultat + " " + max;
    }

}
