package pl.pollub.javatablereservations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.pollub.javatablereservations.controller.TableController;
import pl.pollub.javatablereservations.dto.ChangeTableDto;
import pl.pollub.javatablereservations.dto.UpdateTableDto;
import pl.pollub.javatablereservations.entity.Table;
import pl.pollub.javatablereservations.service.AuthService;
import pl.pollub.javatablereservations.service.TableService;
import pl.pollub.javatablereservations.service.UserService;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TableController.class)
class TableControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TableService tableService;

    @MockBean
    private AuthService authService;

    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTableList() throws Exception {
        List<Table> tables = new ArrayList<>();
        when(tableService.getAllTableList()).thenReturn(tables);

        mockMvc.perform(MockMvcRequestBuilders.get("/tables"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(tables.size()));
    }

    @Test
    void getAvailableTableList() throws Exception {
        List<Table> tables = new ArrayList<>();
        when(tableService.getAllAvailableTableList(any(Date.class))).thenReturn(tables);

        mockMvc.perform(MockMvcRequestBuilders.get("/avaible_tables").param("date", "2023-01-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(tables.size()));
    }

    @Test
    void openTable() throws Exception {
        ChangeTableDto changeTableDto = new ChangeTableDto();
        String json = "{ \"tableId\": \"123e4567-e89b-12d3-a456-426614174000\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/open_table")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(tableService, times(1)).openTable(any(ChangeTableDto.class));
    }

    @Test
    void closeTable() throws Exception {
        ChangeTableDto changeTableDto = new ChangeTableDto();
        String json = "{ \"tableId\": \"123e4567-e89b-12d3-a456-426614174000\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/close_table")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(tableService, times(1)).closeTable(any(ChangeTableDto.class));
    }

    @Test
    void editTable() throws Exception {
        UpdateTableDto updateTableDto = new UpdateTableDto();
        String json = "{ \"tableId\": \"123e4567-e89b-12d3-a456-426614174000\", \"tableName\": \"Updated Table\", \"capacity\": 6 }";

        mockMvc.perform(MockMvcRequestBuilders.post("/edit_table")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        verify(tableService, times(1)).editTable(any(UpdateTableDto.class));
    }

    @Test
    void createMemento() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/create_memento"))
                .andExpect(status().isOk());

        verify(tableService, times(1)).createMemento();
    }

    @Test
    void restoreFromMemento() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/restore_from_memento")
                        .param("versionIndex", "1"))
                .andExpect(status().isOk());

        verify(tableService, times(1)).restoreFromMemento(1);
    }

    @Test
    void synchronize() throws Exception {
        List<Table> tables = new ArrayList<>();
        when(tableService.getAllTableList()).thenReturn(tables);

        mockMvc.perform(MockMvcRequestBuilders.post("/synchronize_tables"))
                .andExpect(status().isOk());

        verify(tableService, times(1)).getAllTableList();
    }
}
