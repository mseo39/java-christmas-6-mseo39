package exception;

public class InputValid {
    private InputValid() {

    }

    public static int stringToInteger(String input, String errorType) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 " + errorType + "입니다. 다시 입력해 주세요.");
            }
        }
        return Integer.parseInt(input);
    }
}
