package todo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitry on 10.02.16.
 * It's test home projects
 */
class TodoDao {
    private static TodoDao instance;
    private Map<Integer, Todo> todos = new HashMap<>();

    private TodoDao() {
    }

    public static TodoDao getInstance(){
        if (instance == null){
            instance = new TodoDao();
        }
        return instance;
    }

    public Map<Integer, Todo> getTodos() {
        return todos;
    }
}
