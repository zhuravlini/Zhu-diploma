package ru.netology.data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class CardInfo {
        private String number;
        private String status;
    }

    public static CardInfo getApproved() {
        return new CardInfo("4444 4444 4444 4441", "APPROVED");
    }
    public static CardInfo getDeclined() {
        return new CardInfo("4444 4444 4444 4442", "DECLINED");
    }
}
