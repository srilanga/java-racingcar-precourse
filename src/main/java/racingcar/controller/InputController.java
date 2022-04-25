package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Racer;
import racingcar.view.Input;

import java.util.ArrayList;
import java.util.Arrays;

public class InputController {

    public static ArrayList<String> setRacers() {
        String name;
        ArrayList<String> names;

        try {
            name = Input.carNameInput();
            // TODO: Car Name Validation 추가

            names = (ArrayList<String>) Arrays.asList(name.split(","));
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

}
