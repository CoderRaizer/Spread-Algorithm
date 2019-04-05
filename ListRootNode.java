package spread_algorithm;

import java.util.LinkedList;

public class ListRootNode {
    LinkedList<Node> listRoot;

    public ListRootNode(){
        listRoot = new LinkedList<>();
    }

    public void addNodeToList(Node x){
        listRoot.addLast(x);
    }

    public LinkedList<Node> getListRoot() {
        return listRoot;
    }

    public void setListRoot(LinkedList<Node> listRoot) {
        this.listRoot = listRoot;
    }

    public void display(){
        for (Node x: listRoot) {
            if(x.getRecipe() == true){
                System.out.print("\n");
            }
            System.out.print(x.toString());
        }
    }
}
