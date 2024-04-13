package pl.pollub.javatablereservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pollub.javatablereservations.dto.ChangeTableDto;
import pl.pollub.javatablereservations.dto.NewTableDto;
import pl.pollub.javatablereservations.dto.UpdateTableDto;
import pl.pollub.javatablereservations.entity.Table;
import pl.pollub.javatablereservations.entity.User;
import pl.pollub.javatablereservations.mediator.UserAccessMediator;
import pl.pollub.javatablereservations.observer.TableMonitor;
import pl.pollub.javatablereservations.observer.TableObserver;
import pl.pollub.javatablereservations.service.AuthService;
import pl.pollub.javatablereservations.service.TableService;
import pl.pollub.javatablereservations.service.UserService;
import pl.pollub.javatablereservations.session.Session;
import pl.pollub.javatablereservations.visitor.SynchronizationVisitor;
import pl.pollub.javatablereservations.visitor.SynchronizationVisitorImpl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class TableController {

    private final TableService tableService;
    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public TableController(TableService tableService, AuthService authService, UserService userService) {
        this.tableService = tableService;
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping(value = "tables")
    public List<Table> getTableList() {
        return this.tableService.getAllTableList();
    }

    @GetMapping(value = "avaible_tables")
    public List<Table> getAvailableTableList(@RequestParam(required = false) String date) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            try {
                return this.tableService.getAllAvailableTableList(formatter.parse(date));
            } catch (Exception exc) {
                throw new IllegalStateException(exc.getMessage());
            }
        }
        else {
            return this.tableService.getAllAvailableTableList(null);
        }
    }

    @PostMapping(value = "new_table")
    public void newTable(@RequestHeader("Authorization") String sessionId, @RequestBody NewTableDto table) {
        Session session = this.authService.getSession(UUID.fromString(sessionId)).orElseThrow();
        User user = this.userService.getUser(session.getUserId()).orElseThrow();

        Boolean accessible = new UserAccessMediator().mediateAccess(user, "edit");
        if (accessible) {
            this.tableService.newTable(table);
        } else {
            throw new IllegalStateException("No access");
        }
    }

    @PostMapping(value = "open_table")
    public void openTable(@RequestBody ChangeTableDto table) {
        this.tableService.openTable(table);
    }

    @PostMapping(value = "close_table")
    public void closeTable(@RequestBody ChangeTableDto table) {
        this.tableService.closeTable(table);
    }

    @PostMapping(value = "edit_table")
    public void editTable(@RequestBody UpdateTableDto table) {
        this.tableService.editTable(table);
    }

    @PostMapping(value = "create_memento")
    public void createMemento() {
        this.tableService.createMemento();
    }

    @PostMapping(value = "restore_from_memento")
    public void createMemento(@RequestParam("versionIndex") int versionIndex) {
        this.tableService.restoreFromMemento(versionIndex);
    }

    @PostMapping(value = "observe_table")
    public void observeTable(@RequestParam("tableId") UUID tableId) {
        TableMonitor.getInstance().addObserver(new TableObserver(tableId));
    }

    @PostMapping(value = "synchronize_tables")
    public void synchronize() {
        SynchronizationVisitor visitor = new SynchronizationVisitorImpl();
        for (Table table : this.tableService.getAllTableList()) {
            table.accept(visitor);
        }
    }
}
