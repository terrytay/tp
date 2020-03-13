package task;

import java.time.LocalDate;

public abstract class Task {

    public abstract int getPriority();

    public abstract LocalDate getDate();

    public abstract boolean hasKeyword(String keyword) throws Exception;

    public abstract String getFormattedDetails();

    public abstract String getTaskInformation();

}
