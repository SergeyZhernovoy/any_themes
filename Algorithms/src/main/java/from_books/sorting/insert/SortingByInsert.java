package from_books.sorting.insert;/**
 * @author Sergey Zhernovoy
 * create on 31.07.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Алгоритм сортировки вставкой. Алгоритм сортирует входны данные на месте , без привлечения дополнительной памяти
 * , выполняется перестановка чисел в пределах массива А
 */

public class SortingByInsert {
    private static final Logger logger = LoggerFactory.getLogger(SortingByInsert.class);

    private int [] arrayForSort;

    public SortingByInsert(int[] arrayForSort) {
        this.arrayForSort = arrayForSort;
    }

    public void setArrayForSort(int[] arrayForSort) {
        this.arrayForSort = arrayForSort;
    }

    public int[] getSortArrayByInsert(){

        for(int index = 2; index < this.arrayForSort.length; index++){
            int key = arrayForSort[index];
            int sortKey = key - 1;
            while(sortKey > 0 && arrayForSort[sortKey] > key){
                arrayForSort[sortKey+1] = arrayForSort[sortKey];
                sortKey--;
                arrayForSort[sortKey+1]=key;
            }
        }
        return this.arrayForSort;
    }

}

    