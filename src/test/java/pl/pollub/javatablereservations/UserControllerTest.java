package pl.pollub.javatablereservations;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.pollub.javatablereservations.controller.UserController;
import pl.pollub.javatablereservations.dto.CreateUserDto;
import pl.pollub.javatablereservations.entity.User;
import pl.pollub.javatablereservations.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUsers() throws Exception {
        List<User> users = new ArrayList<>();
        when(userService.getUsers()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(users.size()));
    }

    @Test
    void getUsersIterator() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User());
        when(userService.getUsers()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/iterator"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(users.get(0).getId()));
    }

    @Test
    void createUser() throws Exception {
        CreateUserDto createUserDto = new CreateUserDto();
        String json = "{ \"username\": \"john\", \"password\": \"password123\", \"email\": \"john.doe@example.com\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/create_user")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(userService, times(1)).saveUser(any(CreateUserDto.class));
    }

    @Test
    void editUser() throws Exception {
        CreateUserDto createUserDto = new CreateUserDto();
        String json = "{ \"username\": \"john\", \"password\": \"password123\", \"email\": \"john.doe@example.com\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/edit_user")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(userService, times(1)).saveUser(any(CreateUserDto.class));
    }

    @Test
    void activateUser() throws Exception {
        CreateUserDto createUserDto = new CreateUserDto();
        String json = "{ \"username\": \"john\", \"password\": \"password123\", \"email\": \"john.doe@example.com\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/activate_user")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(userService, times(1)).saveUser(any(CreateUserDto.class));
    }
}
