package magic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import magic.container.TypesContainer;
import magic.container.TypesContainerFactory;

public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        TypesContainerFactory f = new TypesContainerFactory();
        TypesContainer container = f.simple();
        String result = container.resolve(new FileInputStream(args[0]));
        System.out.println(result);
       

    }
}
