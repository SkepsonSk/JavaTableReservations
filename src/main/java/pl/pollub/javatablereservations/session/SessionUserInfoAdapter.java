package pl.pollub.javatablereservations.session;

import pl.pollub.javatablereservations.entity.User;
import pl.pollub.javatablereservations.repository.UserRepository;

import java.util.UUID;

public class SessionUserInfoAdapter implements UserInfo {

    private final UserRepository userRepository;
    private final Session session;

    public SessionUserInfoAdapter(Session session, UserRepository userRepository) {
        this.session = session;
        this.userRepository = userRepository;
    }

    @Override
    public UUID getUserId() {
        return this.session.getUserId();
    }

    @Override
    public String getName() {
        User user = this.userRepository.findById(this.session.getUserId()).orElseThrow();
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}
