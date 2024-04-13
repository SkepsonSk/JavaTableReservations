package pl.pollub.javatablereservations.notification;

import pl.pollub.javatablereservations.entity.User;

public interface NotifierAPI {

    void doNotify(User user, String title, String body);

}
