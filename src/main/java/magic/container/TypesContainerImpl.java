package magic.container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import magic.types.Type;

public class TypesContainerImpl implements TypesContainer {
    private List<Type> types;

    private TypesContainerImpl() {

    }

    private void setTypes(List<Type> types) {
        this.types = types;
    }

    @Override
    public Type findTypeByExtension(String extension) {
        for (Type t : types) {
            if (t.getExtension().equals(extension)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Type findTypeByMimeType(String mimeType) {
        for (Type t : types) {
            if (t.getMimeType().equals(mimeType)) {
                return t;
            }
        }
        return null;
    }

    public int longestMime() {
        int max = 0;
        for (Type t : types) {
            if (t.getMagic() != null && t.getMagic().length > max) {
                max = t.getMagic().length;
            }
        }
        return max;
    }

    private static TypesContainerImpl fromInputStream(InputStream stream)
            throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        List<Type> types = new LinkedList<>();
        try {
            String line = null;
            while ((line = reader.readLine()) != null) {
                types.add(Type.fromString(line));
            }
        } finally {
            reader.close();
        }

        TypesContainerImpl container = new TypesContainerImpl();
        container.setTypes(types);
        return container;
    }

    public static TypesContainer defaultContainer() throws IOException {
        return fromInputStream(
                TypesContainerImpl.class.getResourceAsStream("/data.txt"));
    }

}
