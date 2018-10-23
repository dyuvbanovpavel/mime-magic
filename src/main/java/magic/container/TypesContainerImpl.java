package magic.container;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import magic.types.TypeMagic;

public class TypesContainerImpl implements TypesContainer {
    private List<TypeMagic> list;

    public String resolve(InputStream stream) throws IOException {
        byte[] bytes = new byte[1024];
        stream.read(bytes);

        final ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        String result = null;
        for (TypeMagic magic : list) {
            if (magic.test(bis)) {
                result = magic.getMime();
            }
            bis.reset();
        }
        return result;
    }

    protected TypesContainerImpl() {
        list = new LinkedList<TypeMagic>();
    }

    public <T extends TypeMagic> void register(T instance) {
        list.add(instance);
    }

}
