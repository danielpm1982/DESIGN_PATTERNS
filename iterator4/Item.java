package iterator4;

public class Item implements ItemInterface,Comparable<Item>{
    private final String description;
    private final String name;
    private final int code;
    public Item() {
        this("no description!");
    }
    public Item(String description) {
        this(-1,null,description);
    }    
    public Item(int code, String name, String description) {
        if(code!=-1 && name!=null){
            this.code=code;
            this.name=name;
        } else{
            this.code=this.getHashCode();
            this.name=this.getClassName();
        }
        this.description=description;
    }
    @Override
    public String getDescription() {
        return String.format("%-19s %-4s %-13s %-4s %s", "code: "+this.code+";", "┋┋","name: "+this.name+";","┋┋","description: "+this.description);
    }
    public int getCode() {
        return code;
    }
    @Override
    public int compareTo(Item i) {
        return this.code-i.getCode();
    }
    @Override
    public String toString() {
        return getDescription();
    }
}
