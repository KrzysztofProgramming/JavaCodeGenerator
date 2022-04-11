package app.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class FieldDeclaration {
    private String modifier;
    private String type;
    private String name;
    private boolean staticModifier = false;
    private boolean finalModifier = false;

    @Override
    public String toString() {
        return getModifier() + (finalModifier ? " final" : "") + (staticModifier ? " static" : "") + " " + getType()
                + " " + getName() + ";";
    }
}
