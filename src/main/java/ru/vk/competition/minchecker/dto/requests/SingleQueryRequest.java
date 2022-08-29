package ru.vk.competition.minchecker.dto.requests;

public class SingleQueryRequest {
    private Object queryId;
    private String query;

    public SingleQueryRequest(Object queryId, String query) {
        this.queryId = queryId;
        this.query = query;
    }

    public SingleQueryRequest() {}

    public Object getQueryId() {
        return queryId;
    }

    public void setQueryId(Object queryId) {
        this.queryId = queryId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "SingleQueryRequest{" +
                "queryId=" + queryId +
                ", query='" + query + '\'' +
                '}';
    }
}
