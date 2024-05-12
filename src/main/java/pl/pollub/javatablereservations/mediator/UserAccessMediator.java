package pl.pollub.javatablereservations.mediator;

import pl.pollub.javatablereservations.entity.User;
import pl.pollub.javatablereservations.strategy.CreateUserStrategy;
import pl.pollub.javatablereservations.strategy.EditUserStrategy;
import pl.pollub.javatablereservations.strategy.UserAccessStrategy;

import java.util.HashMap;
import java.util.Map;

public class UserAccessMediator implements UserMediator {

    private static final Map<String, UserAccessStrategy> STRATEGY_BY_ACCESS = new HashMap<>();
    static {
        STRATEGY_BY_ACCESS.put("edit", new EditUserStrategy());
        STRATEGY_BY_ACCESS.put("create", new CreateUserStrategy());
        STRATEGY_BY_ACCESS.put("create_user", user -> user.getRole().getName().equals("Moderator"));
    }

    @Override
    public Boolean mediateAccess(User user, String action) {
        UserAccessStrategy strategy = STRATEGY_BY_ACCESS.get(action);
        return strategy.determineAccess(user);
    }
}
