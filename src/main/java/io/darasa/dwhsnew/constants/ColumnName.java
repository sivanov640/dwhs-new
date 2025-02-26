package io.darasa.dwhsnew.constants;

public class ColumnName {

    public static class Base {
        public static final String CREATED_AT = "created_at";
        public static final String UPDATED_AT = "updated_at";
    }

    public static class Round {
        public static final String ROUND_ID = "round_id";
        public static final String TABLE_ID = "table_id";
        public static final String GAME_ID = "game_id";
        public static final String GAME_NAME = "game_name";
        public static final String RESULT = "result";
        public static final String START_TIME = "start_time";
        public static final String END_TIME = "end_time";
    }

    public static class Ticket {
        public static final String TICKET_ID = "ticket_id";
        public static final String TABLE_ID = "table_id";
        public static final String GAME_ID = "game_id";
        public static final String GAME_NAME = "game_name";
        public static final String AGENCY_ID = "agency_id";
        public static final String ROUND_ID = "round_id";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String ACTION = "action";
        public static final String BET_AMOUNT = "bet_amount";
        public static final String MEMBER_ID = "member_id";
        public static final String PAYMENT_STATUS = "payment_status";
        public static final String BET_OPTION = "bet_option";
        public static final String DISPLAY_NAME = "display_name";
        public static final String CURRENCY = "currency";
        public static final String TYPE = "type";
        public static final String WIN_AMOUNT = "win_amount";
        public static final String GAME_YOUR_BET = "game_your_bet";
        public static final String STATUS = "status";
        public static final String AGENCY_CODE = "agency_code";
        public static final String AGENCY_CODE2 = "agency_code2";
        public static final String UID = "uid";
        public static final String UUID = "uuid";
        public static final String USERNAME = "username";
        public static final String USER_ID = "user_id";
    }

    public static class Transaction {
        public static final String GAME_ID = "game_id";
        public static final String TICKET_ID = "ticket_id";
        public static final String AGENCY_ID = "agency_id";
        public static final String MEMBER_ID = "member_id";
        public static final String REQUEST_JSON = "request_json";
        public static final String RESPONSE_JSON = "response_json";
    }

    public static class Dropped {
        public static final String DATA = "data";
    }
}
