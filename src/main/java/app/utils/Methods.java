package app.utils;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Methods {
    private List<MethodDeclaration> methodDeclarations = new ArrayList<>();

    public Methods(MethodDeclaration... methodDeclarations) {
        this.methodDeclarations = Arrays.asList(methodDeclarations);
    }

    @Override
    public String toString() {
        if(methodDeclarations.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for(MethodDeclaration methodDeclaration : methodDeclarations){
            builder.append(methodDeclaration).append("\n");
        }
        return builder.toString();
    }
}
