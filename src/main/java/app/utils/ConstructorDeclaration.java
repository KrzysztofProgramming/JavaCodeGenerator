package app.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ConstructorDeclaration extends MethodOrConstructor{
    private String className;

    public ConstructorDeclaration(String modifier, Arguments arguments, String body){
        super(modifier, arguments, body);
    }

    public ConstructorDeclaration(String modifier, Arguments arguments, String body, String className) {
        super(modifier, arguments, body);
        this.className = className;
    }

    @Override
    public String toString() {
        return getModifier() + " " + getClassName() + "(" + getArguments() + "){\n" + getBody() + "\n}\n";
    }
}
