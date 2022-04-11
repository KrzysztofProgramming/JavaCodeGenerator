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
public class Constructors {
    private List<ConstructorDeclaration> constructorDeclarations = new ArrayList<>();

    public Constructors(ConstructorDeclaration... constructorDeclarations) {
        this.constructorDeclarations = Arrays.asList(constructorDeclarations);
    }

    @Override
    public String toString() {
        if(constructorDeclarations.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for(ConstructorDeclaration constructorDeclaration : constructorDeclarations){
            builder.append(constructorDeclaration.toString()).append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }
}
