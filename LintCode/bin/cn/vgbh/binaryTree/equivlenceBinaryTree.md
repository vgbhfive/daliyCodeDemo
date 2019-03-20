## ArrayList中equals()方法详解

在昨天写了一个等价二叉树的算法，自己测试后使用了ArrayList的equals()方法，最后觉得这样有点草率，就今天写了这篇详解关于ArrayList的equals()方法。。。

### 源代码：

```
/**
     * Compares the specified object with this list for equality.  Returns
     * {@code true} if and only if the specified object is also a list, both
     * lists have the same size, and all corresponding pairs of elements in
     * the two lists are <i>equal</i>.  (Two elements {@code e1} and
     * {@code e2} are <i>equal</i> if {@code (e1==null ? e2==null :
     * e1.equals(e2))}.) 
     * In other words, two lists are defined to be
     * equal if they contain the same elements in the same order.<p>
     *
     * This implementation first checks if the specified object is this
     * list. If so, it returns {@code true}; if not, it checks if the
     * specified object is a list. If not, it returns {@code false}; if so,
     * it iterates over both lists, comparing corresponding pairs of
     * elements.
     * 
     * If any comparison returns {@code false}, this method returns
     * {@code false}.  If either iterator runs out of elements before the
     * other it returns {@code false} (as the lists are of unequal length);
     * otherwise it returns {@code true} when the iterations complete.
     *
     * @param o the object to be compared for equality with this list
     * @return {@code true} if the specified object is equal to this list
     */
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof List))
            return false;

        ListIterator<E> e1 = listIterator();
        ListIterator<?> e2 = ((List<?>) o).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }
```

在方法的上边注释中，你就可以了解到了equals()方法的比较范围了。

### In other words, two lists are defined to be equal if they contain the same elements in the same order.

翻译:用原话来说就是，两个集合中拥有相同的元素并且在相同的排序，那么他们就是相等的。

### equals()解释：

第一步：判断是否为同一对象。是，返回true
第二部：判断左边对象是否为右边的实例。
第三部：分别遍历两个ArrayList集合。
第四部：在while()循环中判断集合的长度是否相同，在while()内部判断元素是否相同。
第五步：跳出while()循环，判断两个集合是否相同。相同，返回true。

### 最后：
多看看源码还是很有帮助的，例如：
```
!(o1==null ? o2==null : o1.equals(o2))
```
考虑了很多种情况下的比较，这句代码写的很精辟。