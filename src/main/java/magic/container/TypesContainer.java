package magic.container;

import java.io.IOException;
import java.io.InputStream;

import magic.types.TypeMagic;

public interface TypesContainer {
    String resolve(InputStream stream) throws IOException;
    <T extends TypeMagic> void register(T instance);
}
