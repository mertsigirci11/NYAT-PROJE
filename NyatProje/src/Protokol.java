public class Protokol
{
    private IEkran ekran;
    private IAgArayuzu agArayuzu;
    private Kullanici kullanici;
    private ISicaklikAlgilayici algilayici;
    IVeritabani veritabani;

    private static final int SICAKLIK_GORUNTULE = 1;
    private static final int SOGUTUCU_AC = 2;
    private static final int SOGUTUCU_KAPAT = 3;
    private static final int CIKIS = 4;
    private static final int KAYIT_OL = 1;
    private static final int GIRIS = 2;
    public static String kullaniciAdi;
    public static String sifre;
    public static int sicaklik;


    public Protokol()
    {
        ekran=new Ekran();
        agArayuzu = new AgArayuzu();
        algilayici = new SicaklikAlgilayici(agArayuzu);
    }

    String anaMenu="**********************************************\nAna Menu\n1-Sıcaklık Görüntüle\n2-Soğutucu Aç\n3-Soğutucu Kapat\n4-Çıkış\n**********************************************\nSeciminiz:";


    public void basla()
    {
        int secim;
        ekran.mesajGoruntule("Soğutma cihazı açılıyor.");

        ekran.mesajGoruntule("Kullanici adinizi giriniz:");
        kullaniciAdi = agArayuzu.stringVeriAl();
        ekran.mesajGoruntule("Sifrenizi giriniz:");
        sifre = agArayuzu.stringVeriAl();

        veritabani = new Veritabani();
        if (veritabani.dogrula(kullaniciAdi, sifre))
        {
            kullanici = new Kullanici.KullaniciBuilder(veritabani.kullaniciAdi(kullaniciAdi,sifre), veritabani.kullaniciSoyadi(kullaniciAdi,sifre))
                    .sifre(sifre).kullaniciAdi(kullaniciAdi)
                    .minimumSicaklik(veritabani.minSicaklik(kullaniciAdi,sifre))
                    .maximumSicaklik(veritabani.maxSicaklik(kullaniciAdi,sifre)).build();

            islemSecimi(veritabani,kullanici);
        }




    }

    private void islemSecimi(IVeritabani veritabani, Kullanici kullanici)
    {
        int secim;

        sicaklik = algilayici.sicaklikHesapla();

        do{
            ekran.mesajGoruntule(anaMenu);
            secim = agArayuzu.intVeriAl();


            switch (secim) {
                case SICAKLIK_GORUNTULE:
                    algilayici =new SicaklikAlgilayici(agArayuzu);
                    ekran.mesajGoruntule("Sıcaklık değeri : "+String.valueOf(sicaklik));
                    if (veritabani.maxSicaklik(kullaniciAdi,sifre)<sicaklik)
                    {
                        ekran.mesajGoruntule("Sıcaklık maksimum değerden fazla, soğutucu açılıyor.");
                        while(veritabani.maxSicaklik(kullaniciAdi,sifre)<sicaklik)
                        {
                            sicaklik= agArayuzu.sogutucuyuAc(sicaklik);
                            ekran.mesajGoruntule("Soğutucu çalıştı");
                            ekran.mesajGoruntule("Sıcaklık "+ sicaklik +" seviyesine düştü");

                            if (veritabani.maxSicaklik(kullaniciAdi,sifre)==sicaklik)
                            {
                                ekran.mesajGoruntule("Sıcaklık maksimum limite gelindiği için soğutucu durduruldu.");
                                break;
                            }
                        }
                    }
                    break;

                case SOGUTUCU_AC:
                    algilayici =new SicaklikAlgilayici(agArayuzu);

                    ekran.mesajGoruntule("Ölçülen sıcaklık değeri: " + String.valueOf(sicaklik));

                    if (veritabani.minSicaklik(kullaniciAdi,sifre)>sicaklik)
                    {
                        ekran.mesajGoruntule("Sıcaklık minimum değerin altında olduğu için soğutucu çalıştırılamaz.");
                    }
                    else
                    {
                        ekran.mesajGoruntule("Soğutucu açılıyor");
                        while(veritabani.minSicaklik(kullaniciAdi,sifre)<sicaklik)
                        {
                            sicaklik = agArayuzu.sogutucuyuAc(sicaklik);
                            ekran.mesajGoruntule("Soğutucu çalıştı");
                            ekran.mesajGoruntule("Sıcaklık "+ sicaklik +" seviyesine düştü");
                            if (veritabani.minSicaklik(kullaniciAdi,sifre)>sicaklik)
                            {
                                ekran.mesajGoruntule("Sıcaklık minimum değerin altında olduğu için soğutucu çalıştırılamaz.");
                                break;
                            }
                        }
                    }
                    break;

                case SOGUTUCU_KAPAT:
                    ekran.mesajGoruntule("Soğutucu kapatıldı.");
                    break;

                case CIKIS:
                    ekran.mesajGoruntule("Çıkılıyor");
                    break;
                default:
                    ekran.mesajGoruntule("1-4 arasında bir sayı girmelisiniz");
            }
        }while(secim!=4);
    }


}
