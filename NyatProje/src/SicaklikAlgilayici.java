import java.util.concurrent.ThreadLocalRandom;

public class SicaklikAlgilayici implements ISicaklikAlgilayici
{
    IAgArayuzu agArayuzu;

    public SicaklikAlgilayici(IAgArayuzu agArayuzu)
    {
        this.agArayuzu = agArayuzu;
    }


    @Override
    public int sicaklikHesapla()
    {
        int minimum = -40;
        int maksimum = +30;

        int sicaklik = ThreadLocalRandom.current().nextInt(minimum, maksimum + 1);

        return sicaklik;
    }
}
