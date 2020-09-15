package udemy.designpatterns.observer_komunikator;

public interface  Observerable {
    void addUser(Observer observer);
    void unregisterUSer(Observer observer);
    void notifyObservers();
}
