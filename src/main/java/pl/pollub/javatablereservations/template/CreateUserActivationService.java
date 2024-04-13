package pl.pollub.javatablereservations.template;

import pl.pollub.javatablereservations.dto.CreateUserDto;
import pl.pollub.javatablereservations.entity.User;
import pl.pollub.javatablereservations.service.UserService;

public class CreateUserActivationService extends UserActivationService {

    private UserService userService;
    private CreateUserDto createUserDto;

    public CreateUserActivationService(UserService userService, CreateUserDto createUserDto) {
        this.userService = userService;
        this.createUserDto = createUserDto;
    }

    @Override
    public User createUser() {
        return this.userService.saveUser(this.createUserDto);
    }

    @Override
    public void notifyUser(User user) {
        System.out.println("Notifying user...");
    }
}
