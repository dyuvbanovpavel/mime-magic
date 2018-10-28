package magic;

import java.io.File;
import java.io.IOException;

import magic.container.TypesContainerImpl;

public class App {
    public static void main(String[] args) throws IOException {
       MimeResolver r = new MimeResolver(TypesContainerImpl.defaultContainer());
       System.out.println(r.confirmMimeType(new File("test.7z"), "application/x-7z-compressed"));
    }
}
