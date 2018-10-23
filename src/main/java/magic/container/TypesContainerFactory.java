package magic.container;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import magic.types.application.JavaByteCodeMagic;
import magic.types.application.SevenZipMagic;
import magic.types.application.XmlMagic;
import magic.types.image.JpegMagic;


public class TypesContainerFactory {
    final private Logger log = LogManager.getLogger(this.getClass());

    public TypesContainer simple() {
        final TypesContainer container = new TypesContainerImpl();

        container.register(new XmlMagic());
        container.register(new JavaByteCodeMagic());
        container.register(new SevenZipMagic());
        container.register(new JpegMagic());

        return container;
    }
}
