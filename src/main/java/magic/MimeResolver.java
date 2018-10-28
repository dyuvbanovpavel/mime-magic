package magic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import magic.container.TypesContainer;
import magic.types.Type;

public class MimeResolver {
    private TypesContainer container;
    
    public MimeResolver(TypesContainer container) {
        this.container = container;
    }

    public MimeResolverResult confirmMimeType(File file, String mime) {
        Type type = container.findTypeByMimeType(mime);
        if (type == null) {
            return MimeResolverResult.MIME_NOT_FOUND;
        }
        
        
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            boolean result = check(is, type);
            if (result) {
                return MimeResolverResult.MIME_CONFIRMED;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return MimeResolverResult.MIME_DENIED;
    } 
    
    private boolean check(InputStream is, Type t) throws IOException {
        int[] magic = t.getMagic();
        byte[] bytes = new byte[magic.length];
        is.read(bytes);
        
        for (int i = 0; i < magic.length; i++) {
            if ((byte)magic[i] != bytes[i]) {
                return false;
            }
        }
        
        return true;
    }
}
