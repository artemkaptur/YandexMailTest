package com.epam.yandexmail.constants;

public class YandexMailConstants {

    private YandexMailConstants() {
    }

    public static class Driver {

        public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

        public static final String WEBDRIVER_CHROMDRIVER_EXE_PATH = "D:\\webdrivers\\chromedriver\\chromedriver.exe";

    }

    public static class Url {

        public static final String LOGIN_PAGE_BASE_URL = "https://passport.yandex.by/";

        public static final String YANDEX_SEARCH_PAGE_BASE_URL = "https://yandex.by/";

    }

    public static class Authorization {

        public static final String LOGIN = "testusertes";

        public static final String PASSWORD = "test1234test";

    }

    public static class ExpressionsForMatching {

        public static final String DRAFT_DIRECTORY_TITLE = "Черновики — Яндекс.Почта";

        public static final String LOGOUT_URL = "https://passport.yandex.by/";

        public static final String RECEIVER_CHECK = "artsiomkaptur";

        public static final String YANDEX_LOGO_TEXT = "Яндекс";

    }

    public static class WritingMessage {

        public static final String RECEIVER = "artsiomkaptur@gmail.com";

        public static final String SUBJECT = "Yandex mail test";

        public static final String MESSAGE = "Hi, buddy, how is it going?";

        public static final String LINK = "https://github.com/artemkaptur";

        public static final String LINK_MESSAGE = "mygithub";

    }
}
