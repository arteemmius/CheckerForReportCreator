package ru.vk.competition.minchecker.utils;

public interface Urls {
    String SINGLE_QUERY = "single-query/";
    //
    String ADD_SINGLE_QUERY_RESULT = SINGLE_QUERY + "add-new-query-result";
    String ADD_SINGLE_QUERY = SINGLE_QUERY + "add-new-query";
    //
    String MODIFY_SINGLE_QUERY_RESULT = SINGLE_QUERY + "add-modify-result";
    String MODIFY_SINGLE_QUERY = SINGLE_QUERY + "modify-single-query";
    //
    String DELETE_SINGLE_QUERY_RESULT = SINGLE_QUERY + "add-delete-result";
    String DELETE_SINGLE_QUERY_BY_ID = SINGLE_QUERY + "delete-single-query-by-id";
    //
    String EXECUTE_SINGLE_QUERY_RESULT = SINGLE_QUERY + "add-execute-result";
    String EXECUTE_SINGLE_QUERY_BY_ID = SINGLE_QUERY + "execute-single-query-by-id";
    //
    String GET_SINGLE_QUERY_RESULT = SINGLE_QUERY + "add-get-single-query-by-id-result";
    String GET_SINGLE_QUERY_BY_ID = SINGLE_QUERY + "get-single-query-by-id";

    String TABLE = "table/";
    //
    String CREATE_TABLE_RESULT = TABLE + "add-create-table-result";
    String CREATE_TABLE = TABLE + "create-table";
    //
    String GET_TABLE_RESULT = TABLE + "add-get-table-by-name-result";
    String GET_TABLE = TABLE + "get-table-by-name";
    //
    String DELETE_TABLE_RESULT = TABLE + "add-drop-table-result";
    String DELETE_TABLE = TABLE + "drop-table";

    String TABLE_QUERY = "table-query/";
    //
    String ADD_TABLE_QUERY_RESULT = TABLE_QUERY + "add-new-query-to-table-result";
    String ADD_TABLE_QUERY = TABLE_QUERY + "add-new-query-to-table";
    //
    String EXECUTE_TABLE_QUERY_RESULT = TABLE_QUERY + "execute-table-query-by-id-result";
    String EXECUTE_TABLE_QUERY = TABLE_QUERY + "execute-table-query-by-id";
    //
    String GET_TABLE_QUERY_RESULT = TABLE_QUERY + "get-table-query-by-id-result";
    String GET_TABLE_QUERY = TABLE_QUERY + "get-table-query-by-id";
    //

    String REPORT = "report/";
    //
    String CREATE_REPORT_RESULT = REPORT + "add-create-report-result";
    String CREATE_REPORT = REPORT + "create-report";
    //
    String GET_REPORT_RESULT = REPORT + "add-get-report-by-id-result";
    String GET_REPORT = REPORT + "get-report-by-id";
}
