package magic.types;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public interface TypeMagic {
    boolean test(InputStream in) throws IOException;

    String getMime();

    default boolean byIdentifyingCharacters(InputStream stream, byte[] magic) throws IOException {
        byte[] bytes = new byte[magic.length];
        stream.read(bytes);
        return Arrays.equals(bytes, magic);
    }
}
