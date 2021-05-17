public class Kullanici implements IKullanici, IObserver
{
    private String isim;
    private String soyisim;
    private String kullaniciAdi;
    private String sifre;
    private int minimumSicaklik;
    private int maximumSicaklik;

    @Override
    public void update(String m) {
        System.out.println("Sistemden mesaj var: "+ m);
    }

    public Kullanici(KullaniciBuilder builder)
    {
        this.isim = builder.isim;
        this.soyisim = builder.soyisim;
        this.kullaniciAdi = builder.kullaniciAdi;
        this.sifre = builder.sifre;
        this.minimumSicaklik = builder.minimumSicaklik;
        this.maximumSicaklik = builder.maximumSicaklik;
    }

    @Override
    public String getIsim()
    {
        return isim;
    }
    @Override
    public String getSoyisim()
    {
        return soyisim;
    }
    @Override
    public String getKullaniciAdi()
    {
        return kullaniciAdi;
    }
    @Override
    public String getSifre()
    {
        return sifre;
    }
    @Override
    public int getMinimumSicaklik()
    {
        return minimumSicaklik;
    }
    @Override
    public int getMaximumSicaklik()
    {
        return maximumSicaklik;
    }



    public static class KullaniciBuilder
    {
        private String isim;
        private String soyisim;
        private String kullaniciAdi;
        private String sifre;
        private int minimumSicaklik;
        private int maximumSicaklik;

        public KullaniciBuilder(String isim, String soyisim)
        {
            this.isim = isim;
            this.soyisim = soyisim;
        }
        public KullaniciBuilder kullaniciAdi (String kullaniciAdi)
        {
            this.kullaniciAdi = kullaniciAdi;
            return this;
        }
        public KullaniciBuilder sifre (String sifre)
        {
            this.sifre = sifre;
            return this;
        }
        public KullaniciBuilder minimumSicaklik (int minimumSicaklik)
        {
            this.minimumSicaklik = minimumSicaklik;
            return this;
        }
        public KullaniciBuilder maximumSicaklik (int maximumSicaklik)
        {
            this.maximumSicaklik = maximumSicaklik;
            return this;
        }

        public Kullanici build()
        {
            return new Kullanici(this);
        }
    }
}

