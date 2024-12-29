/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author DELL
 */
public interface HashTableADT <K, V>  extends Iterable<K>{
    int size();
    //kích thước của bảng băm
    boolean isEmpty();
    //kiểm tra bảng băm có rỗng không
    int hashCodeToIndex(int hashedKey);
    //chuyển giá trị hashcode thành index
    void clear();
    //xóa toàn bộ phần tử trong bảng băm
    boolean has(K key);
    //kiểm tra key có tồn tại trong bảng băm không
    V insert(K key, V value);
    //thêm phần tử vào bảng băm
    V get(K key);
    //lấy giá trị của key
    V remove(K key);
    //xóa phần tử khỏi bảng băm
}
