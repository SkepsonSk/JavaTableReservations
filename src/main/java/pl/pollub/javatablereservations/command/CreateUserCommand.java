package pl.pollub.javatablereservations.command;

import pl.pollub.javatablereservations.dto.CreateUserDto;
import pl.pollub.javatablereservations.service.UserService;

public class CreateUserCommand implements Command {

    private final UserService userService;
    private final CreateUserDto createUserDto;

    public CreateUserCommand(UserService userService, CreateUserDto createUserDto) {
        this.userService = userService;
        this.createUserDto = createUserDto;
    }

    @Override
    public void execute() {
        this.userService.saveUser(this.createUserDto);
    }
}
