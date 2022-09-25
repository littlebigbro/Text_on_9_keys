package ru.littlebigbro;

public enum TypeModeEnum {
    FIRST_UPPERCASE("Abc"),
    UPPERCASE("ABC"),
    LOWERCASE("abc"),
    ONLY_NUMBERS("123");

    private final String title;

    TypeModeEnum(String title) {
        this.title = title;
    }

    public static TypeModeEnum getName(String name) {
        for (TypeModeEnum e : TypeModeEnum.values()) {
            if (e.getTitle().equals(name)) {
                return e;
            }
        }
        return TypeModeEnum.FIRST_UPPERCASE;
    }

    public static boolean isOnlyNumberMode(String name) {
        return ONLY_NUMBERS.getTitle().equals(name);
    }

    public String getTitle() {
        return title;
    }
}
