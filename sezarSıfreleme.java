
import java.util.Scanner;

public class sezarSıfreleme {

    static char[] alfabe = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static char[] alfabe_kucuk = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; // Henüz küçük harfler için yapılmadı

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Şifrelemek istediğiniz metni giriniz :");

        String Metin_original = scan.nextLine();
        // Şifrelenecek girdiyi kullanıcıdan alıp, bir değişkende tutuyoruz
      
        char[] sifresizMetin = Metin_original.toCharArray();
         /* Alınan girdiyi toCharArray metodu ile Karakter dizisine çeviriyoruz
        Bu çevrim işlemi sayesinde girdi de yer alan her biri karakteri alfabe dizimiz ile karşılaştırabileceğiz*/
        
         System.out.println("Şifreleme için istediğiniz anahtar numarasını giriniz: ");

        /* Kullanıcıdan sifreleme için gerekli olan anahtar numarasını alıyoruz ve girilen numara 26 dan büyük olmasına karşın
        key_num değişkenininin 26 ya modunu alıp değerini güncelliyoruz*/
        int key_num = scan.nextInt();
        key_num = key_num % 26;

        String sifreliMetin = sifrele(key_num, sifresizMetin);
        /* sifrele metodunu bir stringe atıyoruz string bir değer döndürdüğü için, veya istersek direkt metodu sout içine de
        yazabilriz >>> System.out.println(sıfrele(key_num, sifresizMetin);*/
       
        System.out.println("ŞİFRELİ METNİNİZ:  " + sifreliMetin);
    }

    public static String sifrele(int key, char[] metin) {

        for (int i = 0; i < metin.length; i++) {
            for (int j = 0; j < alfabe.length; j++) {

                if (metin[i] == alfabe[j]) {
                    int temp = j;

                    /*eşleştiği karakterin indexi ile şifreleme anahtarının sayısının toplamının 26(alfabedeki harf sayısı) dan küçük
                    olup olmadığını kontrol ediyoruz,
                    
                    >>eğer küçükse farklı bi işleme gerek duymadan sifresiz girdinin belirlenen indexini normal alfabedeki indexine key numarasını
                    ekleyerek yeni harf atamasını yapıyoruz
                    
                    >> eğer 26 dan büyükse, alfabedeki harf sayısından çıkarıyoruz ve çıkan değerle index değişimi yapıyoruz*/
                    
                    if (temp + key < alfabe.length) {  
                        metin[i] = alfabe[(temp + key)];
                        break;

                    } else {
                        int temp2 = (temp + key) - alfabe.length;
                        metin[i] = alfabe[temp2];
                        break;

                    }
                }
            }
        }

        String result = String.valueOf(metin);
        /*Yeni şifrelenen char dizisini String.valueOf() metodu ile stringe dönüştürüp result değişkenine atıyoruz
        ve result değişkenini de geri döndürüyoruz*/
        
        return result;
    }

}


// create by musab yigit
