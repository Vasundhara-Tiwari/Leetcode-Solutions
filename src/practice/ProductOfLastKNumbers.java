package practice;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbers {
    List<Integer> al;
    public ProductOfLastKNumbers() {
        al = new ArrayList<Integer>();
    }

    public void add(int num) {
        al.add(num);
    }

    public int getProduct(int k) {
        if(al.size() < k)return 0;
        int product = 1;
        for(int i = al.size()-1; k > 0; i--)
        {
            product *= al.get(i);
            k--;
            if(product == 0)return 0;
        }
        return product;
    }
}
