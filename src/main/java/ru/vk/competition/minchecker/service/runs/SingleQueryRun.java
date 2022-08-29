package ru.vk.competition.minchecker.service.runs;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vk.competition.minchecker.dto.results.SimpleResult;
import ru.vk.competition.minchecker.service.request.single_query.SingleQueryCase;
import ru.vk.competition.minchecker.service.result.CreateResult;

@Component
public class SingleQueryRun {
    @Autowired
    CreateResult createResult;
    @Autowired
    SingleQueryCase singleQueryCase;

    public void casesRun(OkHttpClient client, int tryNum) {
        try {
            // single-query start:
            // -> singleQueryResultGood
            SimpleResult addNewQueryResultBad = createResult.createAddNewQueryResult(client, 2, 403);
            singleQueryCase.createAddNewSingleQueryRequestEmptyBody(client, addNewQueryResultBad);
            singleQueryCase.createAddNewSingleQueryRequestEmptyBody(client, addNewQueryResultBad);
            singleQueryCase.createAddNewSingleQueryRequestEmptyBody(client, addNewQueryResultBad);
            singleQueryCase.createAddNewSingleQueryRequestEmptyBody(client, addNewQueryResultBad);
            singleQueryCase.createAddNewSingleQueryRequestEmptyBody(client, addNewQueryResultBad);
            SimpleResult addNewQueryResultGood = createResult.createAddNewQueryResult(client, 1, 201);
            singleQueryCase.createAddNewSingleQueryRequestGoodIds(client, addNewQueryResultGood, tryNum);
            //
            SimpleResult executeSimpleResultGood = createResult.createExecuteSingleQueryResult(client, 6, 201);
            singleQueryCase.createExecuteSingleQueryRequestCorrect(client, executeSimpleResultGood, tryNum);
            //
            SimpleResult getSimpleResultGood = createResult.createGetSingleQueryResult(client, 8, 200);
            singleQueryCase.createGetSingleQueryRequestCorrect(client, getSimpleResultGood, tryNum);
            //
            SimpleResult modifySimpleResultGood = createResult.createModifySingleQueryResult(client, 9, 200);
            singleQueryCase.createModifySingleQueryRequestCorrect(client, modifySimpleResultGood, tryNum);
            //
            SimpleResult deleteSimpleResultGood = createResult.createDeleteSingleQueryResult(client, 10, 202);
            singleQueryCase.createDeleteSingleQueryRequestCorrect(client, deleteSimpleResultGood, tryNum);
            // -> singleQueryResultBad
            //singleQueryCase.createAddNewSingleQueryRequestBadId(client, addNewQueryResultBad);
            singleQueryCase.createAddNewSingleQueryRequestBigQuery(client, addNewQueryResultBad);
            //singleQueryCase.createAddNewSingleQueryRequestBigId(client, addNewQueryResultBad);
            //SimpleResult addNewQueryResultMethod = createResult.createAddNewQueryResult(client, 11, 405);
            //singleQueryCase.createAddNewSingleQueryRequestBadMethod(client, addNewQueryResultMethod);
            //
            SimpleResult modifySimpleResultBad = createResult.createModifySingleQueryResult(client, 3, 406);
            singleQueryCase.createModifySingleQueryRequestNotFoundId(client, modifySimpleResultBad);
            singleQueryCase.createModifySingleQueryRequestEmptyBody(client, modifySimpleResultBad);
            //SimpleResult modifySimpleResultBadMethod = createResult.createModifySingleQueryResult(client, 12, 405);
            //singleQueryCase.createModifySingleQueryRequestBadMethod(client, modifySimpleResultBadMethod);
            //singleQueryCase.createModifySingleQueryRequestBadId(client, modifySimpleResultBad);
            //
            SimpleResult deleteSimpleResultBad = createResult.createDeleteSingleQueryResult(client, 4, 406);
            singleQueryCase.createDeleteSingleQueryRequestNotFoundId(client, deleteSimpleResultBad);
            singleQueryCase.createDeleteSingleQueryRequestEmptyBody(client, deleteSimpleResultBad);
            //singleQueryCase.createDeleteSingleQueryRequestBadId(client, deleteSimpleResultBad);
            //SimpleResult deleteSimpleResultBadMethod = createResult.createDeleteSingleQueryResult(client, 13, 405);
            //singleQueryCase.createDeleteSingleQueryRequestBadMethod(client, deleteSimpleResultBadMethod);
            //
            SimpleResult executeSimpleResultBad = createResult.createExecuteSingleQueryResult(client, 5, 406);
            //singleQueryCase.createExecuteSingleQueryRequestBadId(client, executeSimpleResultBad);
            singleQueryCase.createExecuteSingleQueryRequestBadInput1(client, executeSimpleResultBad);
            singleQueryCase.createExecuteSingleQueryRequestBadInput2(client, executeSimpleResultBad);
            singleQueryCase.createExecuteSingleQueryRequestEmptyBody(client, executeSimpleResultBad);
            //
            SimpleResult getSimpleResultBad = createResult.createGetSingleQueryResult(client, 7, 500);
            //singleQueryCase.createGetSingleQueryRequestBadId(client, getSimpleResultBad);
            singleQueryCase.createGetSingleQueryRequestNotFoundId(client, getSimpleResultBad);
            singleQueryCase.createGetSingleQueryRequestEmptyBody(client, getSimpleResultBad);
            // single-query end.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
