package pl.pollub.javatablereservations.notification;

import pl.pollub.javatablereservations.entity.User;

public class DatabaseNotifier extends Notifier {

    public DatabaseNotifier(NotifierAPI notifierAPI) {
        super(notifierAPI);
    }

    @Override
    public void doNotify(User user, String title, String body) {
        this.notifierAPI.doNotify(user, title, body);
    }
}
