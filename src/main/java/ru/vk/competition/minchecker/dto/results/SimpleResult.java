package ru.vk.competition.minchecker.dto.results;

public class SimpleResult {
    private Integer resultId;
    private Integer code;

    public SimpleResult(Integer resultId, Integer code) {
        this.resultId = resultId;
        this.code = code;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SingleQueryResult{" +
                "resultId=" + resultId +
                ", code=" + code +
                '}';
    }
}
