import java.io.File;
import java.util.ArrayList;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;
    private long limit;

    public Node(File folder, long limit) {
        this(folder);
        this.limit = limit;

    }
    public Node(File folder){
        this.folder = folder;
        children = new ArrayList<>();
    }
    public long setLimit(long limit){
        return limit;
    }

    public long getSize() {
        return size;
    }
    public String toString(){
//        String size = SizeCalculator.getHumanReadableSize(getSize());
        StringBuilder builder = new StringBuilder();

        String  size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + " - " + size +  "\n");


        for (Node child : children) {
            if(child.getSize() < limit){
                continue;
            }

            builder.append(" ".repeat(level + 1) + child.toString());

        }
        return builder.toString();
    }

    public void setSize(long size) {
        this.size = size;
    }

    public File getFolder(){
        return folder;
    }
    public void addChild(Node node){
        node.setLimit(limit);
        node.setLevel(level + 1);
        children.add(node);
    }
    private void setLevel(int level){
        this.level = level;
    }

    public ArrayList<Node> getChildren(){
        return children;
    }

}
