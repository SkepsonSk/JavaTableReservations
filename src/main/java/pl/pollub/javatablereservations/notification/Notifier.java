package pl.pollub.javatablereservations.notification;

import pl.pollub.javatablereservations.entity.User;

public abstract class Notifier {
    protected NotifierAPI notifierAPI;

    protected Notifier (NotifierAPI notifierAPI) {
        this.notifierAPI = notifierAPI;
    }

    public abstract void doNotify(User user, String title, String body);
}
