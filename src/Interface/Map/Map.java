package Interface.Map;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Interface.Map
 * @created : 2020/7/8
 * @description :
 */
public interface Map<K, V> {
    public void add(K key, V value);
    public void set(K key, V value);
    public V get(K key);
    public V remove(K key);
    public boolean contains(K key);
    public boolean isEmpty();
    public int getSize();
}
