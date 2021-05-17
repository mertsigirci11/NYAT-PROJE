public class TeknikServis implements IObserver
{
    @Override
    public void update(String m) {
        System.out.println("Sistemden mesaj var: "+m);
    }
}
