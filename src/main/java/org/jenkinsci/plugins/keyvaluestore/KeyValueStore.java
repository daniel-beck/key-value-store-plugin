package org.jenkinsci.plugins.keyvaluestore;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeyValueStore {

    private final Map<String, String> values = new HashMap<String, String>();

    private static final KeyValueStore INSTANCE = new KeyValueStore();

    public static KeyValueStore getInstance() {
        return INSTANCE;
    }

    public void setValue(String key, String value) {
        this.values.put(key, value);
    }

    public Map<String, String> getValues() {
        return Collections.unmodifiableMap(values);
    }

    public String getValuesString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
