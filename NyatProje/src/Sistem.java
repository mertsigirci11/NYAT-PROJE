import java.util.ArrayList;

public class Sistem implements ISubject
{
    private ArrayList<IObserver> subscribers = new ArrayList<IObserver>();

    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notify(String mesaj) {
        for(IObserver subscriber: subscribers) {
            subscriber.update(mesaj);
        }
    }
}
