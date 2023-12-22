// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: On the basis of Linear Chaining, we have used one hashing function and LinkedList to implement the solution.


class MyHashMap {

    //Linked List implementation for the key, value pair
     class Node{
            int key;
            int val;
            Node next;
            public Node(int key, int value){
                this.key = key;
                this.val= value;
            }
        }

        //Step-1: Define storage for hashing methods    
        Node [] storage;

        public MyHashMap() {
            this.storage = new Node[10000];
        }

        //Define hashing function
        private int hash(int key)
        {
            return Integer.hashCode(key)% storage.length;
        }

        //Function to find key is present in LL
    private Node find(Node node, int key){
            Node curr = node;
            Node prev = null;  
            while (curr != null && curr.key!=key){
                prev = curr;
                curr = curr.next;
            }  
            return prev;  
    }

    //to insert a key value pair
    //tc:O(1)
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx] == null){
            storage[idx]= new Node(-1,-1);
        }

        Node prev = find(storage[idx],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.val = value;
        }
    }
    //value to which the specified key is mapped, or -1 if this map contains no mapping for the key
    //tc:O(1)
    public int get(int key) {
        int idx =hash(key);
        if(storage[idx]==null) return -1;
        Node prev = find(storage[idx],key);
        if(prev.next==null) return -1;
        return prev.next.val;
    }
    //void remove(key) removes the key and its corresponding value if the map contains the mapping for the key
    //tc: O(1)
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx]==null) return ;
        Node prev = find(storage[idx],key);
        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */