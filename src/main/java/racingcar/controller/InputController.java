package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Racer;
import racingcar.view.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class InputController {

    public static ArrayList<String> setRacers() {
        String nameString;
        ArrayList<String> names;
        try {
            nameString = Input.carNameInput();
            names = (ArrayList<String>) Arrays.asList(nameString.split(","));

            // validation
            isRightNamesString(nameString);
            isRightNameSize(names);
            isNotDuplicate(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRacers();
        }
    }

    public static int setNumberOfRound() {
        String numberOfRound;

        try {
            numberOfRound = Input.roundNumberInput();
            // TODO: Round Number Validation 추가
            return Integer.parseInt(numberOfRound);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setNumberOfRound();
        }
    }

    public static void isRightNamesString(String nameString) {
        if (!Pattern.compile("^[가-힣\\w]+[가-힣\\w" + "," + "]*[가-힣\\w]$").matcher(nameString).matches()) {
            throw new IllegalArgumentException("자동차 목록은 쉼표로 구분된 비어있지 않은 문자여야 한다.");
        }
    }

    public static void isRightNameSize(ArrayList<String> names) {
        if (names.stream().anyMatch(name -> name.isEmpty() || name.length() > 5)) {
            throw new IllegalArgumentException("자동차 목록은 1자~5자의 문자로 구성되어야 한다.");
        }
    }

    public static void isNotDuplicate(ArrayList<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 목록은 중복이 없어야 한다.");
        }
    }

}
