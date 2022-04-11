package app.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;



@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MethodDeclaration extends MethodOrConstructor {
    private String returnedType;
    private String name;
    private boolean staticModifier = false;

    public MethodDeclaration(String modifier, String returnedType, String name, boolean staticModifier, Arguments arguments, String body) {
        super(modifier, arguments, body);
        this.returnedType = returnedType;
        this.name = name;
        this.staticModifier = staticModifier;
    }

    @Override
    public String toString() {
        return getModifier() + (staticModifier ? " static" : "") + " " + getReturnedType() + " " + getName() + "(" +
                getArguments() + "){\n" + getBody() + "\n}\n";
    }
}
