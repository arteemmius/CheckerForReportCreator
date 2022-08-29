package ru.vk.competition.minchecker.service.runs;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vk.competition.minchecker.dto.requests.TableQueryRequest;
import ru.vk.competition.minchecker.dto.results.SimpleResult;
import ru.vk.competition.minchecker.service.request.report.ReportCase;
import ru.vk.competition.minchecker.service.request.table.TableCase;
import ru.vk.competition.minchecker.service.request.table_query.TableQueryCase;
import ru.vk.competition.minchecker.service.result.CreateResult;

@Component
public class CustomCasesRun {
    @Autowired
    CreateResult createResult;
    @Autowired
    TableCase tableCase;
    @Autowired
    TableQueryCase tableQueryCase;
    @Autowired
    ReportCase reportCase;

    public void casesRun(OkHttpClient client, int tryNum) {
        try {
            SimpleResult createTableCorrect = createResult.createTableResult(client, 101, 201);
            tableCase.createTableRequestCorrect(client, createTableCorrect, "Customer1" + tryNum, "CustomerId"); // create table
            SimpleResult createTabletBad = createResult.createTableResult(client, 102, 406);
            tableCase.createTableRequestCorrect(client, createTabletBad, "Customer1" + tryNum, "CustomerId"); // repeat create
            tableCase.createTableRequestCorrect(client, createTabletBad, "CustomerFake", "FakeId"); // bad primary key
            tableCase.createTableRequestCorrect(client, createTabletBad, "Customer1" + tryNum, "CustomerId"); // repeat create
            tableCase.createTableRequestCorrect(client, createTabletBad, "CustomerFake", "FakeId"); // bad primary key
            tableCase.createTableRequestCorrect(client, createTabletBad, "Customer1" + tryNum, "CustomerId"); // repeat create
            tableCase.createTableRequestCorrect(client, createTabletBad, "CustomerFake", "FakeId"); // bad primary key
            //
            SimpleResult getTableCorrect = createResult.getTableResult(client, 103, 200);
            tableCase.getTableRequestCorrect(client, getTableCorrect, "Customer1" + tryNum); // exist table
            SimpleResult getTableBad = createResult.getTableResult(client, 104, 406); // ???
            tableCase.getTableRequestCorrect(client, getTableBad, "Customer2" + tryNum); // fictive table
            //
            SimpleResult deleteTableCorrect = createResult.deleteTableResult(client, 105, 201);
            tableCase.deleteTableRequestCorrect(client, deleteTableCorrect, "Customer1" + tryNum); // exist table
            SimpleResult deleteTableBad = createResult.deleteTableResult(client, 106, 406);
            tableCase.deleteTableRequestCorrect(client, deleteTableBad, "Customer2" + tryNum); // fictive table
            //
            tableCase.createTableRequestCorrect(client, createTableCorrect, "Customer1" + tryNum, "CustomerId"); // create
            SimpleResult addTableQueryCorrect = createResult.addTableQueryResult(client, 107, 201);
            tableQueryCase.addTableQueryRequestCorrect(client, addTableQueryCorrect,
                    new TableQueryRequest(1 + tryNum, "Customer1" + tryNum,
                    "CREATE TABLE Customer1" + tryNum + " (id INT NOT NULL);")); // valid
            tableQueryCase.addTableQueryRequestCorrect(client, addTableQueryCorrect,
                    new TableQueryRequest(2 + tryNum, "Customer1" + tryNum,
                    "ALTER TABLE Customer1" + tryNum + " RENAME TO CustomerNew1" + tryNum + ";")); // valid
            //
            SimpleResult addTableQueryBad = createResult.addTableQueryResult(client, 108, 406);
            tableQueryCase.addTableQueryRequestCorrect(client, addTableQueryBad,
                    new TableQueryRequest(3 + tryNum, "BadName" + tryNum,
                    "CREATE TABLE Customer1123 id INT NOT NULL);")); // fake table
            //
            SimpleResult executeTableQueryBad = createResult.executeTableQueryResult(client, 109, 406);
            tableQueryCase.executeTableQueryRequestCorrect(client, executeTableQueryBad, (1 + tryNum) + ""); // try repeat create
            //SimpleResult executeTableQueryCorrect = createResult.executeTableQueryResult(client, 110, 201);
            tableQueryCase.executeTableQueryRequestCorrect(client, executeTableQueryBad, (2 + tryNum) + ""); // rename table
            //
            SimpleResult getTableQueryCorrect = createResult.getTableQueryResult(client, 111, 200);
            tableQueryCase.getTableQueryRequestCorrect(client, getTableQueryCorrect, (1 + tryNum) + ""); // check after rename
            tableCase.deleteTableRequestCorrect(client, deleteTableCorrect, "CustomerNew1" + tryNum); // drop by new name
            SimpleResult getTableQueryBad = createResult.getTableQueryResult(client, 112, 500);
            tableQueryCase.getTableQueryRequestCorrect(client, getTableQueryBad, (1 + tryNum) + ""); // check after drop
            tableQueryCase.executeTableQueryRequestCorrect(client, executeTableQueryBad, (1 + tryNum) + ""); // try repeat create
            tableQueryCase.executeTableQueryRequestCorrect(client, executeTableQueryBad, (1 + tryNum) + ""); // try repeat create
            tableQueryCase.executeTableQueryRequestCorrect(client, executeTableQueryBad, (1 + tryNum) + ""); // try repeat create
            tableCase.deleteTableRequestCorrect(client, deleteTableBad, "Customer1" + tryNum); // try drop by old name
            //
            tableCase.createTableRequestCorrect(client, createTableCorrect, "Customer1" + tryNum, "CustomerId"); // create table
            SimpleResult createReportCorrect = createResult.addReportResult(client, 113, 201);
            reportCase.createReportRequest1(client, createReportCorrect, "Customer1" + tryNum, tryNum); // correct report
            SimpleResult createReportBad = createResult.addReportResult(client, 114, 406);
            reportCase.createReportRequest1(client, createReportBad, "Customer1" + tryNum, tryNum); // double
            reportCase.createReportRequest2(client, createReportBad, "Customer1" + tryNum, tryNum + 1); // not all fields
            reportCase.createReportRequest3(client, createReportBad, "Customer1" + tryNum, tryNum + 2); //bad field count
            reportCase.createReportRequest4(client, createReportBad, "Customer1" + tryNum, tryNum + 3); //bad field types
            reportCase.createReportRequest1(client, createReportBad, "FakeCustomer", tryNum + 4); // fake name
            //
            reportCase.createReportRequest1(client, createReportBad, "Customer1" + tryNum, tryNum); // double
            reportCase.createReportRequest2(client, createReportBad, "Customer1" + tryNum, tryNum + 5); // not all fields
            reportCase.createReportRequest3(client, createReportBad, "Customer1" + tryNum, tryNum + 6); //bad field count
            reportCase.createReportRequest4(client, createReportBad, "Customer1" + tryNum, tryNum + 7); //bad field types
            reportCase.createReportRequest1(client, createReportBad, "FakeCustomer", tryNum + 8); // fake name
            //
            reportCase.createReportRequest2(client, createReportBad, "Customer1" + tryNum, tryNum + 9); // not all fields
            reportCase.createReportRequest3(client, createReportBad, "Customer1" + tryNum, tryNum + 10); //bad field count
            //
            SimpleResult getReportCorrect = createResult.getReportResult(client, 115, 201);
            reportCase.getReportRequest(client, getReportCorrect, tryNum + "");
            SimpleResult getReportBad = createResult.getReportResult(client, 116, 406);
            reportCase.getReportRequest(client, getReportBad, "777");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
