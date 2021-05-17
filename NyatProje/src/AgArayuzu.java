import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu
{
    private IEkran ekran;
    private IAgArayuzu agArayuzu;
    private ISicaklikAlgilayici sicaklikAlgilayici;


    @Override
    public int intVeriAl()
    {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    @Override
    public String stringVeriAl()
    {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    @Override
    public void sicaklikGetir(int sicaklik)
    {
        ekran.mesajGoruntule(String.valueOf(sicaklik));
    }

    @Override
    public int sogutucuyuAc(int sicaklik)
    {
        return sicaklik-10;
    }


}
