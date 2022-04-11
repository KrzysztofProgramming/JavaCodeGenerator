package app.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Fields {
    private List<FieldDeclaration> fieldDeclarations = new ArrayList<>();

    public Fields(FieldDeclaration... fieldDeclarations) {
        this.fieldDeclarations = Arrays.asList(fieldDeclarations);
    }

    @Override
    public String toString() {
        if(fieldDeclarations.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for(FieldDeclaration fieldDeclaration : fieldDeclarations){
            builder.append(fieldDeclaration).append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }
}
