public class MyTestingClass {
    private String name;

    public MyTestingClass(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {
        int hash = name.length() ^ (name.length() >>> 4);
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 37) ^ name.charAt(i);
        }
        return hash;
    }


}