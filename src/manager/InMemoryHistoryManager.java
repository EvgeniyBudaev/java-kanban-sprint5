package manager;

import tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int LIMIT_HISTORY_TASKS = 10;
//    private final List<Task> historyTasks = new LinkedList<>();
//private final Set<Task> historyTasks = new LinkedHashSet<>();
private final Map<Integer, Task> historyTasks = new HashMap<>();

    //Добавление нового просмотра задачи в историю
    @Override
    public void add(Task task) {
        if (task != null) {
            if (historyTasks.size() >= LIMIT_HISTORY_TASKS) {
                historyTasks.remove(0);
//                historyTasks.add(task);
                    historyTasks.put(task.getId(), task);
            } else {
//                historyTasks.add(task);
                  historyTasks.put(task.getId(), task);
            }
        } else {
            System.out.println("Task not found");
        }
    }

    //Удаление просмотра из истории
    @Override
    public void remove(int id) {
        historyTasks.remove(id);
    }

    @Override
    public List<Task> getHistory() {
        return new LinkedList<>(historyTasks.values());
    }
}
