/**
 * Задание по разработке - класс GameHelper
 *
 * @author Sheynin Vladislav
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class GameHelper {
    /**
     * Реализация обработки последовательности значений. Соседние склеиваются
     *
     * @param list - входной список для сравнения
     * @return итоговый список одинакового с входящим размера, добитый null-ами при склеивании. null-ы перенесены в конец списка
     */
    List<Integer> moveAndMergeEqual(List<Integer> list) {
        int sizeNotNullList = list.size();
        List<Integer> resultArrayList = new ArrayList<>();
        list.removeIf(Objects::isNull);
        if (list.isEmpty()) return list; //если список исходно был пустой - возвращаем сам этот список
        Iterator<Integer> listIterator = list.iterator();
        Integer element1 = listIterator.next();
        boolean lastFlag = false;//если окажется что данный элемент последний, то при выходе из цикла нужно его добавить в список
        Integer item = null;
        if (list.size() == 1) resultArrayList.add(element1); //если элемент всего один сразу записываем
        while (listIterator.hasNext()) {
            lastFlag = false;
            item = listIterator.next();
            if (Objects.equals(element1, item)) {
                resultArrayList.add(element1 * 2);
                if (listIterator.hasNext()) {
                    element1 = listIterator.next();
                    lastFlag = true; //если окажется что данный элемент последний, то при выходе из цикла нужно его добавить в список
                }
            } else {
                if (!listIterator.hasNext()) {
                    resultArrayList.add(element1);
                    resultArrayList.add(item);
                } else {
                    resultArrayList.add(element1);
                    element1 = item;
                }

            }
        }
        if (lastFlag) resultArrayList.add(element1);

        int addNull = sizeNotNullList - resultArrayList.size();
        for (int i = 0; i < addNull; i++) {
            resultArrayList.add(null);
        }
        return resultArrayList;
    }

}
