package magic.types.application;

import java.io.IOException;
import java.io.InputStream;

import magic.types.TypeMagic;

public class JavaByteCodeMagic implements TypeMagic {
    private final byte[] magic;
    private final int length = 4;
    private final String mime = "application/java-byte-code";

    public JavaByteCodeMagic() {
        magic = new byte[] {
                (byte)0xCA,
                (byte)0xFE,
                (byte)0xBA,
                (byte)0xBE
        };
    }

    public String getMime() {
        return mime;
    }

    public boolean test(InputStream in) throws IOException {
        final byte[] bytes = new byte[length];
        in.read(bytes);
        return bytes.equals(magic);
    }

}
