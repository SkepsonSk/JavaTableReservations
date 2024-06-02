package pl.pollub.javatablereservations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import pl.pollub.javatablereservations.Constants;
import pl.pollub.javatablereservations.dto.ChangeTableDto;
import pl.pollub.javatablereservations.dto.NewTableDto;
import pl.pollub.javatablereservations.dto.UpdateTableDto;
import pl.pollub.javatablereservations.entity.Status;
import pl.pollub.javatablereservations.entity.Table;
import pl.pollub.javatablereservations.entity.builder.TableBuilder;
import pl.pollub.javatablereservations.repository.StatusRepository;
import pl.pollub.javatablereservations.repository.TableRepository;
import pl.pollub.javatablereservations.service.TableService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TableServiceTest {

    @InjectMocks
    private TableService tableService;

    @Mock
    private TableRepository tableRepository;

    @Mock
    private StatusRepository statusRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTableList() {
        List<Table> tableList = new ArrayList<>();
        when(tableRepository.findAll()).thenReturn(tableList);

        List<Table> result = tableService.getAllTableList();

        assertEquals(tableList, result);
    }

    @Test
    public void testGetAllAvailableTableList_NoDate() {
        List<Table> tableList = new ArrayList<>();
        when(tableRepository.getAvailableTableList()).thenReturn(tableList);

        List<Table> result = tableService.getAllAvailableTableList(null);

        assertEquals(tableList, result);
    }

    @Test
    public void testNewTable() {
        NewTableDto newTableDto = new NewTableDto();
        UUID statusId = UUID.randomUUID();

        newTableDto.setSeats(4);
        newTableDto.setStatus(statusId);

        tableService.newTable(newTableDto);

        verify(tableRepository, times(1)).save(any(Table.class));
    }

    @Test
    public void testEditTable() {
        UpdateTableDto updateTableDto = new UpdateTableDto();

        UUID id = UUID.randomUUID();
        UUID statusId = UUID.randomUUID();

        updateTableDto.setId(id);
        updateTableDto.setSeats(4);
        updateTableDto.setStatus(statusId);
        Table table = new TableBuilder().setSeats(4).setStatus(new Status(statusId)).getTable();

        when(tableRepository.getTableById(id)).thenReturn(Optional.of(table));

        tableService.editTable(updateTableDto);

        verify(tableRepository, times(1)).save(table);
        assertEquals(updateTableDto.getSeats(), table.getSeats());
    }

    @Test
    public void testCreateMemento() {
        Table table = new TableBuilder().setSeats(4).setStatus(new Status(UUID.randomUUID())).getTable();
        List<Table> tableList = Collections.singletonList(table);

        when(tableRepository.findAll()).thenReturn(tableList);

        tableService.createMemento();

        verify(tableRepository, times(1)).findAll();
    }
}
