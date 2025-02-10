package common.util;

public class AnswerSoket {
    String answerType;          //Success, Error, 추가페이지 요청 등 존재
    int input;
    public AnswerSoket(String answerType, int input){
        this.answerType = answerType;
        this.input = input;
    }
}
