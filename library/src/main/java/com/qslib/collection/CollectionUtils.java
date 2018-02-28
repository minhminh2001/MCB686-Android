package com.qslib.collection;

import com.qslib.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dang on 5/26/2016.
 */
public class CollectionUtils {
    private static final String TAG = CollectionUtils.class.getSimpleName();

    /**
     * convert Map<String, List<MapEntity<T>> to List<Map<T>>
     *
     * @param maps
     * @param <T>
     * @return
     */
    public static <K, T> List<MapEntity<K, T>> convertMapToList(Map<K, List<T>> maps) {
        List<MapEntity<K, T>> mapEntities = new ArrayList<>();

        try {
            if (maps != null && maps.size() > 0) {
                for (Map.Entry<K, List<T>> entry : maps.entrySet()) {
                    mapEntities.add(new MapEntity<>(entry.getKey(), entry.getValue()));
                }
            }
        } catch (Exception e) {
            Logger.e(TAG, e);
        }

        return mapEntities;
    }
}
