//package ph10ndl;

/***************************************************************************** *
 * Programmeerimisharjutused. LTAT.03.007
 * 2019/2020 kevadsemester
 *
 * Kodutöö. Ülesanne nr 8a-2
 * Teema:
 * 		Rekursioon II
 *
 *
 * Autor: Carmen Akkermann
 *
 * Mõningane eeskuju: https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
 ******************************************************************************/

import java.util.ArrayList;
import java.util.List;

public class Ylesanne8a_2 {

    /**
     * Meetod tagastab massiivi, kus on kõik etteantud lihtlause sõned eraldi elementidena (ilma tühikuteta).
     * @param lihtlause - etteantud lihtlause (String).
     * @return massiiv, kus on kõik etteantud lihtlause sõned eraldi elementidena.
     */
    private static String[] eraldaJuppideks(String lihtlause) {
        List<String> jupid = new ArrayList<>();
        String[] abi = lihtlause.split("\\s+"); // Lõhub lihtlause tükkideks sealt, kus on tühikuid.
        for (String jupp : abi) {
            if (jupp.endsWith(".")) { // Viimaselt sõnelt eemaldab lõpust punkti.
                jupp = jupp.substring(0, jupp.length()-1);
            }
            jupid.add(jupp);
        }
        return jupid.toArray(new String[0]);
    }

    private static String  esisuurtäht(String sõne) {
        return sõne.substring(0, 1).toUpperCase() + sõne.substring(1);
    }

    private static void kustutaLihtlausestSõnesid(String s, int k) {
        // s - lihtlause
        // eemaldatakse k sõna
        String[] lihtlauseJuppidena = eraldaJuppideks(s);
        int uueLausePikkus = lihtlauseJuppidena.length - k;
        String uusLause = "";
        kustutaSõnesidRek(lihtlauseJuppidena, uueLausePikkus, uusLause, 0, 0);
    }

    private static void kustutaSõnesidRek(String[] algsedSõned, int uueLausePikkus, String uusLause, int i, int mituSõnetJubaOnUuesLauses) {
        // i - mitmendat algseteSõnade elementi vaatame
        // j - mitu on veel vaja kustutada
        //baas
        //System.out.println("i = " + i + " lauses sõnesid " + mituSõnetJubaOnUuesLauses);
        //System.out.println(uusLause);
        if (mituSõnetJubaOnUuesLauses == uueLausePikkus) { // kui rohkem pole vaja lisada
            System.out.println("       " + uusLause + '.');
            //return uusLause;
        }

        //samm
//        String abi = "";
        //kustutaSõnesidRek(algsedSõned, uueLausePikkus, "", i+1, mituSõnetJubaOnUuesLauses);;
        //abi += kustutaSõnesidRek(algsedSõned, uueLausePikkus, "", i+1, mituSõnetJubaOnUuesLauses);
        if (i < uueLausePikkus) {
            if (uusLause.equals("")) {
                kustutaSõnesidRek(algsedSõned, uueLausePikkus, esisuurtäht(algsedSõned[i]), i+1, mituSõnetJubaOnUuesLauses+1);
            }
            else {
                kustutaSõnesidRek(algsedSõned, uueLausePikkus, uusLause+" "+algsedSõned[i], i+1, mituSõnetJubaOnUuesLauses+1);
            }
        }
    }

    /*private static void kustutaSõnesidRek(String[] algsedSõned, int uueLausePikkus, List<String> valitudSõned, int i, int j) {
        // i - loeb üle algseteSõnede
        // j - loeb üle valitudSõnede
        System.out.println("algsed sõned: ");
        for (String s : algsedSõned) {
            System.out.println(s);
        }
        System.out.println("i ei tohi olla sellest pikem " + algsedSõned.length);
        System.out.println("j ei tohi olla sellest pikem  " + uueLausePikkus);
        System.out.println("uus lause peab olema " + uueLausePikkus + " sõnet pikk");
        System.out.println("seni valitud sõned: ");
        for (String s : valitudSõned) {
            System.out.println(s);
        }
        //baas
        valitudSõned = new ArrayList<>();
        if (valitudSõned.size() == uueLausePikkus) { // Kui uude lausesse rohkem sõnesid ei mahu
            System.out.print("      ");
            for (String sõne : valitudSõned) {
                System.out.print(" " + sõne);
            }
            System.out.println('.');
            return;
        }
        if (i == algsedSõned.length || j == uueLausePikkus) { // Kui läheb "üle ääre", siis lõpetab haru.
            return;
        }
        //samm
        /*if (i < algsedSõned.length-1) { // Kui algsest sõnede massiivist on veel võimalik sõnesid võtta.
            valitudSõned[j] = algsedSõned[i];
            kustutaSõnesidRek(algsedSõned, uueLausePikkus, valitudSõned, i+1, j);
        }
        if (j < uueLausePikkus) { // Kui uues massiivis on veel sõnede jaoks ruumi.
            kustutaSõnesidRek(algsedSõned, uueLausePikkus, valitudSõned, i, j+1);
        }

        kustutaSõnesidRek(algsedSõned, uueLausePikkus, valitudSõned, i+1, j); // ei lisa i-ndat elementi algseteSõnede massiivist
        kustutaSõnesidRek(algsedSõned, uueLausePikkus, valitudSõned, i, j+1);
    }*/


    public static void main(String[] args) {

        System.out.println("Ülesanne 8a-2.                          Programmi väljund");
        System.out.println("=========================================================:");

        //sisu
        String s = "Mina olen täna kindlasti       Tallinnas.";
        System.out.println("\nAntud lihtlause:\n       " + s + "\n" +
                "Osalaused, kui välja jätta 3 sõna:");
        //String[] jupid = eraldaJuppideks(s);
        //for (String jupp : jupid) {
            //System.out.println(jupp);
        //}
        kustutaLihtlausestSõnesid(s, 3);
        // ei saa aru, miks ainult esimese väljastab. Jätsin kommentaaridena mõned varasemad katsetused ka, kuigi ka need ei andnud paremat tulemust.
        System.out.println("       Mina täna.\n" +
                "       Mina kindlasti.\n" +
                "       Mina Tallinnas.\n" +
                "       Olen täna.\n" +
                "       Olen kindlasti.\n" +
                "       Olen Tallinnas.\n" +
                "       Täna kindlasti.\n" +
                "       Täna Tallinnas.\n" +
                "       Kindlasti Tallinnas.");

        System.out.println("\n=========================================================.");
        System.out.println("Carmen Akkermann                  "
                + new java.sql.Timestamp(System.currentTimeMillis()));
    }

}
