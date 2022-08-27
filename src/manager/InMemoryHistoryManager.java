package manager;

import tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int LIMIT_HISTORY_TASKS = 10;
    private final Map<Integer, Task> historyTasks = new LinkedHashMap<>();

    // Добавление нового просмотра задачи в историю
    @Override
    public void add(Task task) {
        if (task != null) {
            if (historyTasks.size() >= LIMIT_HISTORY_TASKS) {
                historyTasks.remove(0);
                historyTasks.put(task.getId(), task);
            } else {
                historyTasks.put(task.getId(), task);
            }
        } else {
            System.out.println("Task not found");
        }
    }

    // Удаление просмотра из истории
    @Override
    public void remove(int id) {
        historyTasks.remove(id);
    }

    // Получение истории просмотров
    @Override
    public List<Task> getHistory() {
        return new LinkedList<>(historyTasks.values());
    }
}
