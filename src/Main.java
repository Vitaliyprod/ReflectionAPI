import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        TestClass testClass = new TestClass();
        Class test = testClass.getClass();
//        Class test1 = TestClass.class;
//        Class test2 = Class.forName("TestClass");
//        TestClass test3 =(TestClass) test2.newInstance();

        // Модифікатор класу
        int classModifier = test.getModifiers();
        System.out.println("Class modifier: ");
        if (Modifier.isPublic(classModifier)) {
            System.out.println("public");
        }else if (Modifier.isAbstract(classModifier)){
            System.out.println("abstract");
        }else if (Modifier.isFinal(classModifier)){
            System.out.println("final");
        }
        line();

        //імя класу
        System.out.println("Class name: \n" + test.getName());
        line();

        //поля класу
        Field[] declaredFields = test.getDeclaredFields();
        System.out.println("Сlass fields: ");
        for (Field field :declaredFields) {
            System.out.println(field);
        }
        line();

        //конструктори
        Constructor [] declaredConstructors = test.getDeclaredConstructors();
        System.out.println("Class constructors: ");
        for (Constructor constructor: declaredConstructors){
            System.out.print("\n");
            System.out.println("Constructor name: " + constructor.getName());
            int constructorModifiers = constructor.getModifiers();
            System.out.println("Constructor modifier: " +Modifier.toString(constructorModifiers));
            Parameter [] parameters = constructor.getParameters();
            System.out.println("Parameters: ");
            for (Parameter parameter: parameters) {
                System.out.println(parameter.getName());
                Class<?> type = parameter.getType();
                System.out.println(type.getName());
            }
        }
        line();

        //методи
        Method[] declaredMethods = test.getDeclaredMethods();
        System.out.println("Class methods: ");
        for (Method method: declaredMethods){
            System.out.print("\n");
            System.out.println("Method name: " + method.getName());
            int constructorModifiers = method.getModifiers();
            System.out.println("Method modifier: " + Modifier.toString(constructorModifiers));
            Parameter [] parameters = method.getParameters();
            System.out.println("Parameters: ");
            for (Parameter parameter: parameters) {
                System.out.println(parameter.getName());
                Class<?> type = parameter.getType();
                System.out.println(type.getName());
                Class<?> returnType = method.getReturnType();
                System.out.println("Return type:" + returnType.getName());
            }
        }
        line();

        //аннотація
        Annotation[] declaredAnnotations = test.getDeclaredAnnotations();
        System.out.println("Class annotations: ");
        for(Annotation annotation : declaredAnnotations){
            System.out.print("\n");
            System.out.println(annotation);
        }
    }

    public static void line(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
