package com.example.fin_reg.ModelResponse.LessonsTime;

public class LesTime {
    private String lesson_object;
    private String time;

    public LesTime(String lesson_object, String time) {
        this.lesson_object = lesson_object;
        this.time = time;
    }

    public String getLesson_object() {
        return lesson_object;
    }

    public void setLesson_object(String lesson_object) {
        this.lesson_object = lesson_object;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
