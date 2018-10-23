package magic.types.application;

import java.io.IOException;
import java.io.InputStream;

import magic.types.TypeMagic;

public class XmlMagic implements TypeMagic {
    private final String magicString = "<?xml";

    public XmlMagic() {
    }

    public String getMime() {
        return "application/xml";
    }

    public boolean test(InputStream in) throws IOException {
        return byIdentifyingCharacters(in, magicString.getBytes());
    }

}
