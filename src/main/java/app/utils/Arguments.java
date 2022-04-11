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
public class Arguments {
    private List<ArgumentDeclaration> argumentDeclarations = new ArrayList<>();

    public Arguments(ArgumentDeclaration... argumentDeclarations) {
        this.argumentDeclarations = Arrays.asList(argumentDeclarations);
    }

    @Override
    public String toString() {
        if(argumentDeclarations.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< argumentDeclarations.size(); i++) {
            if(i!=0)
                builder.append(", ");
            builder.append(argumentDeclarations.get(i));
        }
        return builder.toString();
    }
}
