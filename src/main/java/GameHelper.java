/**
 * Задание по разработке - класс GameHelper
 *
 * @author Sheynin Vladislav
 */

import java.util.ArrayList;
import java.util.List;

public class GameHelper {
    /**
     * Реализация обработки последовательности значений. Соседние склеиваются
     *
     * @param list - входной список для сравнения
     * @return итоговый список одинакового с входящим размера, добитый null-ами при склеивании. null-ы перенесены в конец списка
     */
    List<Integer> moveAndMergeEqual(List<Integer> list) {
        int sizeNewlist = 0;
        List<Integer> resultArrayList = new ArrayList<>();
        //заполняю значениями которые не null
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) != null) {
                resultArrayList.add(list.get(i));
                sizeNewlist++;
            }
        //провожу объединение одинаковых элементов, удаляя один из них
        int count = 0;
        for (int i = 0; i < sizeNewlist - count; i++)
            if (resultArrayList.get(i) == resultArrayList.get(i + 1)) {
                resultArrayList.set(i + 1, resultArrayList.get(i) * 2);
                resultArrayList.remove(i);
                count++;
            }
        //добиваю размер итогового списка до исходного null-ами
        for (int i = 0; i < list.size() - sizeNewlist; i++)
            resultArrayList.add(null);
        return resultArrayList;
    }

}
