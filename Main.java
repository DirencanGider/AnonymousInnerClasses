/*

Herhangi bir class tanımlama olmadan bir obje oluşturabiliyoruz.

Bir Interface veya Abstract class'ımız varsa ve bunlardan herhangi bir class türetmeden, bir obje oluşturmak istiyorsak
Anonim Inner Classları kullanıyoruz. Interface veya Abstact classların metodlarını implemente ederek o objeyi herhangi bir
 class tanımlamadan kullanabiliyoruz.

 Bu en çok android geliştirmede kullanılıyor.
 Androidde buton tanımlayıp, view.onclicklistener (galiba) gibi bir interfacei implemente ediyoruz. Buton için ekstra bir class
 yazmaya gerek kalmadan anonim class olarak yapmak istediğimiz işlemleri orada söyleyebiliyoruz.

 Yani çokca android geliştirmede kullanılıyor.

 */

public class Main {
    public static void main(String[] args) {

        IOgrenci ogrenci = new IOgrenci() { /* IOgrenci interfaceine uyan ogrenci objesini oluşturuyoruz. */  //  5
            @Override
            public void ders_calis() { // Objeyi oluşturduğumuzda bunları java otomatik olarak getirdi.  //  5

                // içlerini dolduruyoruz.  //  6

                System.out.println("Ders çalışıyorum...");

            }

            @Override
            public void derse_gir() { // Objeyi oluşturduğumuzda bunları java otomatik olarak getirdi.  //  5

                // İçlerini dolduruyoruz.  //  6

                System.out.println("Derse giriyorum...");

            }
        }; //  Bu bir class tanımlaması gibi olduğu için süslü parantezin yanına noktalı virgül bırakıyoruz.  //  7

        ogrenci.ders_calis();  //  8
        ogrenci.derse_gir();  //  9

        System.out.println("**********************************************************************************************");

        AOgrenci ogrenci2 = new AOgrenci("Direncan Gider", 695) {  /* //  14  //  Aşağıda main metodu dışındaki
                                                                                              Abstract class içinde
                                                                                              constructor oluşturduk ve
                                                                                              burada parantez içini ona
                                                                                              göre doldurduk.  */  //  25

            @Override
            void kayit_yaptir() {  // Bu otomatik gelmedi. Ben Sağ Click>Generate>Implement Method ile oluşturdum.  //  15

                System.out.println("Kayıt Yapılıyor...." + "İsim : " + getIsim() + "\tNumara : " + getNumara());  //  26

            }
        };  //  Noktalı virgülümüzü de tekrar koyduk.  //  16

        /*  Java yine hata vermeye devam etti. Nedeni ise abstract bir class olduğu için ve static olan main metodu içerisinde
            kullanıldığı için aşağıda abstract class da static yapmamız gerektiği idi. Aşağıda "public abstract static class"
            olarak düzeltme yaptık ve problem çözüldü.

            Interface'de böyle bir problem yaşamamıştık. Çünkü interfaceler tam bir class olarak nitelendirilmiyor. Ne özellik
            ekleyebiliyoruz ne de gövdeli metodlar kullanılıyor.

            Abstract bir class olduğu problem çıkardı. static keyword ekleyerek problemi çözmüş olduk. */  //  17

        ogrenci2.kayit_yaptir();  //  18
        ogrenci2.selamla();  //  19



    }
    /* Şimdi inner class olarak bir inerface tanımlayalım. Bunu başka dosya oluşturarak da yapabiliriz ama pratik olsun diye
       Main.java class'ının içerisinde tanımlıyoruz. */  //  1

    public interface IOgrenci { //  2

        void ders_calis(); //  3
        void derse_gir(); //  4

    }
    /* Şimdi de inner class olarak bir abstract class tanımlayalım. Benzer bir örneği burada da görelim. */  //  10

    public abstract static class AOgrenci {

        // SON OLARAK 2 ÖZELLİK EKLEYELİM. CONSTRUCTOR, GETTER VE SETTER METODLARINI YAZDIRALIM. NASIL KULLANACAĞIMIZI GÖRELİM.  //  20

        private String isim;  //  21
        private int numara;  //  22

        public AOgrenci(String isim, int numara) {  //  23
            this.isim = isim;
            this.numara = numara;
        }

        public String getIsim() {  //  24
            return isim;
        }

        public void setIsim(String isim) {  //  24
            this.isim = isim;
        }

        public int getNumara() {  //  24
            return numara;
        }

        public void setNumara(int numara) {  //  24
            this.numara = numara;
        }

        // Bir abstract metod bir de normal metod yazalım:  //  11

        abstract void kayit_yaptir();  //  12

        public void selamla() {  //  13

            System.out.println("Selamlar...");

        }

    }



}
