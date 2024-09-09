package net.echo.summer.commands.node;

import java.lang.reflect.Parameter;

public class ArgumentNode {
    // Argument information
    private final String name;
    private final boolean concated;
    private final boolean required;

    private final String defaultValue;

    // Reflection information
    private final Parameter parameter;

    public ArgumentNode(String name, boolean concated, boolean required, String defaultValue, Parameter parameter) {
        this.name = name;
        this.concated = concated;
        this.required = required;
        this.defaultValue = defaultValue;
        this.parameter = parameter;
    }

    public String getName() {
        return this.name;
    }

    public boolean isConcated() {
        return this.concated;
    }

    public boolean isRequired() {
        return this.required;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public Parameter getParameter() {
        return this.parameter;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ArgumentNode)) return false;
        final ArgumentNode other = (ArgumentNode) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.isConcated() != other.isConcated()) return false;
        if (this.isRequired() != other.isRequired()) return false;
        final Object this$defaultValue = this.getDefaultValue();
        final Object other$defaultValue = other.getDefaultValue();
        if (this$defaultValue == null ? other$defaultValue != null : !this$defaultValue.equals(other$defaultValue))
            return false;
        final Object this$parameter = this.getParameter();
        final Object other$parameter = other.getParameter();
        if (this$parameter == null ? other$parameter != null : !this$parameter.equals(other$parameter)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ArgumentNode;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + (this.isConcated() ? 79 : 97);
        result = result * PRIME + (this.isRequired() ? 79 : 97);
        final Object $defaultValue = this.getDefaultValue();
        result = result * PRIME + ($defaultValue == null ? 43 : $defaultValue.hashCode());
        final Object $parameter = this.getParameter();
        result = result * PRIME + ($parameter == null ? 43 : $parameter.hashCode());
        return result;
    }

    public String toString() {
        return "ArgumentNode(name=" + this.getName() + ", concated=" + this.isConcated() + ", required=" + this.isRequired() + ", defaultValue=" + this.getDefaultValue() + ", parameter=" + this.getParameter() + ")";
    }
}
