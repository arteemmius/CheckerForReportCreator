package ru.vk.competition.minchecker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vk.competition.minchecker.service.runs.CustomCasesRun;
import ru.vk.competition.minchecker.service.runs.SingleQueryRun;

@Service
@Slf4j
@RequiredArgsConstructor
public class StartService {
    @Autowired
    SingleQueryRun singleQueryRun;
    @Autowired
    CustomCasesRun customCasesRun;

    OkHttpClient client = new OkHttpClient();

    private Integer counter = 0;

    public void onStartMission() {
        try {
            System.out.println("------ " + counter + " ------");
            customCasesRun.casesRun(client, 0);
            singleQueryRun.casesRun(client, 0);
            customCasesRun.casesRun(client, 100);
            System.out.println("---- END " + "(" + counter + ")\n");
            counter++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
