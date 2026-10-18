package org.pecheasoft.odigen.template;

public final class TemplateParameter {

    private final String name;
    private final Object value;

    public TemplateParameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public static TemplateParameter of(String name, Object value) {
        return new TemplateParameter(name, value);
    }

    public String name() {
        return name;
    }

    public Object value() {
        return value;
    }
}
