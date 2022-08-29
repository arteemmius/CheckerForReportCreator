package ru.vk.competition.minchecker.service.request.table_query;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import ru.vk.competition.minchecker.dto.requests.TableQueryRequest;
import ru.vk.competition.minchecker.dto.results.SimpleResult;
import ru.vk.competition.minchecker.service.utils.Constants;
import ru.vk.competition.minchecker.utils.RequestBuilder;
import ru.vk.competition.minchecker.utils.Urls;

import java.io.IOException;

@Component
public class TableQueryCase {
    // add
    public void addTableQueryRequestCorrect(OkHttpClient client, SimpleResult simpleResult, TableQueryRequest tableQueryRequest) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.ADD_TABLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.postRequestBuilder(url.toString(), tableQueryRequest,"addTableQueryRequestCorrect");
        Response response = client.newCall(request).execute();
        System.out.println("addTableQueryRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    // run query
    public void executeTableQueryRequestCorrect(OkHttpClient client, SimpleResult simpleResult, String id) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.EXECUTE_TABLE_QUERY + "/" + id).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("executeTableQueryRequestRepeatCreate: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("executeTableQueryRequestRepeatCreate|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }
    // get query
    public void getTableQueryRequestCorrect(OkHttpClient client, SimpleResult simpleResult, String id) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.GET_TABLE_QUERY + "/" + id).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("getTableQueryRequestCorrect: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("getTableQueryRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }
}
