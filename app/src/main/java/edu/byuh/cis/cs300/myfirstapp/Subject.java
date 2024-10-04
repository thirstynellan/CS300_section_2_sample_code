package edu.byuh.cis.cs300.myfirstapp;

public interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers();
}
