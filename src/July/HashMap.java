package July;

import java.util.ArrayList;

public class HashMap<K, V> {
    class Node {
        K key;
        V value;
        Node next;
    }

    ArrayList<Node> bucket;
    int size = 0;

    public HashMap(int n){
        bucket = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bucket.add(null);
        }
    }

    public HashMap(){
        this(4);
    }

    public void put(K key, V val){
        int index = getHashValue(key);
        Node temp = bucket.get(index);
        while (temp != null){
            if(temp.key.equals(key)){
                temp.value = val;
                size++;
                return;
            }
            temp = temp.next;
        }
        Node nn = new Node();
        nn.key = key;
        nn.value = val;
        temp = bucket.get(index);
        bucket.set(index, nn);
        nn.next = temp;
        size++;
        double loadFactor = (1.0*size) / bucket.size();
        double threshold = 2.0;
        if(loadFactor > threshold){
            rehashing();
        }
    }

    public boolean containsKey(K key){
        int index = getHashValue(key);
        Node temp = bucket.get(index);
        while (temp != null){
            if(temp.key.equals(key)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public V get(K key){
        int index = getHashValue(key);
        Node temp = bucket.get(index);
        while (temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    private int getHashValue(K key) {
        int index = key.hashCode() % bucket.size();
        if(index < 0){
            index += bucket.size();
        }
        return index;
    }

    public V remove(K key){
        int index = getHashValue(key);
        Node curr = bucket.get(index);
        Node prev = null;
        while (curr != null){
            if(curr.key.equals(key)){
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if(curr == null){
            return null;
        } else if(prev == null){
           bucket.set(index, curr.next);
           curr.next = null;
           size--;
           return curr.value;
        } else {
            prev.next = curr.next;
            size--;
            curr.next = null;
            return curr.value;
        }
    }

    private void rehashing() {
        ArrayList<Node> al = new ArrayList<>();
        for (int i = 0; i < 2* bucket.size(); i++) {
            al.add(null);
        }
        ArrayList<Node> oldBucket = bucket;
        bucket = al;
        size=0;
        for (Node temp : oldBucket){
            while (temp !=null){
                put(temp.key, temp.value);
                temp = temp.next;
            }
        }
    }

    @Override
    public String toString(){
        String res = "{";
        for (Node temp : bucket){
            while (temp !=null){
                res+=  temp.key + "=" + temp.value +", ";
                temp = temp.next;
            }
        }
        return res;
    }

}
