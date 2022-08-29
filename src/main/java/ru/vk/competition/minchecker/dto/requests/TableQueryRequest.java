package ru.vk.competition.minchecker.dto.requests;

public class TableQueryRequest {
    private Integer queryId;
    private String tableName;
    private String query;

    public TableQueryRequest(Integer queryId, String tableName, String query) {
        this.queryId = queryId;
        this.tableName = tableName;
        this.query = query;
    }

    public Integer getQueryId() {
        return queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
