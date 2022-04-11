package app.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;


@Getter
@Setter
@Accessors(chain = true)
public class ClassDeclaration {
    private String packageName;
    private List<String> imports;
    private String className;
    private Fields fields;
    private Constructors constructors;
    private Methods methods;

    public ClassDeclaration(String packageName, List<String> imports, String className, Fields fields, Constructors constructors, Methods methods) {
        this.packageName = packageName == null ? "" : packageName;
        this.imports = imports;
        this.className = className;
        this.fields = fields;
        this.constructors = constructors;
        this.methods = methods;
        this.constructors.getConstructorDeclarations().forEach(constructorDeclaration -> constructorDeclaration.setClassName(className));
    }

    private ClassDeclaration addConstructor(ConstructorDeclaration constructorDeclaration){
        constructorDeclaration.setClassName(this.className);
        this.constructors.getConstructorDeclarations().add(constructorDeclaration);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getPackageName().isEmpty() ? "" : "package ").append(packageName).append(";\n\n").append(generateImportsString()).append("public")
                .append(" class ").append(className).append("{\n").append(fields).append(constructors).append(methods)
                .append("}");
        return formatCode(builder.toString());
    }

    private String generateImportsString(){
        StringBuilder builder = new StringBuilder();
        for(String imp: imports){
            builder.append("import ").append(imp).append(";").append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }

    private static String formatCode(String toFormat){
        int counter = 0 ;
        boolean ignore = false;
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<toFormat.length(); i++){
            builder.append(toFormat.charAt(i));

            if(toFormat.charAt(i) == '"')
                ignore = !ignore;

            if(toFormat.charAt(i) == '{' && !ignore)
                counter++;
            else if(i + 1 <toFormat.length() && toFormat.charAt(i + 1) == '}' && !ignore)
                counter--;

            if(toFormat.charAt(i)=='\n'){
                for(int j=0; j<counter; j++){
                    builder.append("\t");
                }
            }
        }
        return builder.toString();
    }
}
