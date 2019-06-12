package com.enums;

public enum Text {
    HELLO_WORLD("Hello World!"),
    HEY_WORLD("Hey World!"),
    IFRAME_RESULT("iframeResult"),
    AJAX("AJAX");

    private String text;

    Text(String text) { this.text = text; }

    public String getText() { return text; }
}
