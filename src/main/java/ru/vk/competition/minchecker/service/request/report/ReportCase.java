package ru.vk.competition.minchecker.service.request.report;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import ru.vk.competition.minchecker.dto.requests.ColumnInfos;
import ru.vk.competition.minchecker.dto.requests.ReportRequest;
import ru.vk.competition.minchecker.dto.requests.TableInfo;
import ru.vk.competition.minchecker.dto.results.SimpleResult;
import ru.vk.competition.minchecker.service.utils.Constants;
import ru.vk.competition.minchecker.utils.RequestBuilder;
import ru.vk.competition.minchecker.utils.Urls;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@Component
public class ReportCase {
    // add
    public void createReportRequest1(OkHttpClient client, SimpleResult simpleResult, String tableName, int reportId) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.CREATE_REPORT).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.postRequestBuilder(url.toString(), getReportRequest(reportId, createTable1(tableName), 12), "createReportRequest1");
        Response response = client.newCall(request).execute();
        System.out.println("createReportRequest1|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }
    public void createReportRequest2(OkHttpClient client, SimpleResult simpleResult, String tableName, int reportId) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.CREATE_REPORT).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.postRequestBuilder(url.toString(), getReportRequest(reportId, createTable2(tableName), 7), "createReportRequest2");
        Response response = client.newCall(request).execute();
        System.out.println("createReportRequest2|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }
    public void createReportRequest3(OkHttpClient client, SimpleResult simpleResult, String tableName, int reportId) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.CREATE_REPORT).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.postRequestBuilder(url.toString(), getReportRequest(reportId, createTable3(tableName), 66), "createReportRequest3");
        Response response = client.newCall(request).execute();
        System.out.println("createReportRequest3|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }
    public void createReportRequest4(OkHttpClient client, SimpleResult simpleResult, String tableName, int reportId) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.CREATE_REPORT).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.postRequestBuilder(url.toString(), getReportRequest(reportId, createTable4(tableName), 12), "createReportRequest4");
        Response response = client.newCall(request).execute();
        System.out.println("createReportRequest4|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    //get
    public void getReportRequest(OkHttpClient client, SimpleResult simpleResult, String id) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.GET_REPORT + "/" + id).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("getReportRequest: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("getReportRequest|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }
    //
    //
    private ReportRequest getReportRequest(Integer reportId, TableInfo tableInfo, int size) {
        ReportRequest reportRequest = new ReportRequest(reportId, size, Collections.singletonList(tableInfo));
        //System.out.println("reportRequest=" + reportRequest);
        return reportRequest;
    }

    private TableInfo createTable1(String tableName) {
        TableInfo tableInfo = new TableInfo();
        ColumnInfos columnInfos0 = new ColumnInfos("CustomerId", "int4");
        ColumnInfos columnInfos1 = new ColumnInfos("FirstName", "VARCHAR(40)");
        ColumnInfos columnInfos2 = new ColumnInfos("LastName", "VARCHAR(20)");
        ColumnInfos columnInfos3 = new ColumnInfos("Company", "VARCHAR(80)");
        ColumnInfos columnInfos4 = new ColumnInfos("Address", "VARCHAR(70)");
        ColumnInfos columnInfos5 = new ColumnInfos("City", "VARCHAR(50)");
        ColumnInfos columnInfos6 = new ColumnInfos("Country", "VARCHAR(20)");
        ColumnInfos columnInfos7 = new ColumnInfos("Phone", "VARCHAR(20)");
        ColumnInfos columnInfos8 = new ColumnInfos("Fax", "VARCHAR(60)");
        ColumnInfos columnInfos9 = new ColumnInfos("Email", "VARCHAR(50)");
        ColumnInfos columnInfos10 = new ColumnInfos("SupportRepId", "int4");
        ColumnInfos columnInfos11 = new ColumnInfos("LastUpdateDate", "DATE");
        tableInfo.setTableName(tableName);
        tableInfo.setColumns(Arrays.asList(columnInfos0, columnInfos1, columnInfos2, columnInfos3, columnInfos4, columnInfos5,
                columnInfos6, columnInfos7, columnInfos8, columnInfos9, columnInfos10, columnInfos11));
        return tableInfo;
    }

    private TableInfo createTable2(String tableName) {
        TableInfo tableInfo = new TableInfo();
        ColumnInfos columnInfos0 = new ColumnInfos("CustomerId", "int4");
        ColumnInfos columnInfos1 = new ColumnInfos("FirstName", "VARCHAR(40)");
        ColumnInfos columnInfos2 = new ColumnInfos("LastName", "VARCHAR(20)");
        ColumnInfos columnInfos3 = new ColumnInfos("Company", "VARCHAR(80)");
        ColumnInfos columnInfos4 = new ColumnInfos("Address", "VARCHAR(70)");
        ColumnInfos columnInfos5 = new ColumnInfos("City", "VARCHAR(50)");
        ColumnInfos columnInfos6 = new ColumnInfos("Country", "VARCHAR(20)");
        tableInfo.setTableName(tableName);
        tableInfo.setColumns(Arrays.asList(columnInfos0, columnInfos1, columnInfos2, columnInfos3, columnInfos4, columnInfos5,
                columnInfos6));
        return tableInfo;
    }

    private TableInfo createTable3(String tableName) {
        TableInfo tableInfo = new TableInfo();
        ColumnInfos columnInfos0 = new ColumnInfos("CustomerId", "int4");
        ColumnInfos columnInfos1 = new ColumnInfos("FirstName", "VARCHAR(40)");
        ColumnInfos columnInfos2 = new ColumnInfos("LastName", "VARCHAR(20)");
        ColumnInfos columnInfos3 = new ColumnInfos("Company", "VARCHAR(80)");
        ColumnInfos columnInfos4 = new ColumnInfos("Address", "VARCHAR(70)");
        ColumnInfos columnInfos5 = new ColumnInfos("City", "VARCHAR(50)");
        ColumnInfos columnInfos6 = new ColumnInfos("Country", "VARCHAR(20)");
        ColumnInfos columnInfos7 = new ColumnInfos("Phone", "VARCHAR(20)");
        ColumnInfos columnInfos8 = new ColumnInfos("Fax", "VARCHAR(60)");
        ColumnInfos columnInfos9 = new ColumnInfos("Email", "VARCHAR(50)");
        ColumnInfos columnInfos10 = new ColumnInfos("SupportRepId", "int4");
        ColumnInfos columnInfos11 = new ColumnInfos("LastUpdateDate", "DATE");
        tableInfo.setTableName(tableName);
        tableInfo.setColumns(Arrays.asList(columnInfos0, columnInfos1, columnInfos2, columnInfos3, columnInfos4, columnInfos5,
                columnInfos6, columnInfos7, columnInfos8, columnInfos9, columnInfos10, columnInfos11));
        return tableInfo;
    }

    private TableInfo createTable4(String tableName) {
        TableInfo tableInfo = new TableInfo();
        ColumnInfos columnInfos0 = new ColumnInfos("CustomerId", "int4");
        ColumnInfos columnInfos1 = new ColumnInfos("FirstName", "VARCHAR(40)");
        ColumnInfos columnInfos2 = new ColumnInfos("LastName", "VARCHAR(20)");
        ColumnInfos columnInfos3 = new ColumnInfos("Company", "VARCHAR(80)");
        ColumnInfos columnInfos4 = new ColumnInfos("Address", "VARCHAR(70)");
        ColumnInfos columnInfos5 = new ColumnInfos("City", "VARCHAR(50)");
        ColumnInfos columnInfos6 = new ColumnInfos("Country", "int4");
        ColumnInfos columnInfos7 = new ColumnInfos("Phone", "VARCHAR(20)");
        ColumnInfos columnInfos8 = new ColumnInfos("Fax", "VARCHAR(60)");
        ColumnInfos columnInfos9 = new ColumnInfos("Email", "VARCHAR(50)");
        ColumnInfos columnInfos10 = new ColumnInfos("SupportRepId", "int4");
        ColumnInfos columnInfos11 = new ColumnInfos("LastUpdateDate", "DATE");
        tableInfo.setTableName(tableName);
        tableInfo.setColumns(Arrays.asList(columnInfos0, columnInfos1, columnInfos2, columnInfos3, columnInfos4, columnInfos5,
                columnInfos6, columnInfos7, columnInfos8, columnInfos9, columnInfos10, columnInfos11));
        return tableInfo;
    }
}
