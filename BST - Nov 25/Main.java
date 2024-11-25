public class Main {
    static class Node{
        int key;
        Node left,right;
        public  Node(int val){
            this.key = val;
            this.left=null;
            this.right=null;
        }
    }
    public static Node insert(Node root , int val){
        if(root==null){
            return new Node(val);
        }
        if(root.key==val){
            return root;
        }
        if(val<root.key){
            root.left=insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static Node search(Node root ,int  val){
        if(root==null || root.key==val){
            return root;
        }
        if(root.key<val){
            return search(root.right,val);
        }else{
            return search(root.left,val);
        }
    }
    public static Node delete(Node root , int val){
        if(root==null){
            return root;
        }else if(root.key < val){
            root.right =  delete(root.right,val);
        }else if(root.key>val){
            root.left =  delete(root.left,val);
        }
        else{
            if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }else{
                int sucval = getsuccessor(root);
                root.key=sucval;
                root.right=delete(root.right,sucval);
            }
        }
        return root;
    }
    public static int getsuccessor(Node root){
        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root.key;
    }
    public static void leftview(Node root){
        
    }
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }
    public static void main(String[] args){
        Node root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 90);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);
        inorder(root);
        root = delete(root,80);
        System.out.println();
        inorder(root);
    }
}
