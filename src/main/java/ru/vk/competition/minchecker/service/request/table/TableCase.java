package ru.vk.competition.minchecker.service.request.table;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import ru.vk.competition.minchecker.dto.requests.ColumnInfos;
import ru.vk.competition.minchecker.dto.requests.CreateTableRequest;
import ru.vk.competition.minchecker.dto.results.SimpleResult;
import ru.vk.competition.minchecker.service.utils.Constants;
import ru.vk.competition.minchecker.utils.RequestBuilder;
import ru.vk.competition.minchecker.utils.Urls;

import java.io.IOException;
import java.util.Arrays;

@Component
public class TableCase {
    // create table
    public void createTableRequestCorrect(OkHttpClient client, SimpleResult simpleResult, String tableName, String primaryKey) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.CREATE_TABLE).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.postRequestBuilder(url.toString(), getTableRequest(tableName, primaryKey),
                "createTableRequestCorrect");
        Response response = client.newCall(request).execute();
        System.out.println("createTableRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    // get table
    public void getTableRequestCorrect(OkHttpClient client, SimpleResult simpleResult, String tableName) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.GET_TABLE + "/" + tableName).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("getTableRequestCorrect: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("getTableRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    //drop table
    public void deleteTableRequestCorrect(OkHttpClient client, SimpleResult simpleResult, String tableName) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.DELETE_TABLE + "/" + tableName).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.deleteRequestBuilder(url.toString(), null, "deleteTableRequestCorrect");
        Response response = client.newCall(request).execute();
        System.out.println("deleteTableRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }
    //
    //
    private CreateTableRequest getTableRequest(String tableName, String primaryKey) {
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
        return new CreateTableRequest(tableName, 12, primaryKey,
                Arrays.asList(columnInfos0, columnInfos1, columnInfos2, columnInfos3, columnInfos4, columnInfos5,
                        columnInfos6, columnInfos7, columnInfos8, columnInfos9, columnInfos10, columnInfos11));
    }
}
