package com.bugeverywhere.app.session;

import com.bugeverywhere.app.model.entity.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GlobalSession {
    private static GlobalSession instance;
    @Getter
    @Setter
    private List<Table> tables;
    @Getter
    @Setter
    private Table currentTable;

    private GlobalSession() {
        tables = new ArrayList<>();
    }
    public static GlobalSession getSession(){
        if (instance == null){
            instance = new GlobalSession();
        }
        return instance;
    }

    public void addTableToSession(Table table) {
        assert table != null : "Bàn không thể null";
        tables.add(table);
    }

    public int getLastTableNumber(){
        if (tables.isEmpty()) {
            return 1;
        } else {
            Table lastTable = tables.get(tables.size() - 1);
            String tableName = lastTable.getTableName();
            return tables.size() + 1;
        }
    }


}
