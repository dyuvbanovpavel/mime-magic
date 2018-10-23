package magic.types.application;

import java.io.IOException;
import java.io.InputStream;

import magic.types.TypeMagic;

public class SevenZipMagic implements TypeMagic {
    private final byte[] magic; 
    
    public SevenZipMagic() {
        this.magic = new byte[] {
                (byte) 0x37,
                (byte) 0x7a,
                (byte) 0xbc,
                (byte) 0xaf,
                (byte) 0x27,
                (byte) 0x1c
        };        
    }
    
    public boolean test(InputStream in) throws IOException {
        return byIdentifyingCharacters(in, magic);
    }

    public String getMime() {
        return "application/x-7z-compressed";
    }

}
