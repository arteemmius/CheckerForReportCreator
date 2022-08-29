package ru.vk.competition.minchecker.service.result;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import ru.vk.competition.minchecker.dto.results.SimpleResult;
import ru.vk.competition.minchecker.utils.RequestBuilder;
import ru.vk.competition.minchecker.utils.Urls;

import java.io.IOException;

@Component
public class CreateResult {
    public SimpleResult createAddNewQueryResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.ADD_SINGLE_QUERY_RESULT);
    }

    public SimpleResult createModifySingleQueryResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.MODIFY_SINGLE_QUERY_RESULT);
    }

    public SimpleResult createDeleteSingleQueryResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.DELETE_SINGLE_QUERY_RESULT);
    }

    public SimpleResult createExecuteSingleQueryResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.EXECUTE_SINGLE_QUERY_RESULT);
    }

    public SimpleResult createGetSingleQueryResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.GET_SINGLE_QUERY_RESULT);
    }

    public SimpleResult createTableResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.CREATE_TABLE_RESULT);
    }

    public SimpleResult getTableResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.GET_TABLE_RESULT);
    }

    public SimpleResult deleteTableResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.DELETE_TABLE_RESULT);
    }

    public SimpleResult addTableQueryResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.ADD_TABLE_QUERY_RESULT);
    }

    public SimpleResult executeTableQueryResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.EXECUTE_TABLE_QUERY_RESULT);
    }

    public SimpleResult getTableQueryResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.GET_TABLE_QUERY_RESULT);
    }

    public SimpleResult addReportResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.CREATE_REPORT_RESULT);
    }

    public SimpleResult getReportResult(OkHttpClient client, Integer resultId, Integer code) throws IOException {
        return (SimpleResult) createResultByURL(client, new SimpleResult(resultId, code), RequestBuilder.API_ROOT + Urls.GET_REPORT_RESULT);
    }

    private Object createResultByURL(OkHttpClient client, Object obj, String url) throws IOException {
        Request modifySingleQueryResult = RequestBuilder.postRequestBuilder(url, obj, "createResultByURL");
        Call call = client.newCall(modifySingleQueryResult);
        Response response = call.execute();
        //System.out.println("createResultByURL: " + url + "/" + response.code());
        response.close();
        return obj;
    }
}
