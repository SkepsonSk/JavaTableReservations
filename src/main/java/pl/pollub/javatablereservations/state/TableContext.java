package pl.pollub.javatablereservations.state;

import pl.pollub.javatablereservations.entity.Table;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TableContext {

    public static final Map<UUID, TableContext> TABLE_CONTEXT_BY_TABLE_ID = new HashMap<>();

    public static TableContext getContext(Table table) {
        if (!TABLE_CONTEXT_BY_TABLE_ID.containsKey(table.getId())) {
            TABLE_CONTEXT_BY_TABLE_ID.put(table.getId(), new TableContext(table, new TableReadyState()));
        }
        return TABLE_CONTEXT_BY_TABLE_ID.get(table.getId());
    }

    private final Table table;
    private TableState state;

    private TableContext(Table table, TableState state) {
        this.table = table;
        this.state = state;
    }

    public void setState(TableState state) {
        this.state = state;
    }

    public void requestStateChange() {
        this.state.handle(this.table);
    }
}
