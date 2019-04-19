/**
 *
 * @author Serhan Öztuna, Enes Kaya
 * @since 21.03.2017
 * <p>
 * Kütüphane Dosyası
 * </p>
 */
package paket;

import java.text.DateFormat;//sistem saati ile ilgili işlemler için kütüphaneler tanımlanıyor.
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author EnesKaya
 */
public class rastgeleKarakterler {

    private int j = 0, eskiSayi = 0;//değişkenler tanımlanıyor.
    //Rastgele harf seçebilmek için öncelikle rastgele sayı 
//üretebilmemiz gerekiyor. Bu sayı üzerinden karakter üretebiliriz.

    private int rastgeleSayi() {
        Date simdikiZaman = new Date();//sistem saati değişkene atılıyor.
        DateFormat saat = new SimpleDateFormat("hh");//saat dakika saniye ve milisaniye değişkene atılıyor.
        DateFormat dakika = new SimpleDateFormat("mm");
        DateFormat saniye = new SimpleDateFormat("ss");
        DateFormat milisaniye = new SimpleDateFormat("SSS");
        int saniye2 = Integer.parseInt(saniye.format(simdikiZaman));//değişkenler integera çevriliyor.
        int milisaniye2 = Integer.parseInt(milisaniye.format(simdikiZaman));
        int dakika2 = Integer.parseInt(dakika.format(simdikiZaman));
        int saat2 = Integer.parseInt(saat.format(simdikiZaman));
        j = (j + 1) % 15;

        eskiSayi = (int) ((saat2 + dakika2 + saniye2 + milisaniye2) * //değişkenleri topluyoruz.
                (Math.pow(7, j) % 11)//değişkenleri karmaşıklaştırmak için karmaşık bir fonksiyon yarattık.
                + eskiSayi);//ve değerin sürekli aynı çıkmaması için feedback yaptık.
        return eskiSayi;
    }

//En fazla belirtilen sayıda rastgele harfler oluşturur.
    public String random(int maksAdet) {
        String cikti = "";//cikti değişkeni tanımladık.
        int adet = (rastgeleSayi() % maksAdet) + 1;
        for (int i = 1; i <= adet; i++) {//bir döngü ile istenilen adet kadar rastgele harfleri değişkene atadık.
            char ch = (char) (rastgeleSayi() % 52 + 65);
            if (ch > 90) {
                ch += 6;
            }
            cikti += ch; //Oluşturduğumuz karakterleri stringe atadık.
        }
        return cikti;//sonucu döndürdük.
    }

//En fazla belirtilen sayıda, iki karakter arası rastgele harfler oluştur.
    public String random(int maksAdet, char c1, char c2) {
        String cikti = "";
        int adet = (rastgeleSayi() % maksAdet) + 1;
        if (c1 > c2) {
            char tmp = c1;
            c1 = c2;
            c2 = tmp;
        }
        for (int i = 1; i <= adet; i++) {
            char ch = (char) (rastgeleSayi() % (c2 - c1 + 1) + c1);
            cikti += ch; //Oluşturduğumuz karakterleri stringe atadık.
        }
        return cikti;
    }

//En fazla belirtilen sayıda, belirtilen harflerden rastgele harfler oluştur.
    public String random(int maksAdet, String karakterler) {

        String cikti = "";//Karakterleri tutmak için
        int Adet = (rastgeleSayi() % maksAdet) + 1;
        for (int i = 1; i <= Adet; i++) {
            char ch = karakterler.charAt(rastgeleSayi() % karakterler.length());
            cikti += ch;
        }
        return cikti;
    }

//En fazla belirtilen uzunlukta cümle oluştur.
    public String cumle(int maksAdet) {
        String cikti = "";//krakterleri tutmak için
        int Adet = (rastgeleSayi() % maksAdet) + 1;
        int indis = (rastgeleSayi() % 8) + 4;//i'yi burda 1 aldık.
        for (int i = 1; i <= Adet; i++) {
            if (indis == i)//kelimeler arası boşluk bırakıyoruz.
            {
                indis += (rastgeleSayi() % 8) + 4;
                cikti +=" ";
            }
            char ch;
            if (rastgeleSayi() % 2 == 0) {
                ch = (char) (rastgeleSayi() % 26 + 65);
            } else {
                ch = (char) (rastgeleSayi() % 26 + 97);
            }
            cikti += ch;//oluşturduğumuz karakterleri stringe atadık.
        }
        return cikti;
    }

}
