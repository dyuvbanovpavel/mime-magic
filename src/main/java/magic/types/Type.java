package magic.types;

public class Type {
    private String extension;
    private String mimeType;
    private int[] magic;

    public Type(String extension, String mimeType, int[] magic) {
        super();
        this.extension = extension;
        this.mimeType = mimeType;
        this.magic = magic;
    }

    public String getExtension() {
        return extension;
    }

    public String getMimeType() {
        return mimeType;
    }

    public int[] getMagic() {
        return magic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(extension).append(",").append(mimeType)
                .append(",");

        if (magic != null) {
            sb.append("[");
            for (int i = 0; i < magic.length; i++) {
                sb.append(Integer.toHexString(magic[i]));
                if (i != magic.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("]");
        } else {
            sb.append("null");
        }

        sb.append("}");
        return sb.toString();
    }

    public static Type fromString(String typeString) {
        String unwraped = typeString.substring(1, typeString.length() - 1);
        String[] split = unwraped.split(",");

        String extension = split[0];
        String mimeType = split[1];
        int[] magic = null;

        if (!split[2].equals("null")) {
            String unwrapedCodes = split[2].substring(1, split[2].length() - 1);
            String[] codes = unwrapedCodes.split("\\s+");

            magic = new int[codes.length];
            for (int i = 0; i < magic.length; i++) {
                magic[i] = Integer.parseUnsignedInt(codes[i], 16);
            }
        }

        return new Type(extension, mimeType, magic);
    }
}
