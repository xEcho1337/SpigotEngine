package net.echo.spigotengine.commands.help;

import java.lang.reflect.Method;

public class HelpNode {
    private final Object parentClass;
    private final String[] names;
    private final String permission;
    private final Method method;

    public HelpNode(Object parentClass, String[] names, String permission, Method method) {
        this.parentClass = parentClass;
        this.names = names;
        this.permission = permission;
        this.method = method;
    }

    public Object getParentClass() {
        return this.parentClass;
    }

    public String[] getNames() {
        return this.names;
    }

    public String getPermission() {
        return this.permission;
    }

    public Method getMethod() {
        return this.method;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof HelpNode)) return false;
        final HelpNode other = (HelpNode) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$parentClass = this.getParentClass();
        final Object other$parentClass = other.getParentClass();
        if (this$parentClass == null ? other$parentClass != null : !this$parentClass.equals(other$parentClass))
            return false;
        if (!java.util.Arrays.deepEquals(this.getNames(), other.getNames())) return false;
        final Object this$permission = this.getPermission();
        final Object other$permission = other.getPermission();
        if (this$permission == null ? other$permission != null : !this$permission.equals(other$permission))
            return false;
        final Object this$method = this.getMethod();
        final Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HelpNode;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $parentClass = this.getParentClass();
        result = result * PRIME + ($parentClass == null ? 43 : $parentClass.hashCode());
        result = result * PRIME + java.util.Arrays.deepHashCode(this.getNames());
        final Object $permission = this.getPermission();
        result = result * PRIME + ($permission == null ? 43 : $permission.hashCode());
        final Object $method = this.getMethod();
        result = result * PRIME + ($method == null ? 43 : $method.hashCode());
        return result;
    }

    public String toString() {
        return "HelpNode(parentClass=" + this.getParentClass() + ", names=" + java.util.Arrays.deepToString(this.getNames()) + ", permission=" + this.getPermission() + ", method=" + this.getMethod() + ")";
    }
}
