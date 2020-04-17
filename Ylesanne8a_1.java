//package ph10ndl;

/***************************************************************************** *
 * Programmeerimisharjutused. LTAT.03.007
 * 2019/2020 kevadsemester
 *
 * Kodutöö. Ülesanne nr 8a-1
 * Teema:
 * 		Rekursioon II
 *
 *
 * Autor: Carmen Akkermann
 ******************************************************************************/

public class Ylesanne8a_1 {

    public static int vähimMüntideArv = 10000; // Sellega hakkab võrdlema meetodis ostusummaRek leitud müntide arvusid.

    /**
     * Meetod ostusumma teeb ettevalmistused meetodi ostusummaRek jaoks ja kutsub selle välja.
     * @param mündid - antud müntide massiiv.
     * @param etteantudSumma - antud ostusumma.
     */
    private static void ostusumma(int[] mündid, double etteantudSumma) {

        int summaSentides = (int)(etteantudSumma * 100);

        int[] mündidKahanevalt = new int[mündid.length];
        for (int i = 0; i < mündid.length; i++) {
            mündidKahanevalt[i] = mündid[mündid.length-1-i];
        }

        ostusummaRek(mündidKahanevalt, summaSentides, 0, 0, 0);
        vähimMüntideArv = 10000; // Lähtestab staatilise muutuja väärtuse, kui meetod on oma töö lõpetanud.
    }

    /**
     * Meetod väljastab vähima müntide arvu, mida on vaja, et saada kokku summa nende müntidega, mis on massiivis x.
     * @param x - müntide massiiv.
     * @param s - etteantud ostusumma sentides.
     * @param summa - kasutatud müntide summa sentides.
     * @param mituMüntiKasutatud - loendur, mis jälgib, mitu münti summa saamiseks kasutatud on.
     * @param i - loendur, mis jälgib, mitmenda mündi kasutamist kaalutakse.
     */
    private static void ostusummaRek(int[] x, int s, int summa, int mituMüntiKasutatud, int i) {
        //baas
        if (summa == s && vähimMüntideArv != mituMüntiKasutatud) { // Kui kasutatud müntide arv on võimalikest vähim, siis väljastab selle.
            // vähimMüntideArv != mituMüntiKasutatud on kontrolliks, et ei väljastaks sama väärtust mitu korda.
            System.out.println(mituMüntiKasutatud);
            vähimMüntideArv = mituMüntiKasutatud;
            return;
        }
        if (summa > s || // Kui münte kokku liites on vajalik summa ületatud.
                i == x.length || // Kui loendur i läheb välja
                mituMüntiKasutatud >= vähimMüntideArv) // Kui on juba leidnud mingisuguse müntide arvu,
                // mis annavad kokku summa, siis sellest suurema müntide arvuga summasid enam ei vaata.
            return;

        //samm
        ostusummaRek(x, s, summa+x[i], mituMüntiKasutatud+1, i); // Võtab uuesti i-ndat münti.
        ostusummaRek(x, s, summa, mituMüntiKasutatud, i+1); // Ei võta i-ndat münti.
        ostusummaRek(x, s, summa+x[i], mituMüntiKasutatud+1, i+1); // Võtab i-ndast järgmise mündi.
    }

    public static void main(String[] args) {

        System.out.println("Ülesanne 8a-1.                          Programmi väljund");
        System.out.println("=========================================================:");

        System.out.print("\nJukul on kodus münte vääringutes [2, 5, 10, 20]\n" +
                "Vähim arv münte, et tasuda 0.82 €: ");
        int[] mündid = {2, 5, 10, 20};
        ostusumma(mündid, 0.82);


        System.out.print("\nJukul on kodus münte vääringutes [2, 5, 10, 20]\n" +
                "Vähim arv münte, et tasuda 0.81 €: ");
        ostusumma(mündid, 0.81);

        System.out.print("\nJukul on kodus münte vääringutes [1, 5, 10]\n" +
                "Vähim arv münte, et tasuda 0.82 €: ");
        int[] mündid2 = {1, 5, 10};
        ostusumma(mündid2, 0.82);

        System.out.print("\nJukul on kodus münte vääringutes [1, 2, 5, 10, 20, 100]\n" +
                "Vähim arv münte, et tasuda 1.08 €: ");
        int[] mündid3 = {1, 2, 5, 10, 20, 100};
        ostusumma(mündid3, 1.08);

        System.out.println("\n=========================================================.");
        System.out.println("Carmen Akkermann                  "
                + new java.sql.Timestamp(System.currentTimeMillis()));
    }
}
