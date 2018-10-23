package magic.types.image;

import java.io.IOException;
import java.io.InputStream;

import magic.types.TypeMagic;

public class JpegMagic implements TypeMagic {
    private final byte[] magic;
    
    public JpegMagic() {
        magic = new byte[] {
                (byte) 0xff,
                (byte) 0xd8,
                (byte) 0xff
        };
    }
    
    @Override
    public boolean test(InputStream in) throws IOException {
        return byIdentifyingCharacters(in, magic);
    }

    @Override
    public String getMime() {
        return "image/jpeg";
    }
    
}
