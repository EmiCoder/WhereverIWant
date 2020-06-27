package com.example.wherever_i_want;

import com.example.wherever_i_want.domain.Month;
import com.example.wherever_i_want.domain.Request;

public class Main {

    public static void main(String[] args) {

//        UserRequest userRequest = new UserRequest();
//        userRequest.setTemperature(23);
//        userRequest.setMonth(Month.APRIL);
//        userRequest.setCountryCode("DE");
//        List<UserRequest> list = new ArrayList<>();
//        list.add(userRequest);
//        list.add(userRequest);
//        for (UserRequest user : list) {
//            getMonthNameFromEnum(user);
//        }

    }

    private static void getMonthNameFromEnum(Request userRequest) {
        for (Month month : Month.values()) {
            if (month.equals(userRequest.getMonth())) {
                System.out.println(month.toString());
            }
        }
    }
}
