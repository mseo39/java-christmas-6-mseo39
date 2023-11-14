package exception;

public class VisitDate {

    private static Integer DateStart = 1;
    private static Integer DateEnd = 31;

    private VisitDate() {

    }

    public static int checkDate(String input) {
        int date = InputValid.stringToInteger(input, "날짜");
        if (DateStart > date || DateEnd < date) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return date;
    }
}
