package ru.vk.competition.minchecker.service.request.single_query;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import ru.vk.competition.minchecker.dto.requests.SingleQueryRequest;
import ru.vk.competition.minchecker.dto.results.SimpleResult;
import ru.vk.competition.minchecker.service.utils.Constants;
import ru.vk.competition.minchecker.utils.RequestBuilder;
import ru.vk.competition.minchecker.utils.Urls;

import java.io.IOException;

@Component
public class SingleQueryCase {
    // add-new-query
    public void createAddNewSingleQueryRequestEmptyBody(OkHttpClient client, SimpleResult simpleResult) throws IOException { //why 201?
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.ADD_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.postRequestBuilder(url.toString(), new SingleQueryRequest(), "createAddNewSingleQueryRequestEmptyBody");
        Response response = client.newCall(request).execute();
        System.out.println("createAddNewSingleQueryRequestEmptyBody|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createAddNewSingleQueryRequestBadId(OkHttpClient client, SimpleResult simpleResult) throws IOException { // code 400 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.ADD_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest = new SingleQueryRequest("a", "");
        Request request = RequestBuilder.postRequestBuilder(url.toString(), singleQueryRequest, "createAddNewSingleQueryRequestBadId");
        Response response = client.newCall(request).execute();
        System.out.println("createAddNewSingleQueryRequestBadId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createAddNewSingleQueryRequestGoodIds(OkHttpClient client, SimpleResult simpleResult, int tryNum) throws IOException { // code 201 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.ADD_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest1 = new SingleQueryRequest(1 + tryNum, "select * from unknown;");
        Request request1 = RequestBuilder.postRequestBuilder(url.toString(), singleQueryRequest1, "createAddNewSingleQueryRequestGoodIds");
        Response response1 = client.newCall(request1).execute();
        System.out.println("createAddNewSingleQueryRequestGoodIds|" + simpleResult.getCode() + "|" + response1.code());
        response1.close();
        //
        SingleQueryRequest singleQueryRequest2 = new SingleQueryRequest(2 + tryNum, "fuuuuuuuuuuuuu");
        Request request2 = RequestBuilder.postRequestBuilder(url.toString(), singleQueryRequest2, "createAddNewSingleQueryRequestGoodIds");
        Response response2 = client.newCall(request2).execute();
        System.out.println("createAddNewSingleQueryRequestGoodIds|" + simpleResult.getCode() + "|" + response2.code());
        response2.close();
        //
        SingleQueryRequest singleQueryRequest3 = new SingleQueryRequest(3 + tryNum, "select * from single_query;");
        Request request3 = RequestBuilder.postRequestBuilder(url.toString(), singleQueryRequest3, "createAddNewSingleQueryRequestGoodIds");
        Response response3 = client.newCall(request3).execute();
        System.out.println("createAddNewSingleQueryRequestGoodIds|" + simpleResult.getCode() + "|" + response3.code());
        response3.close();
    }

    public void createAddNewSingleQueryRequestBadMethod(OkHttpClient client, SimpleResult simpleResult) throws IOException { // code 400 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.ADD_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest = new SingleQueryRequest(1, "");
        Request request = RequestBuilder.deleteRequestBuilder(url.toString(), singleQueryRequest, "createAddNewSingleQueryRequestBadMethod");
        Response response = client.newCall(request).execute();
        System.out.println("createAddNewSingleQueryRequestBadMethod|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createAddNewSingleQueryRequestBigQuery(OkHttpClient client, SimpleResult simpleResult) throws IOException { // code 400 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.ADD_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest = new SingleQueryRequest(2,
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"
        + "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"
        + "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"
        + "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"
        + "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        Request request = RequestBuilder.postRequestBuilder(url.toString(), singleQueryRequest, "createAddNewSingleQueryRequestBigQuery");
        Response response = client.newCall(request).execute();
        System.out.println("createAddNewSingleQueryRequestBigQuery|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createAddNewSingleQueryRequestBigId(OkHttpClient client, SimpleResult simpleResult) throws IOException { // code 400 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.ADD_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest = new SingleQueryRequest(1000000000000000000L, "select * from unknown;");
        Request request = RequestBuilder.postRequestBuilder(url.toString(), singleQueryRequest, "createAddNewSingleQueryRequestBigId");
        Response response = client.newCall(request).execute();
        System.out.println("createAddNewSingleQueryRequestBigId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    // modify-single-query
    public void createModifySingleQueryRequestCorrect(OkHttpClient client, SimpleResult simpleResult, int tryNum) throws IOException { // code 400 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.MODIFY_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest = new SingleQueryRequest(3 + tryNum, "select * from single_query;");
        Request request = RequestBuilder.putRequestBuilder(url.toString(), singleQueryRequest, "createModifySingleQueryRequestCorrect");
        Response response = client.newCall(request).execute();
        System.out.println("createModifySingleQueryRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createModifySingleQueryRequestBadMethod(OkHttpClient client, SimpleResult simpleResult) throws IOException { // code 400 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.MODIFY_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest = new SingleQueryRequest(1, "");
        Request request = RequestBuilder.deleteRequestBuilder(url.toString(), singleQueryRequest, "createModifySingleQueryRequestBadMethod");
        Response response = client.newCall(request).execute();
        System.out.println("createModifySingleQueryRequestBadMethod|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createModifySingleQueryRequestNotFoundId(OkHttpClient client, SimpleResult simpleResult) throws IOException { // code 400 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.MODIFY_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest = new SingleQueryRequest(10_000, "some query");
        Request request = RequestBuilder.putRequestBuilder(url.toString(), singleQueryRequest, "createModifySingleQueryRequestNotFoundId");
        Response response = client.newCall(request).execute();
        System.out.println("createModifySingleQueryRequestNotFoundId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createModifySingleQueryRequestBadId(OkHttpClient client, SimpleResult simpleResult) throws IOException { // code 400 expect
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.MODIFY_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        SingleQueryRequest singleQueryRequest = new SingleQueryRequest(1000000000000000000L, "some query");
        Request request = RequestBuilder.putRequestBuilder(url.toString(), singleQueryRequest, "createModifySingleQueryRequestBadId");
        Response response = client.newCall(request).execute();
        System.out.println("createModifySingleQueryRequestBadId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createModifySingleQueryRequestEmptyBody(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.MODIFY_SINGLE_QUERY).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.putRequestBuilder(url.toString(), new SingleQueryRequest(), "createModifySingleQueryRequestEmptyBody");
        Response response = client.newCall(request).execute();
        System.out.println("createModifySingleQueryRequestEmptyBody|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    // delete-single-query-by-id
    public void createDeleteSingleQueryRequestCorrect(OkHttpClient client, SimpleResult simpleResult, int tryNum) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.DELETE_SINGLE_QUERY_BY_ID + "/" + (3 + tryNum)).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.deleteRequestBuilder(url.toString(), null, "createDeleteSingleQueryRequestCorrect");
        Response response = client.newCall(request).execute();
        System.out.println("createDeleteSingleQueryRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createDeleteSingleQueryRequestBadId(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.DELETE_SINGLE_QUERY_BY_ID + "/1000000000000000000").newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.deleteRequestBuilder(url.toString(), null, "createDeleteSingleQueryRequestBadId");
        Response response = client.newCall(request).execute();
        System.out.println("createDeleteSingleQueryRequestBadId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createDeleteSingleQueryRequestBadMethod(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.DELETE_SINGLE_QUERY_BY_ID + "/1").newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.putRequestBuilder(url.toString(), new SingleQueryRequest(100, "some query"), "createDeleteSingleQueryRequestBadMethod");
        Response response = client.newCall(request).execute();
        System.out.println("createDeleteSingleQueryRequestBadMethod|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createDeleteSingleQueryRequestNotFoundId(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.DELETE_SINGLE_QUERY_BY_ID + "/10000").newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.deleteRequestBuilder(url.toString(), null, "createDeleteSingleQueryRequestNotFoundId");
        Response response = client.newCall(request).execute();
        System.out.println("createDeleteSingleQueryRequestNotFoundId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createDeleteSingleQueryRequestEmptyBody(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.DELETE_SINGLE_QUERY_BY_ID).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        Request request = RequestBuilder.deleteRequestBuilder(url.toString(), null, "createDeleteSingleQueryRequestEmptyBody");
        Response response = client.newCall(request).execute();
        System.out.println("createDeleteSingleQueryRequestEmptyBody|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    // execute-single-query-by-id
    public void createExecuteSingleQueryRequestBadInput1(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.EXECUTE_SINGLE_QUERY_BY_ID + "/1").newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createExecuteSingleQueryRequestBadInput1: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createExecuteSingleQueryRequestBadInput1|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createExecuteSingleQueryRequestBadInput2(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.EXECUTE_SINGLE_QUERY_BY_ID + "/2").newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createExecuteSingleQueryRequestBadInput2: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createExecuteSingleQueryRequestBadInput2|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createExecuteSingleQueryRequestCorrect(OkHttpClient client, SimpleResult simpleResult, int tryNum) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.EXECUTE_SINGLE_QUERY_BY_ID + "/" + (3 + tryNum)).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createExecuteSingleQueryRequestCorrect: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createExecuteSingleQueryRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createExecuteSingleQueryRequestBadId(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.EXECUTE_SINGLE_QUERY_BY_ID + "/1000000000000000000").newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createExecuteSingleQueryRequestBadId: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createExecuteSingleQueryRequestBadId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createExecuteSingleQueryRequestEmptyBody(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.EXECUTE_SINGLE_QUERY_BY_ID).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createExecuteSingleQueryRequestEmptyBody: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createExecuteSingleQueryRequestEmptyBody|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    // get-single-query-by-id
    public void createGetSingleQueryRequestCorrect(OkHttpClient client, SimpleResult simpleResult, int tryNum) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.GET_SINGLE_QUERY_BY_ID + "/" + (1 + tryNum)).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createGetSingleQueryRequestCorrect: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createGetSingleQueryRequestCorrect|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createGetSingleQueryRequestNotFoundId(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.GET_SINGLE_QUERY_BY_ID + "/100").newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createGetSingleQueryRequestNotFoundId: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createGetSingleQueryRequestNotFoundId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createGetSingleQueryRequestBadId(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.GET_SINGLE_QUERY_BY_ID + "/1000000000000000000").newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createGetSingleQueryRequestBadId: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createGetSingleQueryRequestBadId|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }

    public void createGetSingleQueryRequestEmptyBody(OkHttpClient client, SimpleResult simpleResult) throws IOException {
        HttpUrl url = HttpUrl.parse(RequestBuilder.API_ROOT + Urls.GET_SINGLE_QUERY_BY_ID).newBuilder()
                .addQueryParameter(Constants.RESULT_ID, simpleResult.getResultId() + "")
                .build();
        System.out.println("createGetSingleQueryRequestEmptyBody: url=" + url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("createGetSingleQueryRequestEmptyBody|" + simpleResult.getCode() + "|" + response.code());
        response.close();
    }
}
