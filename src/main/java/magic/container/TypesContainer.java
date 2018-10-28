package magic.container;

import magic.types.Type;

public interface TypesContainer {
    Type findTypeByExtension(String extension);

    Type findTypeByMimeType(String mimeType);

}
