package app;

import controllers.controller;

public class TodoListApp {


    private static void run() {
    final controller controller = new controller();
    controller.run();
}

    public static void main(final String[] args) {
        TodoListApp.run();
    }
}

