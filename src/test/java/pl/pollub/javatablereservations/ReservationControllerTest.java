package pl.pollub.javatablereservations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.pollub.javatablereservations.controller.ReservationController;
import pl.pollub.javatablereservations.dto.ChangeReservationDto;
import pl.pollub.javatablereservations.dto.CreateReservationDto;
import pl.pollub.javatablereservations.entity.Reservation;
import pl.pollub.javatablereservations.service.ReservationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebMvcTest(ReservationController.class)
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllReservations() throws Exception {
        List<Reservation> reservations = new ArrayList<>();
        when(reservationService.getAllReservations()).thenReturn(reservations);

        mockMvc.perform(MockMvcRequestBuilders.get("/all_reservations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(reservations.size()));
    }

    @Test
    void getAllReservationsByDate() throws Exception {
        List<Reservation> reservations = new ArrayList<>();
        when(reservationService.getAllReservationsByDate(any(Date.class))).thenReturn(reservations);

        mockMvc.perform(MockMvcRequestBuilders.get("/reservations_by_date")
                        .param("date", "2023-01-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(reservations.size()));
    }

    @Test
    void createReservation() throws Exception {
        CreateReservationDto createReservationDto = new CreateReservationDto();
        String json = "{ \"tableId\": 1, \"customerName\": \"John Doe\", \"email\": \"john.doe@example.com\", \"phoneNumber\": \"1234567890\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/create_reservation")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Reservation created"));
    }

    @Test
    void acceptReservation() throws Exception {
        ChangeReservationDto changeReservationDto = new ChangeReservationDto();
        String json = "{ \"reservationId\": 1, \"status\": \"ACCEPTED\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/accept_reservation")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(reservationService, times(1)).updateReservationStatus(any(ChangeReservationDto.class), eq(Constants.STATUS_API_NAME_RES_ACC));
    }

    @Test
    void rejectReservation() throws Exception {
        ChangeReservationDto changeReservationDto = new ChangeReservationDto();
        String json = "{ \"reservationId\": 1, \"status\": \"REJECTED\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/reject_reservation")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(reservationService, times(1)).updateReservationStatus(any(ChangeReservationDto.class), eq(Constants.STATUS_API_NAME_RES_CAN));
    }

    @Test
    void synchronize() throws Exception {
        List<Reservation> reservations = new ArrayList<>();
        when(reservationService.getAllReservations()).thenReturn(reservations);

        mockMvc.perform(MockMvcRequestBuilders.post("/synchronize_reservations"))
                .andExpect(status().isOk());

        verify(reservationService, times(1)).getAllReservations();
    }
}
